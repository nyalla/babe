package com.babe.framework;

import java.util.HashMap;
import java.util.Map;

public class PortalStaticMaps
{
    static final Map<String, String> typeMap = new HashMap<String, String>()
    {{
        put("string", "String");
        put("int", "Integer");
        put("long", "Long");
        put("date", "Date");

    }};
}
