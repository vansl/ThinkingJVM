package com.vansl.instruction.extended;

import com.vansl.instruction.base.BytecodeReader;
import com.vansl.instruction.base.Instruction;
import com.vansl.instruction.control.RET;
import com.vansl.instruction.load.*;
import com.vansl.instruction.math.IINC;
import com.vansl.instruction.store.*;
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
                ((ILOAD) modifiedInstruction).index = bytecodeReader.readUint16();
                break;
            case 0x16:
                modifiedInstruction = new LLOAD();
                ((LLOAD) modifiedInstruction).index = bytecodeReader.readUint16();
                break;
            case 0x17:
                modifiedInstruction = new FLOAD();
                ((FLOAD) modifiedInstruction).index = bytecodeReader.readUint16();
                break;
            case 0x18:
                modifiedInstruction = new DLOAD();
                ((DLOAD) modifiedInstruction).index = bytecodeReader.readUint16();
                break;
            case 0x19:
                modifiedInstruction = new ALOAD();
                ((ALOAD) modifiedInstruction).index = bytecodeReader.readUint16();
                break;
            case 0x36:
                modifiedInstruction = new ISTORE();
                ((ISTORE) modifiedInstruction).index = bytecodeReader.readUint16();
                break;
            case 0x37:
                modifiedInstruction = new LSTORE();
                ((LSTORE) modifiedInstruction).index = bytecodeReader.readUint16();
                break;
            case 0x38:
                modifiedInstruction = new FSTORE();
                ((FSTORE) modifiedInstruction).index = bytecodeReader.readUint16();
                break;
            case 0x39:
                modifiedInstruction = new DSTORE();
                ((DSTORE) modifiedInstruction).index = (short) bytecodeReader.readUint16();
                break;
            case 0x3a:
                modifiedInstruction = new ASTORE();
                ((ASTORE) modifiedInstruction).index = (short) bytecodeReader.readUint16();
                break;
            case 0xa9:
                modifiedInstruction = new RET();
                ((RET) modifiedInstruction).index = bytecodeReader.readUint16();
                break;
            case 0x84:
                modifiedInstruction = new IINC();
                ((IINC) modifiedInstruction).index = bytecodeReader.readUint16();
                ((IINC) modifiedInstruction).index = bytecodeReader.readInt16();
                break;
        }
    }

    @Override
    public void execute(Frame frame) {
        modifiedInstruction.execute(frame);
    }
}
