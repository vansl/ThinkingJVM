package com.vansl.instruction.control;

import com.vansl.instruction.base.BranchLogic;
import com.vansl.instruction.base.BytecodeReader;
import com.vansl.instruction.base.Instruction;
import com.vansl.rtdata.Frame;

public class LOOKUP_SWITCH implements Instruction {

    private int defaultOffset;
    private int npairs;
    private int[] matchOffsets;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        bytecodeReader.skipPadding();
        defaultOffset = bytecodeReader.readInt32();
        npairs = bytecodeReader.readInt32();
        matchOffsets = bytecodeReader.readInt32s(npairs*2);
    }

    @Override
    public void execute(Frame frame) {
        int key = frame.getOperandStack().popInt();
        for (int i=0;i<npairs*2;i+=2) {
            if (matchOffsets[i]==key) {
                int offset = matchOffsets[i+1];
                BranchLogic.branch(frame,offset);
                return;
            }
        }
        BranchLogic.branch(frame,defaultOffset);
    }
}
