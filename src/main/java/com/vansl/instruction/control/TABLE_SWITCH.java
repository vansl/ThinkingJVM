package com.vansl.instruction.control;

import com.vansl.instruction.base.BranchLogic;
import com.vansl.instruction.base.BytecodeReader;
import com.vansl.instruction.base.Instruction;
import com.vansl.rtdata.Frame;

/**
 * @description 索引表实现switch-case语句
 * @date 2019-03-12 22:08:19
 **/
public class TABLE_SWITCH implements Instruction {

    private int defaultOffset;
    private int low;
    private int high;
    private int[] jumpOffsets;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        bytecodeReader.skipPadding();
        defaultOffset = bytecodeReader.readInt32();
        low = bytecodeReader.readInt32();
        high = bytecodeReader.readInt32();
        int jumpOffsetCount = high-low+1;
        jumpOffsets = bytecodeReader.readInt32s(jumpOffsetCount);
    }

    @Override
    public void execute(Frame frame) {
        int index = frame.getOperandStack().popInt();
        int offset;
        if (index>=low && index<=high) {
            offset = jumpOffsets[index-low];
        } else {
            offset = defaultOffset;
        }
        BranchLogic.branch(frame,offset);
    }
}
