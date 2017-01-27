package br.com.rmatos.myframework;

/**
 * Created by renato on 27/01/17.
 */

public class StringHelper {
    public static String extractNumbers(String str){
        return str.replaceAll("[^0-9]", "");
    }
}
