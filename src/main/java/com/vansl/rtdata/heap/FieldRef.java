package com.vansl.rtdata.heap;

import com.vansl.classfile.constantpool.ConstantFieldrefInfo;

public class FieldRef extends MemberRef{

    Field field;        // 解析后的字段引用

    public FieldRef(RuntimeConstantPool constantPool, ConstantFieldrefInfo constantFieldrefInfo) {
        this.constantPool = constantPool;
        this.copyMemberRefInfo(constantFieldrefInfo);
    }
}
