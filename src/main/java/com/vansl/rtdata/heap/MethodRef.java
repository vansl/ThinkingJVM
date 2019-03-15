package com.vansl.rtdata.heap;


import com.vansl.classfile.constantpool.ConstantMethodrefInfo;

public class MethodRef extends MemberRef {

    Method method;        // 解析后的字段引用

    public MethodRef(RuntimeConstantPool constantPool, ConstantMethodrefInfo constantMethodrefInfo) {
        this.constantPool = constantPool;
        this.copyMemberRefInfo(constantMethodrefInfo);
    }
}
