package com.babe.framework;

public class ConvertUtil
{
    public static String firstLetterCapital(String s)
    {
        return s.substring(0, 1).toUpperCase()
                + s.substring(1);
    }
}
