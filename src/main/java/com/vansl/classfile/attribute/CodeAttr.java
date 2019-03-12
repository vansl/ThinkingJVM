package com.vansl.classfile.attribute;

import com.vansl.classfile.ClassReader;
import com.vansl.classfile.constantpool.ConstantPool;

class ExceptionTableEntry {

    private int startPc;
    private int endPc;
    private int handlerPc;
    private int catchType;

    public ExceptionTableEntry(int startPc, int endPc, int handlerPc, int catchType) {
        this.startPc = startPc;
        this.endPc = endPc;
        this.handlerPc = handlerPc;
        this.catchType = catchType;
    }
}

/**
 * @description 变长属性，存放字节码等信息
 * @date 2019-03-10 19:42:50
 **/
class CodeAttribute extends AttributeInfo {

    private ConstantPool constantPool;
    private int maxStack;                           // 栈的最大深度
    private int maxLocals;                          // 局部变量表大小
    private byte[] code;                            // 字节码
    private ExceptionTableEntry[] exceptionTable;   // 异常处理表
    private AttributeInfo[] attributes;             // 属性表

    CodeAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader classReader) {
        maxStack = classReader.readU2();
        maxLocals = classReader.readU2();
        int codeLength = (int)classReader.readU4();
        code = classReader.readBytes(codeLength);
        exceptionTable = readExceptionTable(classReader);
        attributes = readAttributes(classReader,constantPool);
    }

    public ExceptionTableEntry[] readExceptionTable(ClassReader classReader) {
        int tableLength = classReader.readU2();
        ExceptionTableEntry[] exceptionTable = new ExceptionTableEntry[tableLength];
        for(int i=0;i<tableLength;i++) {
            exceptionTable[i] = new ExceptionTableEntry(
                    classReader.readU2(),
                    classReader.readU2(),
                    classReader.readU2(),
                    classReader.readU2()
            );
        }
        return exceptionTable;
    }
}
