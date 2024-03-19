package org.example.station;

import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.example.convert.Mr2313Converter;

import java.nio.charset.Charset;

/**
 * Класс, представляющий тип станции МР-231-3.
 */
public class Mr2313StationType {
    // Константы для типа станции и имени кодека
    private static final String STATION_TYPE = "МР-231-3";
    private static final String CODEC_NAME = "mr2313";

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
     * @return экземпляр конвертера Mr2313Converter
     */
    public Mr2313Converter createConverter() {
        return new Mr2313Converter();
    }
}
