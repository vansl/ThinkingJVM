package com.vansl.instruction.base;

/**
 * @description 封装字节码
 * @date 2019-03-12 19:06:25
 **/
public class BytecodeReader {

    private byte[] code;    // 字节码
    private int pc;         // 读取位置指针


    public void reset(byte[] code,int pc) {
        this.code = code;
        this.pc = pc;
    }

    public short readUint8() {
        short value = (short) (code[pc] & 0xFF);
        pc += 1;
        return value;
    }

    public short readInt8() {
        return (short)code[pc];
    }

    public int readUint16() {
        short byte1 = readUint8();
        short byte2 = readUint8();
        return byte1<<2 | byte2;
    }

    public int readInt16() {
        return 1;
    }

    public int readInt32() {
        return 1;
    }

    public int[] readInt32s(int n) {
        int[] result = new int[n];
        for (int i=0;i<n;i++) {
            result[i] = readInt32();
        }
        return result;
    }

    public void skipPadding() {
        while (pc%4!=0) {
            readUint8();
        }
    }
}
