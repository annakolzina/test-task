package com.company;

public class CustomUrl {

    /** Поле ссылка */
    private String url = "https://reqres.in/api/user/";


    public String getUrl() {
        return url;
    }

    /** Метод добавляет к строке введенный id */
    public CustomUrl(Integer id){
        this.url += id;
    }
}
