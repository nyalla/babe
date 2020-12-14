package com.babe.framework;

import com.babe.beans.FieldDetails;
import com.google.common.base.CaseFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RepositoryClassPrototype extends AbstractClassPrototype
{
    public RepositoryClassPrototype(String className, String classCategory, Map<String, Object> globals)
    {
        super(className, classCategory);
        initialContextBuilder(globals);
    }

    void initialContextBuilder(Map<String, Object> globals)
    {
        imports.add("package " + globals.get("packageName") + ".models;");
        imports.add("import javax.persistence.*;");
        classLevelAnnotation.add("@Entity");
        classLevelAnnotation.add("@Table(name=\"" + className.toLowerCase() + "\")");
        getVMByCategory("");
    }

    @Override
    public String getVMByCategory(String classCategory)
    {
        // In future it can driven based upon version of the vm file
        setVmPath("vtemplates/repository_v1.vm");
        return "";
    }

    @Override
    public String setClassFields(List<FieldDetails> tableFields)
    {
        for (FieldDetails fd : tableFields)
        {
            FieldPrototype fieldPrototype = new FieldPrototype();
            fieldPrototype.setName(fd.getFieldName());
            fieldPrototype.setType(PortalStaticMaps.typeMap.get(fd.getFieldType()));
            fieldPrototype.setGetterAndSetterField(
                    fd.getFieldName().substring(0, 1).toUpperCase() + fd.getFieldName().substring(1));
            //populate Annotation based on field type
            if (fd.isIdentity())
            {
                List<String> annotations = new ArrayList<>();
                annotations.add("@Id");
                annotations.add(
                        "@Column(name = \"" + CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fd.getFieldName())
                                + "\", nullable = false)");
                annotations.add("@GeneratedValue(strategy = GenerationType.IDENTITY)");
                fieldPrototype.getAnnotation().addAll(annotations);
            }
            else
            {
                fieldPrototype.getAnnotation().add(
                        "@Column(name = \"" + CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fd.getFieldName())
                                + "\", nullable = false)");
            }
            fields.add(fieldPrototype);
        }

        return null;
    }

}
