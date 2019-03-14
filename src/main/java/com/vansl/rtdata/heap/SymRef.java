package com.vansl.rtdata.heap;

/**
 * @description 符号引用
 * @date 2019-03-14 18:37:13
 **/
public class SymRef {

    RuntimeConstantPool constantPool;   // 通过符号引用访问常量池
    String className;                   // 类的完全限定名
    Clazz clazz;                        // 缓存clazz对象
}



