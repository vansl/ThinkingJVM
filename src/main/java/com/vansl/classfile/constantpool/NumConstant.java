package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;

/**
 * @description 存放int,boolean,byte,short,char
 * @date 2019-03-10 13:18:16
 **/
class ConstantIntegerInfo extends ConstantInfo {

    private int val;

    @Override
    public void readInfo(ClassReader classReader) {
        this.val = (int)classReader.readU4();
    }
}

class ConstantFloatInfo extends ConstantInfo {

    private float val;

    @Override
    public void readInfo(ClassReader classReader) {
        this.val = (float)classReader.readU4();
    }
}

class ConstantLongInfo extends ConstantInfo {

    private long highVal;
    private long lowVal;

    @Override
    public void readInfo(ClassReader classReader) {
        this.highVal = classReader.readU4();
        this.lowVal = classReader.readU4();
    }
}

class ConstantDoubleInfo extends ConstantInfo {

    private long highVal;
    private long lowVal;

    @Override
    public void readInfo(ClassReader classReader) {
        this.highVal = classReader.readU4();
        this.lowVal = classReader.readU4();
    }
}