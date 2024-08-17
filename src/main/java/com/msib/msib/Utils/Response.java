package com.msib.msib.Utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Response {

    public Map<String, Object> success(Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", obj);
        map.put("status", 200);
        map.put("message", "success");
        return map;
    }

    public Map<String, Object> error(Object obj, Object code) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", code);
        map.put("message", obj);
        return map;
    }
}
