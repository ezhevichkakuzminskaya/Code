package ru.oogis.searadar.api.message;

/**
 * Класс, представляющий невалидное сообщение в системе морского радара.
 * Наследуется от класса SearadarStationMessage.
 */
public class InvalidMessage extends SearadarStationMessage{

    private String infoMsg; // Информационное сообщение об ошибке

    /**
     * Метод для получения информационного сообщения об ошибке.
     * @return информационное сообщение об ошибке
     */
    public String getInfoMsg() {
        return infoMsg;
    }

    /**
     * Метод для установки информационного сообщения об ошибке.
     * @param infoMsg информационное сообщение об ошибке
     */
    public void setInfoMsg(String infoMsg) {
        this.infoMsg = infoMsg;
    }

}

