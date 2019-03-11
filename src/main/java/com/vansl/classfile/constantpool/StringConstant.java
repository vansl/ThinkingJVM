package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;
import com.vansl.util.IOUtil;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @description 存放MUTF-8编码的字符串
 * @date 2019-03-10 14:48:39
 **/
class ConstantUtf8Info extends ConstantInfo {

    private String val;

    @Override
    public void readInfo(ClassReader classReader) {
        int length = classReader.readU2();
        byte[] bytes = classReader.readBytes(length);
        // 读MUTF-8编码的字符串
        // new DataInputStream(new ByteArrayInputStream(bytes)).readUTF();
        this.val = new String(bytes);   // TODO MUTF-8编码问题
    }

    public String getVal() {
        return val;
    }
}

/**
 * @description 表示java.lang.String字面量，只存放索引不存放数据
 * @date 2019-03-10 14:48:11
 **/
class ConstantStringInfo extends ConstantInfo {

    private int stringIndex;    // 指向CONSTANT_Utf8_info常量


    @Override
    public void readInfo(ClassReader classReader) {
        this.stringIndex = classReader.readU2();
    }

}

/**
 * @description 表示类/接口的符号引用，只存放索引不存放数据
 * @date 2019-03-10 14:54:28
 **/
class ConstantClassInfo extends ConstantInfo {

    private int nameIndex;    // 指向CONSTANT_Utf8_info常量

    @Override
    public void readInfo(ClassReader classReader) {
        this.nameIndex = classReader.readU2();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}