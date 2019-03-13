package com.vansl.instruction.base;

/**
 * @description 存储和加载类指令，由单字节操作数作为索引存取局部变量表
 * @date 2019-03-12 19:01:54
 **/
public abstract class Index8Instruction implements Instruction {

    public int index;      // 局部变量表索引

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        index = bytecodeReader.readUint8();
    }
}
