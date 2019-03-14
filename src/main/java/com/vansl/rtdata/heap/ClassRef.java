package com.vansl.rtdata.heap;

import com.vansl.classfile.constantpool.ConstantClassInfo;

public class ClassRef extends SymRef{

    public ClassRef(RuntimeConstantPool constantPool, ConstantClassInfo constantClassInfo) {
        this.constantPool = constantPool;
        this.className = constantClassInfo.getClassName();
    }
}
