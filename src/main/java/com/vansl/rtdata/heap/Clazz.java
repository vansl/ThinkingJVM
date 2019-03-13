package com.vansl.rtdata.heap;

import com.vansl.classfile.constantpool.ConstantPool;
import com.vansl.rtdata.Slot;

/**
 * @author: vansl
 * 放进方法区内的类
 * @create: 19-3-14 上午1:58
 */
public class Clazz {

    private int accessFlags;            // 类访问标志
    private String className;           // 类名
    private String superClassName;      // 超类名
    private String[] interfaceNames;    // 接口名
    private ConstantPool constantPool;  // 常量池
//    private Field[] fields;             // 字段表
//    private Members[] methods;          // 方法表
//    private ClassLoader classLoader;    // 类加载器
//    private Clazz superClass;
//    private Claszz[] interfaces;
//    private int instanceSlotCount;
//    private int staticSlotCount;
//    private Slots staticVars;

}
