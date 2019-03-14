package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;

/**
 * @description 存放int,boolean,byte,short,char
 * @date 2019-03-10 13:18:16
 **/
public class ConstantIntegerInfo extends ConstantInfo {

    private int val;

    @Override
    public void readInfo(ClassReader classReader) {
        this.val = (int)classReader.readU4();
    }

    public int getVal() {
        return val;
    }
}
