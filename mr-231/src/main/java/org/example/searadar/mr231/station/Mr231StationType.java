package org.example.searadar.mr231.station;

import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.example.searadar.mr231.convert.Mr231Converter;

import java.nio.charset.Charset;

/**
 * Класс, представляющий тип станции МР-231.
 */
public class Mr231StationType {

    // Константы для типа станции и имени кодека
    private static final String STATION_TYPE = "МР-231";
    private static final String CODEC_NAME = "mr231";

    /**
     * Метод инициализации, создающий фабрику кодеков для обработки сообщений.
     */
    protected void doInitialize() {
        TextLineCodecFactory textLineCodecFactory = new TextLineCodecFactory(
                Charset.defaultCharset(), // Используем кодировку по умолчанию
                LineDelimiter.UNIX, // Разделитель строк Unix-style
                LineDelimiter.CRLF // Разделитель строк Windows-style
        );
    }

    /**
     * Метод для создания экземпляра конвертера для данного типа станции.
     *
     * @return экземпляр конвертера Mr231Converter
     */
    public Mr231Converter createConverter() {
        return new Mr231Converter();
    }
}
