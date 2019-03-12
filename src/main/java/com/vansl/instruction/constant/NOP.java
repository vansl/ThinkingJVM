package com.vansl.instruction.constant;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

/**
 * @description 什么也不做
 * @date 2019-03-12 19:40:08
 **/
public class NOP extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        // do nothing
    }
}
