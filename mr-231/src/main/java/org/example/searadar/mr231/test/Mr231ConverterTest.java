package org.example.searadar.mr231.test;

import org.example.searadar.mr231.convert.Mr231Converter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.oogis.searadar.api.message.RadarSystemDataMessage;
import ru.oogis.searadar.api.message.SearadarStationMessage;
import ru.oogis.searadar.api.message.TrackedTargetMessage;
import ru.oogis.searadar.api.message.WaterSpeedHeadingMessage;
import ru.oogis.searadar.api.types.IFF;
import ru.oogis.searadar.api.types.TargetStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Mr231ConverterTest {
    private Mr231Converter converter;

    @BeforeEach
    public void setUp() {
        converter = new Mr231Converter();
    }

    @Test
    public void testConvertValidTTMMessage() {
        // Создаем строку с сообщением
        String ttmMessage = "$RATTM,12,15.25,270.5,T,35.2,135.8,T,1.9,7.6,N,p,Q,,123456,A*78";

        // Конвертируем сообщение в список сообщений
        List<SearadarStationMessage> messages = converter.convert(ttmMessage);

        // Проверяем, что список сообщений не пустой и содержит одно сообщение
        assertNotNull(messages);
        assertEquals(1, messages.size());

        // Получаем первое сообщение из списка
        SearadarStationMessage message = messages.get(0);
        assertNotNull(message.getMsgRecTime());
        assertEquals(TrackedTargetMessage.class, message.getClass());

        // Приводим сообщение к типу TrackedTargetMessage для дальнейших проверок
        TrackedTargetMessage ttm = (TrackedTargetMessage) message;

        // Сравниваем поля фактического объекта с полями ожидаемого объекта
        assertEquals(12, ttm.getTargetNumber());
        assertEquals(15.25, ttm.getDistance(), 0.01);
        assertEquals(270.5, ttm.getBearing(), 0.01);
        assertEquals(35.2, ttm.getSpeed(), 0.01);
        assertEquals(135.8, ttm.getCourse(), 0.01);
        assertEquals(IFF.FOE, ttm.getIff());
        assertEquals(TargetStatus.UNRELIABLE_DATA, ttm.getStatus());
    }

    @Test
    public void testConvertValidVHWMessage() {
        String vhwMessage = "$RAVHW,115.6,T,,,46.0,N,,*71";
        List<SearadarStationMessage> messages = converter.convert(vhwMessage);

        assertNotNull(messages);
        assertEquals(1, messages.size());

        WaterSpeedHeadingMessage vhw = (WaterSpeedHeadingMessage) messages.get(0);
        assertNotNull(vhw.getMsgRecTime());
        assertEquals(115.6, vhw.getCourse(), 0.01);
        assertEquals('T', vhw.getCourseAttr().charAt(0));
        assertEquals(46.0, vhw.getSpeed(), 0.01);
        assertEquals("N", vhw.getSpeedUnit());
    }
    @Test
    public void testConvertValidRSDMessage() {
        // Создаем сообщение RSD для тестирования
        String rsdMessage = "$RARSD,50.5,309.9,64.8,132.3,,,,,52.6,155.0,48.0,K,N,S*28";

        // Конвертируем сообщение
        List<SearadarStationMessage> messages = converter.convert(rsdMessage);

        // Проверяем, что список сообщений не пустой
        assertNotNull(messages);
        // Ожидаем, что в списке будет одно сообщение
        assertEquals(1, messages.size());

        // Получаем первое сообщение из списка
        SearadarStationMessage message = messages.get(0);
        // Проверяем, что у сообщения есть время получения
        assertNotNull(message.getMsgRecTime());
        // Ожидаем, что класс сообщения будет RadarSystemDataMessage3
        assertEquals(RadarSystemDataMessage.class, message.getClass());

        // Приводим сообщение к типу RadarSystemDataMessage3 для дальнейших проверок
        RadarSystemDataMessage rsd = (RadarSystemDataMessage) message;

        // Проверяем значения полей сообщения RSD
        assertEquals(50.5, rsd.getInitialDistance(), 0.01);
        assertEquals(309.9, rsd.getInitialBearing(), 0.01);
        assertEquals(64.8, rsd.getMovingCircleOfDistance(), 0.01);
        assertEquals(132.3, rsd.getBearing(), 0.01);
        assertEquals(52.6, rsd.getDistanceFromShip(), 0.01);
        assertEquals(155.0, rsd.getBearing2(), 0.01);
        assertEquals(48.0, rsd.getDistanceScale(), 0.01);
        assertEquals("K", rsd.getDistanceUnit());
        assertEquals("N", rsd.getDisplayOrientation());
        assertEquals("S", rsd.getWorkingMode());
    }
    @Test
    public void testConvertInvalidMessage() {
        // Некорректное сообщение, не соответствующее формату TTM или RSD , VHW
        String invalidMessage = "$INVALIDMSG,1,2,3,4,5*AB";
        List<SearadarStationMessage> messages = converter.convert(invalidMessage);

        assertNotNull(messages);
        assertEquals(0, messages.size()); // Ожидаем, что некорректное сообщение не будет конвертировано
    }

    @Test
    public void testConvertEmptyMessage() {
        // Пустое сообщение
        String emptyMessage = "";
        List<SearadarStationMessage> messages = converter.convert(emptyMessage);

        assertNotNull(messages);
        assertEquals(0, messages.size()); // Ожидаем, что пустое сообщение не будет конвертировано
    }
}
