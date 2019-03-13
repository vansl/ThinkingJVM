package com.vansl.instruction.base;

/**
 * @description 访问运行时常量池的指令，由两字节操作数作为常量池索引
 * @date 2019-03-12 19:04:36
 **/
public abstract class Index16Instruction implements Instruction {

    protected int index;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        index = bytecodeReader.readUint16();
    }
}
