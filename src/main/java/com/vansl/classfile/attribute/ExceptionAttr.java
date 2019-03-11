package com.vansl.classfile.attribute;

import com.vansl.classfile.ClassReader;

/**
 * @description 变长属性，记录方法抛出的异常表
 * @date 2019-03-10 20:02:05
 **/
class ExceptionsAttribute extends AttributeInfo{

    private int[] exceptionIndexTable;

    @Override
    public void readInfo(ClassReader classReader) {
        exceptionIndexTable = classReader.readU2s();
    }

    public int[] getExceptionIndexTable() {
        return exceptionIndexTable;
    }
}
