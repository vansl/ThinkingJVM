package com.vansl.instruction.base;

import com.vansl.rtdata.Frame;

/**
 * @description 指令跳转函数
 * @date 2019-03-12 21:54:32
 **/
public class BranchLogic {

    public static void branch(Frame frame, int offset) {
        int pc = frame.getThread().getPc();
        int nextPC = pc+offset;
        frame.setNextPC(nextPC);
    }
}
