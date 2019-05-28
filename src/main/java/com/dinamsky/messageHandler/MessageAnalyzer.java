package com.dinamsky.messageHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageAnalyzer {

    public MessageAnalyzer(){}

    /**
     *   Коллекция для хранение ответов бота по ключу.
     */
    private static Map<String, String> botAnswersList = new HashMap<>();

    static{
        botAnswersList.put("help", "Бот умеет проверять для тебя новости.%0A" +
                "%0AСписок команд:%0AПривет%0AКак дела?%0AПроверь новость!");
        botAnswersList.put("привет", "Привет, человек!");
        botAnswersList.put("как дела?", "ЗАМЕЧАТЕЛЬНО! Хочешь проверить новость, напиши 'проверь новость'");
    }

    /**
     *   Коллекция id music videos
     */
    private static List<String> newsList = new ArrayList<>();

    static{
        newsList.add("456239092");
        newsList.add("456239093");
        newsList.add("456239094");
        newsList.add("456239095");
        newsList.add("456239096");
        newsList.add("456239097");
        newsList.add("456239098");
        newsList.add("456239099");
        newsList.add("456239100");
        newsList.add("456239101");
        newsList.add("456239102");
        newsList.add("456239103");
        newsList.add("456239104");
        newsList.add("456239105");


    }



    public String getBotAnswer(String message){
        message = message.toLowerCase();
        String answer = "Я тебя не понимаю, человек. Если нужен список команд, напиши 'help'";
        if(message.contains("help")){
            answer = botAnswersList.get("help");
        }
        if(message.contains("как")){
            if(message.contains("дела")){
                answer = botAnswersList.get("как дела?");
            }
        } else if(message.contains("привет")){
            answer = botAnswersList.get("привет");
        } else if(message.contains("Новость проверена")){
            answer = "Вот информация о новости!&attachment=news172635477_" + getValidNews();
        }
        answer = answer.replace(" ", "+");
        return answer;
    }


    /**
     * Генерирует случайное число в пределах от 0 до размера массива (хранящего id music videos).
     * @return String;
     */
    private String getValidNews(){
        int newsIndex = (int) (Math.random() * newsList.size());
        return newsList.get(newsIndex);
    }
}
