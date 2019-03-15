package com.vansl.rtdata.heap;

import com.vansl.classpath.Classpath;

import java.util.Map;

/**
 * @description 类加载器
 * @date 2019-03-15 14:37:06
 **/
public class ClassLoader {

    Classpath classpath;
    Map<String,Clazz> classMap;

    public ClassLoader(Classpath classpath) {
        this.classpath = classpath;
    }
}
