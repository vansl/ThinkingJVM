package com.vansl.classfile.attribute;

import com.vansl.classfile.ClassReader;

/**
 * @description 无法识别的属性
 * @date 2019-03-10 16:21:12       
 **/
class UnparsedAttribute extends AttributeInfo{

    private String name;
    private long length;
    private byte[] info;

    UnparsedAttribute (String name,long length) {
        this.name = name;
        this.length = length;
    }

    @Override
    public void readInfo(ClassReader classReader) {
        info = classReader.readBytes((int)length);
    }
}
