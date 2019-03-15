package com.vansl.rtdata.heap;

/**
 * @description 符号引用
 * @date 2019-03-14 18:37:13
 **/
public class SymRef {

    RuntimeConstantPool constantPool;   // 通过符号引用访问常量池
    String className;                   // 类的完全限定名
    Clazz clazz;                        // 缓存clazz对象

    public Clazz resolvedClass() {
        if (clazz==null) {
            resolveClassRef();
        }
        return clazz;
    }

    /**
     * @description 解析类符号引用
     * @date 2019-03-15 17:42:09
     **/
    public void resolveClassRef() {
        Clazz d = constantPool.clazz;
        // 加载类
        Clazz c = d.getClassLoader().loadClass(className);
        // 检查访问权限
        if(!c.isAccessibleTo(d)) {
            throw new Error("java.lang.IllegalAccessError");
        }
        this.clazz = c;
    }
}



