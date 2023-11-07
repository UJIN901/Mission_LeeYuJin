package com.ll;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    String cmd;
    String action;
    String queryString;
    Map<String, String> paramsMap;

    Rq(String cmd) {
        paramsMap = new HashMap<>();

        this.cmd = cmd;

        String[] cmdBits = cmd.split("\\?", 2);
        action = cmdBits[0].trim();

        if (cmdBits.length == 1 || cmdBits[1].isEmpty()) {
            return;
        }
        queryString = cmdBits[1].trim();

        String[] queryStringBits = queryString.split("&");
        for (String str : queryStringBits) {
            String[] queryStringBit = str.split("=", 2);

            if (queryStringBit.length != 2 || queryStringBit[0].isEmpty() || queryStringBit[1].isEmpty()) {
                return;
            }
            String queryName = queryStringBit[0].trim();
            String queryValue = queryStringBit[1].trim();

            paramsMap.put(queryName, queryValue);
        }
    }

    String getAction() {
        return action;
    }

    int getParamAsInt(String paramName, int defaultValue) {
        String paramValue = paramsMap.get(paramName);
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
