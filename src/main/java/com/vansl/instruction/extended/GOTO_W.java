package com.vansl.instruction.extended;

import com.vansl.instruction.base.BranchLogic;
import com.vansl.instruction.base.BytecodeReader;
import com.vansl.instruction.base.Instruction;
import com.vansl.rtdata.Frame;

public class GOTO_W implements Instruction {

    private int offset;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        offset = bytecodeReader.readInt32();
    }

    @Override
    public void execute(Frame frame) {
        BranchLogic.branch(frame,offset);
    }
}
