package com.vansl.classfile.constantpool;


import com.vansl.classfile.ClassReader;

/**
 * @description 常量池
 * @date 2019-03-10 14:17:28
 **/
public class ConstantPool {

    private int constantPoolCount;
    private ConstantInfo[] constantInfos;

    public static ConstantPool readConstantpool(ClassReader classReader) {
        ConstantPool constantPool = new ConstantPool();
        int constantPoolCount = classReader.readU2();
        constantPool.constantPoolCount = constantPoolCount;
        constantPool.constantInfos = new ConstantInfo[constantPoolCount];
        for (int i = 1; i < constantPoolCount; i++) {
            short tag = classReader.readU1();
            ConstantInfo constantInfo = ConstantFactory.newConstant(tag, classReader,constantPool);
            constantPool.constantInfos[i] = constantInfo;
            // long和double占两个索引
            if (tag == ConstantTag.LONG.tag || tag == ConstantTag.DOUBLE.tag) {
                i++;
            }
        }
        return constantPool;
    }

    public ConstantInfo getConstantInfo(int index) {
        return constantInfos[index];
    }

    public String getUtf8(int index) {
        ConstantUtf8Info utf8Info = (ConstantUtf8Info)constantInfos[index];
        return utf8Info.getVal();
    }

    public String[] getNameAndDescriptor(int index) {
        ConstantNameAndTypeInfo nATInfo = (ConstantNameAndTypeInfo)constantInfos[index];
        return new String[]{getUtf8(nATInfo.getNameIndex()),getUtf8(nATInfo.getDescriptorIndex())};
    }

    public String getClassName(int index) {
        ConstantClassInfo classInfo = (ConstantClassInfo)constantInfos[index];
        return getUtf8(classInfo.getNameIndex());
    }

    public int getConstantPoolCount() {
        return constantPoolCount;
    }
}

