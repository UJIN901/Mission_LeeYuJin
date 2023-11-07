package com.ll.standard.util;

public class Ut {
    public static class str{
        public static int parseInt(String paramValue, int defaultValue){
            if (paramValue != null) {
                try {
                    return Integer.parseInt(paramValue);
                } catch (NumberFormatException e) {
                    return defaultValue;
                }
            }
            return defaultValue;
        }
    }
}
