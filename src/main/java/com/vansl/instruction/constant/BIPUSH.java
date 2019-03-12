package com.vansl.instruction.constant;

import com.vansl.instruction.base.BytecodeReader;
import com.vansl.instruction.base.Instruction;
import com.vansl.rtdata.Frame;

/**
 * @description 从操作数中获取一个byte型整数，扩展成int型，然后推入栈顶
 * @date 2019-03-12 19:55:34
 **/
public class BIPUSH implements Instruction {

    private short val;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        val = bytecodeReader.readInt8();
    }

    @Override
    public void Execute(Frame frame) {
        int intVal = (int)val;
        frame.getOperandStack().pushInt(intVal);
    }
}
