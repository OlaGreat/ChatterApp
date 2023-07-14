package com.example.chatterapp.appUtils;

public class Utils {
    private static int id;

    public static long generateId(){
        return id++;
    }
}
