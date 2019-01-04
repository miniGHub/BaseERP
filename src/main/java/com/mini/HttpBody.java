package com.mini;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpBody {
    public static JSONArray getRequestJsons(HttpServletRequest req) {
        String json= null;
        JSONArray ret = null;
        try {
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(req.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }
            json= responseStrBuilder.toString();
            ret = JSONArray.parseArray(json);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static JSONObject getRequestJson(HttpServletRequest req) {
        String json= null;
        JSONObject ret = null;
        try {
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(req.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }
            json= responseStrBuilder.toString();
            ret = JSONObject.parseObject(json);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
