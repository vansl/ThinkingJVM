package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;

/**
 * @description 表示java.lang.String字面量，只存放索引不存放数据
 * @date 2019-03-10 14:48:11
 **/
public class ConstantStringInfo extends ConstantInfo {

    private int stringIndex;    // 指向CONSTANT_Utf8_info常量


    @Override
    public void readInfo(ClassReader classReader) {
        this.stringIndex = classReader.readU2();
    }

    public int getStringIndex() {
        return stringIndex;
    }
}
