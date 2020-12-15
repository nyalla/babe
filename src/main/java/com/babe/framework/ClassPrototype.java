package com.babe.framework;

import com.babe.beans.FieldDetails;

import java.util.List;
import java.util.Map;

public interface ClassPrototype
{

     void initialContextBuilder(Map<String, Object> globals);
     String setClassFields(List<FieldDetails> fields);
}
