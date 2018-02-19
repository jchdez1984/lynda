package com.lynda.training.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by juan.hernandez on 2/19/18.
 */
public class InputHelper {
    public static String getInput(String prompt){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(prompt);
        System.out.flush();

        try{
            return reader.readLine();
        } catch (Exception e){
            return "Error: " + e.getMessage();
        }
    }

    public static double getDoubleInput(String prompt) throws  NumberFormatException{
        String input = getInput(prompt);
        return Double.parseDouble(input);
    }
}
