package sample.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ruslanzigansin on 26.05.16.
 */
public class Validation {
    public static boolean validateNumber(String number){
        try{
            Integer.parseInt(number);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }



    public static boolean validateEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean validateTelephone(String word) {
        String ePattern = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        Pattern p = java.util.regex.Pattern.compile(ePattern);
        Matcher m = p.matcher(word);
        return m.matches();
    }


}
