package com.company;

import com.google.gson.Gson;
import java.util.Map;

public class ServiceParser {

    /** Поле результат */
    private static Map result;

    /** Метод конвертирования строки в объект java */
    public static void parseJson(String jsonString) {
        if (jsonString.indexOf('{') == 0 ) {
            Map jsonJavaObject = new Gson().fromJson(jsonString, Map.class);
            result = jsonJavaObject;
        }
    }

    /** Метод разбирает коллекцию и находит нужный тег
     * @return name
     */
    public static String getName(String jsonString){
        parseJson(jsonString);
        try{
            return  (String) (
                    (Map)
                            (
                                    result.get("data")
                            )
            ).get("name");
        }catch (NullPointerException e){

            return "User not found!";
        }
    }
}
