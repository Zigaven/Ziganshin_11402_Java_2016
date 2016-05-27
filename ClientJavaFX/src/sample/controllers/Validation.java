package sample.controllers;

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

    public static boolean validateDouble(String number){
        try{
            Double.parseDouble(number);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
