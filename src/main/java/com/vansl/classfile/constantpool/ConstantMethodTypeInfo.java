package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;


public class ConstantMethodTypeInfo extends ConstantInfo {

    private int descriptorIndex;

    @Override
    public void readInfo(ClassReader classReader) {
        this.descriptorIndex = classReader.readU2();
    }
}