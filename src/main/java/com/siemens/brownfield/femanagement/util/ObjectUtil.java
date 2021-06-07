package com.siemens.brownfield.femanagement.util;

import org.springframework.lang.Nullable;

import java.util.Objects;

public class ObjectUtil {

    public static Object getObject(@Nullable Object object){
        return Objects.isNull(object)?null:object;
    }
}
