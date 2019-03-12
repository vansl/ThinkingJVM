package com.vansl.classpath;

import java.io.File;
import java.io.IOException;

/**
 * @description 类路径（启动类路径、扩展类路径和用户类路径等）
 * 1. 指定目录：java -cp path
 * 2. 指定jar/zip文件：java -cp path\to\lib.jar
 * 3. 指定多个目录/文件：java -cp path\to\classes;lib\a.jar;lib\b.jar;lib\c.zip ...
 * 4. 使用通配符（*）指定某个目录下的所有JAR文件：java -cp classes;lib\*
 * @date 2019-03-03 16:06:05
 **/
public interface Entry {

    // 文件名分隔符
    String SEP = File.separator;

    // 系统路径分隔符
    String PATH_SEP = File.pathSeparator;


    /**
     * @description 寻找和加载class文件
     * @date 2019-03-03 16:05:50
     * @param className class文件的相对路径
     * @return byte数组
     **/
    byte[] readClass(String className) throws IOException, ClassNotFoundException;

}
