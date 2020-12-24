package com.shield.utils.poi;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) //加在属性上
public @interface ExcelFieldDescribeAnno {
    String value() default "";
    String columnName() default "";
    String patten() default "";


}
