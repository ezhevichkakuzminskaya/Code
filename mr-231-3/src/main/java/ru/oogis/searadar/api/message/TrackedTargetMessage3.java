package ru.oogis.searadar.api.message;

import ru.oogis.searadar.api.types.IFF;
import ru.oogis.searadar.api.types.TargetStatus;

public class TrackedTargetMessage3 extends SearadarStationMessage {
    private Long msgTime; // Метка времени сообщения
    private Integer targetNumber; // Номер цели
    private Double distance; // Расстояние до цели
    private Double bearing; // Пеленг на цель
    private Double course; // Курс цели
    private Double speed; // Скорость цели
    private boolean trueBearing; // Признак истинного пеленга
    private boolean trueCourse; // Признак истинного курса
    private double closestApproachDistance; // Дистанция в точке кратчайшего сближения
    private String distanceUnit; // Единицы измерения расстояния
    private TargetStatus status; // Статус цели
    private boolean autoTracking; // Признак автосопровождения цели
    private long timeDifference; // Интервал времени между сигналом "Север" и моментом зондирования цели НРЛС
    private IFF iff; // Признак опознавания цели
    private double approachTime; // Время до точки кратчайшего сближения

    /**
     * Создает новый экземпляр класса TrackedTargetMessage3.
     */
    public TrackedTargetMessage3() {
    }

    /**
     * Получить метку времени сообщения.
     * @return Метка времени сообщения.
     */
    public Long getMsgTime() {
        return msgTime;
    }

    /**
     * Установить метку времени сообщения.
     * @param msgTime Метка времени сообщения.
     */
    public void setMsgTime(Long msgTime) {
        this.msgTime = msgTime;
    }

    /**
     * Возвращает номер цели.
     * @return Номер цели.
     */
    public Integer getTargetNumber() {
        return targetNumber;
    }

    /**
     * Устанавливает номер цели.
     * @param targetNumber Номер цели.
     */
    public void setTargetNumber(Integer targetNumber) {
        this.targetNumber = targetNumber;
    }

    /**
     * Возвращает расстояние до цели.
     * @return Расстояние до цели.
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * Устанавливает расстояние до цели.
     * @param distance Расстояние до цели.
     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    /**
     * Возвращает пеленг на цель.
     * @return Пеленг на цель.
     */
    public Double getBearing() {
        return bearing;
    }

    /**
     * Устанавливает пеленг на цель.
     * @param bearing Пеленг на цель.
     */
    public void setBearing(Double bearing) {
        this.bearing = bearing;
    }

    /**
     * Возвращает курс цели.
     * @return Курс цели.
     */
    public Double getCourse() {
        return course;
    }

    /**
     * Устанавливает курс цели.
     * @param course Курс цели.
     */
    public void setCourse(Double course) {
        this.course = course;
    }

    /**
     * Возвращает скорость цели.
     * @return Скорость цели.
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * Устанавливает скорость цели.
     * @param speed Скорость цели.
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * Проверяет, является ли пеленг на цель истинным.
     * @return true, если пеленг на цель истинный, иначе false.
     */
    public boolean isTrueBearing() {
        return trueBearing;
    }

    /**
     * Устанавливает признак истинного пеленга на цель.
     * @param trueBearing Признак истинного пеленга на цель.
     */
    public void setTrueBearing(boolean trueBearing) {
        this.trueBearing = trueBearing;
    }

    /**
     * Проверяет, является ли курс цели истинным.
     * @return true, если курс цели истинный, иначе false.
     */
    public boolean isTrueCourse() {
        return trueCourse;
    }

    /**
     * Устанавливает признак истинного курса цели.
     * @param trueCourse Признак истинного курса цели.
     */
    public void setTrueCourse(boolean trueCourse) {
        this.trueCourse = trueCourse;
    }

    /**
     * Возвращает дистанцию в точке кратчайшего сближения с целью.
     * @return Дистанция в точке кратчайшего сближения с целью.
     */
    public double getClosestApproachDistance() {
        return closestApproachDistance;
    }

    /**
     * Устанавливает дистанцию в точке кратчайшего сближения с целью.
     * @param closestApproachDistance Дистанция в точке кратчайшего сближения с целью.
     */
    public void setClosestApproachDistance(double closestApproachDistance) {
        this.closestApproachDistance = closestApproachDistance;
    }

    /**
     * Возвращает единицы измерения расстояния.
     * @return Единицы измерения расстояния.
     */
    public String getDistanceUnit() {
        return distanceUnit;
    }

    /**
     * Устанавливает единицы измерения расстояния.
     * @param distanceUnit Единицы измерения расстояния.
     */
    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    /**
     * Возвращает статус цели.
     * @return Статус цели.
     */
    public TargetStatus getStatus() {
        return status;
    }

    /**
     * Устанавливает статус цели.
     * @param status Статус цели.
     */
    public void setStatus(TargetStatus status) {
        this.status = status;
    }

    /**
     * Проверяет, активировано ли автосопровождение цели.
     * @return true, если автосопровождение цели активировано, иначе false.
     */
    public boolean isAutoTracking() {
        return autoTracking;
    }

    /**
     * Устанавливает признак активации автосопровождения цели.
     * @param autoTracking Признак активации автосопровождения цели.
     */
    public void setAutoTracking(boolean autoTracking) {
        this.autoTracking = autoTracking;
    }

    /**
     * Возвращает время между сигналом "Север" и моментом зондирования цели радаром.
     * @return Время между сигналом "Север" и моментом зондирования цели радаром.
     */
    public long getTimeDifference() {
        return timeDifference;
    }

    /**
     * Устанавливает время между сигналом "Север" и моментом зондирования цели радаром.
     * @param timeDifference Время между сигналом "Север" и моментом зондирования цели радаром.
     */
    public void setTimeDifference(long timeDifference) {
        this.timeDifference = timeDifference;
    }

    /**
     * Получить время до точки кратчайшего сближения с целью.
     * @return Время до точки кратчайшего сближения с целью.
     */
    public double getApproachTime() {
        return approachTime >= 10.0 ? 9.9 : approachTime;
    }

    /**
     * Установить время до точки кратчайшего сближения с целью.
     * @param approachTime Время до точки кратчайшего сближения с целью.
     */
    public void setApproachTime(double approachTime) {
        this.approachTime = approachTime >= 10.0 ? 9.9 : approachTime;
    }

    /**
     * Получить признак опознавания цели (IFF - Identification Friend or Foe).
     * @return Признак опознавания цели (IFF).
     */
    public IFF getIff() {
        return iff;
    }

    /**
     * Установить признак опознавания цели (IFF - Identification Friend or Foe).
     * @param iff Признак опознавания цели (IFF).
     */
    public void setIff(IFF iff) {
        this.iff = iff;
    }

    /**
     * Переопределение метода toString для предоставления строкового представления объекта TrackedTargetMessage3.
     * @return Строковое представление объекта TrackedTargetMessage3.
     */

    @Override
    public String toString() {
        return "TrackedTargetMessage{" +
                "msgTime=" + getMsgRecTime() +
                ", targetNumber=" + targetNumber +
                ", distance=" + distance +
                ", bearing=" + bearing +
                ", trueBearing=" + trueBearing +
                ", speed=" + speed +
                ", course=" + course +
                ", trueCourse=" + trueCourse +
                ", closestApproachDistance=" + closestApproachDistance +
                ", approachTime=" + approachTime +
                ", distanceUnit=" + distanceUnit +
                ", iff=" + iff +
                ", status=" + status +
                ", timeDifference=" + timeDifference +
                '}';
    }
}
