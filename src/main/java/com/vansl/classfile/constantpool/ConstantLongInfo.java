package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;

public class ConstantLongInfo extends ConstantInfo {

    private long highVal;
    private long lowVal;

    @Override
    public void readInfo(ClassReader classReader) {
        this.highVal = classReader.readU4();
        this.lowVal = classReader.readU4();
    }

    public long getHighVal() {
        return highVal;
    }

    public long getLowVal() {
        return lowVal;
    }
}

