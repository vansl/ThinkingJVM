package com.vansl.instruction.extended;

import com.vansl.instruction.base.BytecodeReader;
import com.vansl.instruction.base.Instruction;
import com.vansl.instruction.load.ILOAD;
import com.vansl.rtdata.Frame;

/**
 * @description 局部变量表大小超过256时扩展指令
 * @date 2019-03-12 22:25:51
 **/
public class WIDE implements Instruction {

    private Instruction modifiedInstruction;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        int opCode = bytecodeReader.readUint8();
        switch (opCode) {
            case 0x15:
                modifiedInstruction = new ILOAD();
                modifiedInstruction.index =
        }
    }

    @Override
    public void Execute(Frame frame) {

    }
}
