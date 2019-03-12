package com.vansl.instruction.base;

/**
 * @description 跳转指令
 * @date 2019-03-12 18:59:41
 **/
public abstract class BranchInstruction implements Instruction {

    protected int offset;      // 跳转偏移量

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        // 从字节码中读取一个uint16整数
        offset = bytecodeReader.readUint16();
    }
}
