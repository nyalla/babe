package com.babe.framework;

import com.babe.beans.FieldDetails;
import com.babe.constants.PortalStaticMaps;
import com.babe.util.ConvertUtil;
import com.google.common.base.CaseFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EntityBeanClassPrototype extends AbstractClassPrototype
{
    public EntityBeanClassPrototype(String classNameInit, String classCategory, Map<String, Object> globals)
    {
        super(classNameInit, classCategory);
        classInstanceName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, className);
        initialContextBuilder(globals);
    }

    @Override
    public void initialContextBuilder(Map<String, Object> globals)
    {
        //Package Name
        classPackage = "models";

        //ADDING IMPORTS
        imports.add("import javax.persistence.*;");
        //Adding class level annotations
        classLevelAnnotation.add("@Entity");
        classLevelAnnotation.add("@Table(name=\"" + className.toLowerCase() + "\")");

        getVMByCategory("");
    }

    @Override
    public String getVMByCategory(String classCategory)
    {
        // In future it can driven based upon version of the vm file
        setVmPath("vtemplates/entity_v1.vm");
        return "";
    }

    public String setClassFields(List<FieldDetails> tableFields)
    {
        for (FieldDetails fd : tableFields)
        {
            FieldPrototype fieldPrototype = new FieldPrototype();
            fieldPrototype.setName(fd.getFieldName());
            fieldPrototype.setType(PortalStaticMaps.typeMap.get(fd.getFieldType()));
            fieldPrototype.setGetterAndSetterField(ConvertUtil.firstLetterCapital(fd.getFieldName()));
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
        //Adding timestamp fields imports
        classLevelAnnotation.add("import org.hibernate.annotations.CreationTimestamp;");
        classLevelAnnotation.add("import org.hibernate.annotations.UpdateTimestamp;");
        classLevelAnnotation.add("import java.util.Date;");

        //adding timestamp fields ., 1 is for crete and 2 is for update
        addDefaultTimestampFields("cdate",1);
        addDefaultTimestampFields("udate",2);

        return null;
    }

    private void addDefaultTimestampFields(String field,int t){
        FieldPrototype fieldPrototype = new FieldPrototype();
        fieldPrototype.setName(field);
        fieldPrototype.setType("Date");
        fieldPrototype.setGetterAndSetterField(ConvertUtil.firstLetterCapital(field));
        List<String> annotations = new ArrayList<>();
        annotations.add(PortalStaticMaps.getJpaTimeStampAnnotation(t));
        annotations.add("@Temporal(TemporalType.TIMESTAMP)");
        annotations.add(
                "@Column(name = \"" + CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field)
                        + "\", nullable = false)");
        fieldPrototype.getAnnotation().addAll(annotations);
        fields.add(fieldPrototype);
    }

}
