package org.example.convert;

import org.apache.camel.Exchange;
import ru.oogis.searadar.api.convert.SearadarExchangeConverter;
import ru.oogis.searadar.api.message.*;
import ru.oogis.searadar.api.types.IFF;
import ru.oogis.searadar.api.types.TargetStatus;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Mr2313Converter implements SearadarExchangeConverter {

    /**
     * Массив значений масштаба расстояния.
     */
    private static final Double[] DISTANCE_SCALE = {0.125, 0.25, 0.5, 1.5, 3.0, 6.0, 12.0, 24.0, 48.0, 96.0};

    /**
     * Массив полей сообщения и тип сообщения.
     */
    private String[] fields;
    private String msgType;

    /**
     * Конвертирует сообщение из объекта обмена.
     * @param exchange объект обмена
     * @return список сообщений станции морского радара
     */
    @Override
    public List<SearadarStationMessage> convert(Exchange exchange) {
        return convert(exchange.getIn().getBody(String.class));
    }

    /**
     * Конвертирует строку сообщения в список сообщений станции морского радара.
     */
    public List<SearadarStationMessage> convert(String message) {

        List<SearadarStationMessage> msgList = new ArrayList<>();

        if (message == null || message.isEmpty()) {
            // Возвращаем пустой список, если сообщение null или пустое
            return msgList;
        }
        readFields(message); // Читаем и обрабатываем поле сообщения

        switch (msgType) {

            case "TTM" :
                msgList.add(getTTM()); // Добавляем сообщение о цели
                break;

            case "RSD" : {
                RadarSystemDataMessage3 rsd = getRSD(); // Получаем сообщение о системе радара
                InvalidMessage invalidMessage = checkRSD(rsd);

                if (invalidMessage != null)  msgList.add(invalidMessage);
                else msgList.add(rsd);
                break;
            }

        }

        return msgList;
    }

    /**
     * Читает и обрабатывает поля сообщения.
     * @param msg сообщение для обработки
     */
    private void readFields(String msg) {
        // Извлекаем подстроку из сообщения с полями, удаляем лишние пробелы
        String temp = msg.substring(3, msg.indexOf("*")).trim();

        // Разбиваем строку на поля с помощью разделителя ","
        fields = temp.split(Pattern.quote(","));
        // Получаем тип сообщения из первого поля
        msgType = fields[0];
    }

    /**
     * Создает и заполняет объект TrackedTargetMessage3 на основе переданного сообщения.
     * @return объект TrackedTargetMessage3
     */
    private TrackedTargetMessage3 getTTM() {
        TrackedTargetMessage3 ttm = new TrackedTargetMessage3();
        Long msgRecTimeMillis = System.currentTimeMillis();

        // Установка метки времени получения сообщения
        ttm.setMsgRecTime(new Timestamp(System.currentTimeMillis()));
        ttm.setMsgTime(msgRecTimeMillis);
        // Установка номера цели
        ttm.setTargetNumber(Integer.parseInt(fields[1]));
        // Установка расстояния до цели
        ttm.setDistance(Double.parseDouble(fields[2]));
        // Установка пеленга на цель
        ttm.setBearing(Double.parseDouble(fields[3]));
        // Установка признака истинного пеленга
        ttm.setTrueBearing(fields[4].equals("T"));
        // Установка скорости цели
        ttm.setSpeed(Double.parseDouble(fields[5]));
        // Установка курса цели
        ttm.setCourse(Double.parseDouble(fields[6]));
        // Установка признака истинного курса
        ttm.setTrueCourse(fields[7].equals("T"));
        // Установка дистанции в точке кратчайшего сближения
        ttm.setClosestApproachDistance(Double.parseDouble(fields[8]));
        // Установка времени до точки кратчайшего сближения
        ttm.setApproachTime(Double.parseDouble(fields[9]));
        // Установка единиц измерения расстояния
        ttm.setDistanceUnit(fields[10]);

        // Определение признака опознавания цели
        IFF iff = IFF.UNKNOWN;
        switch (fields[11]) {
            case "b": iff = IFF.FRIEND; break;
            case "p": iff = IFF.FOE; break;
            case "d": iff = IFF.UNKNOWN; break;
        }
        ttm.setIff(iff);

        // Определение статуса цели
        TargetStatus status = TargetStatus.UNRELIABLE_DATA;
        switch (fields[12]) {
            case "L": status = TargetStatus.LOST; break;
            case "Q": status = TargetStatus.UNRELIABLE_DATA; break;
            case "T": status = TargetStatus.TRACKED; break;
        }
        ttm.setStatus(status);

        // Установка интервала времени между сигналом «Север» и моментом зондирования цели НРЛС
        ttm.setTimeDifference(Long.parseLong(fields[14]));
        // Установка признака автосопровождения
        ttm.setAutoTracking(fields[14].equals("A"));

        return ttm;
    }

    /**
     * Создает объект RadarSystemDataMessage3 на основе данных из массива fields.
     */
    private RadarSystemDataMessage3 getRSD() {
        // Создаем новый объект RadarSystemDataMessage3
        RadarSystemDataMessage3 rsd = new RadarSystemDataMessage3();
        // Устанавливаем текущее время в качестве времени получения сообщения
        rsd.setMsgRecTime(new Timestamp(System.currentTimeMillis()));
        // Начальное расстояние
        rsd.setInitialDistance(Double.parseDouble(fields[1]));
        // Начальный пеленг
        rsd.setInitialBearing(Double.parseDouble(fields[2]));
        // Радиус движущегося круга расстояния
        rsd.setMovingCircleOfDistance(Double.parseDouble(fields[3]));
        // Пеленг
        rsd.setBearing(Double.parseDouble(fields[4]));
        // Расстояние от корабля
        rsd.setDistanceFromShip(Double.parseDouble(fields[9]));
        // Пеленг 2
        rsd.setBearing2(Double.parseDouble(fields[10]));
        // Масштаб расстояния
        rsd.setDistanceScale(Double.parseDouble(fields[11]));
        // Единицы измерения расстояния
        rsd.setDistanceUnit(fields[12]);
        // Ориентация дисплея
        rsd.setDisplayOrientation(fields[13]);
        // Рабочий режим
        rsd.setWorkingMode(fields[14]);
        // Возвращаем созданный объект RadarSystemDataMessage3
        return rsd;
    }

    /**
     * Проверяет корректность сообщения о системе радара (RSD).
     */
    private InvalidMessage checkRSD(RadarSystemDataMessage3 rsd) {
        InvalidMessage invalidMessage = new InvalidMessage();
        String infoMsg = "";

        // Проверяем, содержит ли список допустимых значений масштаба расстояния значение из сообщения
        if (!Arrays.asList(DISTANCE_SCALE).contains(rsd.getDistanceScale())) {
            // Формируем сообщение об ошибке с указанием неправильного значения масштаба расстояния
            infoMsg = "RSD message. Wrong distance scale value: " + rsd.getDistanceScale();
            // Устанавливаем информационное сообщение об ошибке в объект InvalidMessage
            invalidMessage.setInfoMsg(infoMsg);
            // Возвращаем объект InvalidMessage, так как обнаружена ошибка
            return invalidMessage;
        }

        // Возвращаем null, если сообщение о системе радара корректно
        return null;
    }
}

