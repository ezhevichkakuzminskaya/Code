package ru.oogis.searadar.api.message;

import java.sql.Timestamp;

public class RadarSystemDataMessage3 extends SearadarStationMessage{

    private Double initialDistance; // Начальное расстояние
    private Double initialBearing; // Начальный пеленг
    private Double movingCircleOfDistance; // Движущийся круг расстояния
    private Double bearing; // Пеленг
    private Double distanceFromShip; // Расстояние от судна
    private Double bearing2; // Пеленг 2
    private Double distanceScale; // Масштаб расстояния
    private String distanceUnit; // Единицы измерения расстояния
    private String displayOrientation; // Ориентация дисплея
    private String workingMode; // Рабочий режим


    /**
     * Конструктор по умолчанию для создания объекта RadarSystemDataMessage3.
     */
    public RadarSystemDataMessage3() {

    }

    /**
     * Устанавливает время сообщения в миллисекундах.
     */
    public void setMsgTime(long l) {
    }

    /**
     * Переопределение метода getMsgRecTime для получения времени записи сообщения.
     */
    @Override
    public Timestamp getMsgRecTime() {return super.getMsgRecTime();}
    @Override
    public void setMsgRecTime(Timestamp msgRecTime) {super.setMsgRecTime(msgRecTime); }

    /**
     * Получает и устанавливает начальное расстояние.
     */
    public Double getInitialDistance() { return initialDistance; }
    public void setInitialDistance(Double initialDistance) { this.initialDistance = initialDistance;}

    /**
     * Получает и устанавливает начальный пеленг.
     */
    public Double getInitialBearing() {return initialBearing;}
    public void setInitialBearing(Double initialBearing) {this.initialBearing = initialBearing; }

    /**
     * Получает и устанавливает расстояние движущегося круга.
     */
    public Double getMovingCircleOfDistance() {return movingCircleOfDistance;}
    public void setMovingCircleOfDistance(Double movingCircleOfDistance) {this.movingCircleOfDistance = movingCircleOfDistance; }

    /**
     * Получает и устанавливает пеленг.
     */
    public Double getBearing() { return bearing;}
    public void setBearing(Double bearing) {this.bearing = bearing; }

    /**
     * Получает и устанавливает расстояние от корабля.
     */
    public Double getDistanceFromShip() {return distanceFromShip;}
    public void setDistanceFromShip(Double distanceFromShip) {this.distanceFromShip = distanceFromShip;}

    /**
     * Получает и устанавливает второй пеленг.
     */
    public Double getBearing2() { return bearing2;}
    public void setBearing2(Double bearing2) { this.bearing2 = bearing2;}

    /**
     * Получает и устанавливает масштаб расстояния.
     */
    public Double getDistanceScale() {return distanceScale;}
    public void setDistanceScale(Double distanceScale) { this.distanceScale = distanceScale; }

    /**
     * Получает и устанавливает единицы измерения расстояния.
     */
    public String getDistanceUnit() {return distanceUnit;}
    public void setDistanceUnit(String distanceUnit) { this.distanceUnit = distanceUnit;}

    /**
     * Получает и устанавливает ориентацию дисплея.
     */
    public String getDisplayOrientation() {return displayOrientation;}
    public void setDisplayOrientation(String displayOrientation) {this.displayOrientation = displayOrientation;}

    /**
     * Получает и устанавливает рабочий режим.
     */
    public String getWorkingMode() {return workingMode; }
    public void setWorkingMode(String workingMode) { this.workingMode = workingMode; }


    /**
     * Переопределение метода toString для создания строкового представления объекта RadarSystemDataMessage3.
     * Возвращает строку, содержащую значения всех полей объекта.
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return "RadarSystemData{" +
                "msgRecTime=" + getMsgRecTime() +
                ", initialDistance=" + initialDistance +
                ", initialBearing=" + initialBearing +
                ", movingCircleOfDistance=" + movingCircleOfDistance +
                ", bearing=" + bearing +
                ", distanceFromShip=" + distanceFromShip +
                ", bearing2=" + bearing2 +
                ", distanceScale=" + distanceScale +
                ", distanceUnit=" + distanceUnit +
                ", displayOrientation=" + displayOrientation +
                ", workingMode=" + workingMode +
                '}';
    }
}
