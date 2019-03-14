package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;

/**
 * @description 存放MUTF-8编码的字符串
 * @date 2019-03-10 14:48:39
 **/
public class ConstantUtf8Info extends ConstantInfo {

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

