package com.vansl.classfile;

import com.vansl.classfile.attribute.AttributeInfo;
import com.vansl.classfile.constantpool.ConstantPool;

import java.util.ArrayList;
import java.util.List;

public class ClassFile {

    private long magic;                 // 魔数
    private int minorVersion;           // 次版本号
    private int majorVersion;           // 主版本号
    private ConstantPool constantPool;  // 常量池
    private int accessFlags;            // 类访问标志
    private int thisClass;              // 类索引
    private int superClass;             // 超类索引，java.lang.HeapObject为0
    private int[] interfaces;           // 接口索引表
    private MemberInfo[] fields;        // 字段表
    private MemberInfo[] methods;       // 方法表
    private AttributeInfo[] attributes; // 属性表

    public static ClassFile readClassFile(byte[] classData) {
        ClassFile classFile = new ClassFile();
        ClassReader classReader = new ClassReader(classData);
        classFile.readAndCheckMagic(classReader);
        classFile.readAndCheckVersion(classReader);
        classFile.constantPool = ConstantPool.readConstantpool(classReader);
        classFile.accessFlags = classReader.readU2();
        classFile.thisClass = classReader.readU2();
        classFile.superClass = classReader.readU2();
        classFile.interfaces = classReader.readU2s();
        classFile.fields = MemberInfo.readMembers(classReader,classFile.constantPool);
        classFile.methods = MemberInfo.readMembers(classReader,classFile.constantPool);
        classFile.attributes = AttributeInfo.readAttributes(classReader,classFile.constantPool);
        return classFile;
    }

    public void readAndCheckMagic(ClassReader classReader) {
        this.magic = classReader.readU4();
        // 0Xcafebabe == 3405691582l
        if (magic != 3405691582l) {
            throw new Error("java.lang.ClassFormatError:magic");
        }
    }

    public void readAndCheckVersion(ClassReader classReader) {
        this.minorVersion = classReader.readU2();
        this.majorVersion = classReader.readU2();
        switch (majorVersion) {
            case 45:
                return;
            case 46:case 47:case 48:case 49:case 50:case 51:case 52:
                if (this.minorVersion==0) {
                    return;
                }
        }
        throw new Error("java.lang.UnsupportedClassVersionError");
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public int getAccessFlags() {
        return accessFlags;
    }


    /**
     * @description 获取类名
     * @date 2019-03-11 21:47:07
     **/
    public String getClassName() {
        return constantPool.getClassName(thisClass);
    }

    /**
     * @description 获取超类名
     * @date 2019-03-11 21:46:46
     **/
    public String getSuperClassName() {
        if(this.superClass>0) {
            return constantPool.getClassName(superClass);
        }
        // 只有java.lang.HeapObject没有超类
        return "";
    }

    /**
     * @description 获取接口名
     * @date 2019-03-11 21:46:58
     **/
    public List<String> getInterfaceNames() {
        List<String> interfaceNames = new ArrayList<>(this.interfaces.length);
        for (int i=0;i<this.interfaces.length;i++) {
            interfaceNames.add(constantPool.getClassName(this.interfaces[i]));
        }
        return interfaceNames;
    }

    /**
     * @description 获取字段名
     * @date 2019-03-12 14:30:41
     **/
    public List<String> getFieldNames() {
        List<String> fieldNames = new ArrayList<>(this.fields.length);
        for (int i=0;i<this.fields.length;i++) {
            fieldNames.add(this.fields[i].toString());
        }
        return fieldNames;
    }

    public MemberInfo[] getMethods() {
        return methods;
    }

    public List<String> getMethodNames() {
        List<String> methodNames = new ArrayList<>(this.methods.length);
        for (int i=0;i<this.methods.length;i++) {
            methodNames.add(methods[i].toString());
        }
        return methodNames;
    }
}
