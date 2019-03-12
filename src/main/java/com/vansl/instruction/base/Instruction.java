package com.vansl.instruction.base;

import com.vansl.rtdata.Frame;

public interface Instruction {

    void fetchOperands(BytecodeReader bytecodeReader);
    void Execute(Frame frame);
}


