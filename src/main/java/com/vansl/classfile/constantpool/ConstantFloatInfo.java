package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;

public class ConstantFloatInfo extends ConstantInfo {

    private float val;

    @Override
    public void readInfo(ClassReader classReader) {
        this.val = (float)classReader.readU4();
    }

    public float getVal() {
        return val;
    }
}
