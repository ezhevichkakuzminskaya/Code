package org.example;

import org.example.convert.Mr2313Converter;
import org.example.searadar.mr231.convert.Mr231Converter;
import org.example.searadar.mr231.station.Mr231StationType;
import org.example.station.Mr2313StationType;
import ru.oogis.searadar.api.message.SearadarStationMessage;

import java.util.List;

/**
 * Практическое задание направлено на проверку умения создавать функциональные модули и работать с технической
 * документацией.
 * Задача написать парсер сообщений для протокола МР-231-3 на основе парсера МР-231.
 * Приложение к заданию файлы:
 * - Протокол МР-231.docx
 * - Протокол МР-231-3.docx
 * <p>
 * Требования:
 * 1. Перенести контрольный пример из "Протокола МР-231.docx" в метод main, по образцу в методе main;
 * 2. Проверить правильность работы конвертера путём вывода контрольного примера в консоль, по образцу в методе main;
 * 3. Создать модуль с именем mr-231-3 и добавить его в данный проект <module>../mr-231-3</module> и реализовать его
 * функционал в соответствии с "Протоколом МР-231-3.docx" на подобии модуля mr-231;
 * 4. Создать для модуля контрольный пример и проверить правильность работы конвертера путём вывода контрольного
 * примера в консоль
 *
 * <p>
 *     Примечание:
 *     1. Данные в пакете ru.oogis не изменять!!!
 *     2. Весь код должен быть покрыт JavaDoc
 */

public class App {
    public static void main(String[] args) {
        // Контрольный пример для МР-231
        String mr231_TTM = "$RATTM,66,28.71,341.1,T,57.6,024.5,T,0.4,4.1,N,b,L,,457362,А*42";
        String mr231_VHW = "$RAVHW,115.6,T,,,46.0,N,,*71";
        String mr231_RSD = "$RARSD,36.5,331.4,8.4,320.6,,,,,11.6,185.3,96.0,N,N,S*33";

        // Проверка работы конвертера для МР-231
        Mr231StationType mr231 = new Mr231StationType();
        Mr231Converter converter = mr231.createConverter();
        List<SearadarStationMessage> searadarMessages = converter.convert(mr231_TTM);
        System.out.println("МР-231 TTM:");
        searadarMessages.forEach(System.out::println);

        searadarMessages = converter.convert(mr231_VHW);
        System.out.println("МР-231 VHW:");
        searadarMessages.forEach(System.out::println);

        searadarMessages = converter.convert(mr231_RSD);
        System.out.println("МР-231 RSD:");
        searadarMessages.forEach(System.out::println);


        // Контрольный пример для МР-231-3
        String mr2313_TTM = "$RATTM,12,15.25,270.5,T,35.2,135.8,T,1.9,7.6,N,p,Q,,123456,A*78";
        String mr2313_RSD = "$RARSD,50.5,309.9,64.8,132.3,,,,,52.6,155.0,48.0,K,N,S*28";

        // Проверка работы конвертера для МР-231-3
        Mr2313StationType mr2313= new Mr2313StationType();
        Mr2313Converter converter3 = mr2313.createConverter();
        List<SearadarStationMessage> searadarMessages3 = converter3.convert(mr2313_TTM);
        System.out.println("МР-231-3 TTM:");
        searadarMessages3.forEach(System.out::println);

        searadarMessages3 = converter3.convert(mr2313_RSD);
        System.out.println("МР-231-3 RSD:");
        searadarMessages3.forEach(System.out::println);
    }
}
