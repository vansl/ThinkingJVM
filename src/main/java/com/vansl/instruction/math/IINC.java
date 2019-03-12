package com.vansl.instruction.math;

import com.vansl.instruction.base.BytecodeReader;
import com.vansl.instruction.base.Instruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.LocalVars;

/**
 * @description 给局部变量表中的int变量增加常量值
 * @date 2019-03-12 21:25:01
 **/
public class IINC implements Instruction {

    private int index;         // 局部变量表索引
    private int constVal;      // 常量

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        index = bytecodeReader.readUint8();
        constVal = bytecodeReader.readUint8();
    }

    @Override
    public void Execute(Frame frame) {
        LocalVars localVars = frame.getLocalVars();
        int val = localVars.getInt(index);
        val += constVal;
        localVars.setInt(index,val);
    }
}
