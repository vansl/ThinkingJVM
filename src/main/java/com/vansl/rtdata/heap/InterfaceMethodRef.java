package com.vansl.rtdata.heap;

import com.vansl.classfile.constantpool.ConstantInterfaceMethodrefInfo;

public class InterfaceMethodRef extends MemberRef {

    Method method;

    public InterfaceMethodRef(RuntimeConstantPool constantPool, ConstantInterfaceMethodrefInfo constantInfo) {
        this.constantPool = constantPool;
        copyMemberRefInfo(constantInfo);
    }
}
