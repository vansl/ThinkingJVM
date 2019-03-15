package com.vansl.rtdata.heap;

import com.vansl.classfile.ClassFile;
import com.vansl.classpath.Classpath;

import java.util.HashMap;
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
        classMap = new HashMap<>();
    }

    public Clazz loadClass(String name) {
        // 首先查看类是否已被加载
        if (classMap.get(name) != null) {
            return classMap.get(name);
        }
        return loadNonArrayClass(name);
    }

    /**
     * @description 加载普通类
     * @date 2019-03-15 14:46:11
     **/
    public Clazz loadNonArrayClass(String name) {
        // 加载class文件
        byte[] data = readClass(name);
        Clazz clazz = defineClass(data);
        // 验证、准备class
        link(clazz);
        return clazz;
    }

    public byte[] readClass(String name) {
        byte[] data = null;
        try {
            data = classpath.readClass(name);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return data;
    }

    public Clazz defineClass(byte[] data) {
        // 把clas文件转换为 class对象
        Clazz clazz = parseClass(data);
        clazz.setClassLoader(this);
        // 解析超类与接口的符号引用
        resolveSuperClass(clazz);
        resolveInterfaces(clazz);
        classMap.put(clazz.getClassName(),clazz);
        return clazz;
    }

    public Clazz parseClass(byte[] data) {
        ClassFile classFile = ClassFile.readClassFile(data);
        Clazz clazz = new Clazz(classFile);
        return clazz;
    }

    public void resolveSuperClass(Clazz clazz) {
        // 若非Object类则加载超类
        if (!clazz.getClassName().equals("java/lang/Object")) {
            String superClassName = clazz.getSuperClassName();
            clazz.setSuperClass(clazz.getClassLoader().loadClass(superClassName));
        }
    }

    public void resolveInterfaces(Clazz clazz) {
        int interfaceCount = clazz.getInterfaceNames().length;
        if (interfaceCount>0) {
            Clazz[] interfaces = new Clazz[interfaceCount];
            for (int i=0;i<interfaceCount;i++) {
                interfaces[i] = clazz.getClassLoader().loadClass(clazz.getInterfaceNames()[i]);
            }
            clazz.setInterfaces(interfaces);
        }
    }

    public void link(Clazz clazz) {
        // 验证
        verify(clazz);
        // 准备：给类变量分配空间并赋初始值
        prepare(clazz);
    }

    public void verify(Clazz clazz) {
        // TODO 验证类确保安全性
    }

    public void prepare(Clazz clazz){
        // todo
    }
}
