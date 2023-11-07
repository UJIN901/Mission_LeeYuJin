package com.ll.domain;

import com.ll.standard.util.Ut;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String cmd;
    @Getter
    private String action;
    private String queryString;
    private Map<String, String> paramsMap;

    public Rq(String cmd) {
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

    public int getParamAsInt(String paramName, int defaultValue) {
        return Ut.str.parseInt(paramsMap.get(paramName), defaultValue);
    }
}
