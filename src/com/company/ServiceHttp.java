package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ServiceHttp {

    /** Метод подключения по url к сервису
     * @return body - тело ответа
     */
    public static String getJsonString(Integer id) {

        String body = "";

        try{
            URL url = new URL(new CustomUrl(id).getUrl());

            try{
                URLConnection con = url.openConnection();
                con.addRequestProperty("User-Agent",
                        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
                InputStream in = con.getInputStream();
                body = convertStreamToString(in);
            }catch (IOException e){
                body = e.getMessage();
            }
        }catch(MalformedURLException ex){
            body = ex.getMessage();
        }
        return body;
    }

    /** Метод конвертирования потока в строку
     * @return sb - тело ответа
     */
    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();

    }
}
