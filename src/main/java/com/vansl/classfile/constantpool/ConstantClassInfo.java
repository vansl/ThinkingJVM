package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;

/**
 * @description 表示类/接口的符号引用，只存放索引不存放数据
 * @date 2019-03-10 14:54:28
 **/
public class ConstantClassInfo extends ConstantInfo {

    private ConstantPool constantPool;
    private int nameIndex;    // 指向CONSTANT_Utf8_info常量

    public ConstantClassInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader classReader) {
        this.nameIndex = classReader.readU2();
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public String getClassName() {
        return constantPool.getUtf8(nameIndex);
    }
}
