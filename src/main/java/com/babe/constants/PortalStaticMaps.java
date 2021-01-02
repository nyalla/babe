package com.babe.constants;

import java.util.HashMap;
import java.util.Map;

public class PortalStaticMaps
{
    public static final Map<String, String> typeMap = new HashMap<String, String>()
    {{
        put("string", "String");
        put("int", "Integer");
        put("long", "Long");
        put("date", "Date");
        put("timestamp", "timestamp");

    }};

    public static final String getJpaTimeStampAnnotation(int type)
    {
        switch (type)
        {
            case 1:
                return "@CreationTimestamp";
            case 2:
                return "@UpdateTimestamp";
            default:
                return null;
        }
    }
}
