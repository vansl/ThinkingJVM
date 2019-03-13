package com.vansl.instruction.base;

/**
 * @description 没有操作数的指令
 * @date 2019-03-12 18:58:57
 **/
public abstract class NoOperandsInstruction implements Instruction {

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        // do nothing
    }
}
