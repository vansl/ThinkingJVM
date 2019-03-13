package com.vansl.instruction.base;

import com.vansl.classfile.ClassReader;

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

    public byte readInt8() {
        return code[pc++];
    }

    public int readUint16() {
        int num = 0;
        for (int i= pc ; i < pc+2 ; i++) {
            num <<= 8;
            num |= (code[i] & 0xff);
        }
        pc += 2;
        return num;
    }

    public short readInt16() {
        short s = 0;
        byte b;
        for (int i = pc; i < pc+2; i++) {
            b = code[i];
            s |= (b& 0xFF) << (8 * (pc-i+1));
        }
        pc += 2;
        return s;
    }

    public int readInt32() {
        int num = 0;
        for (int i = pc; i < pc+4; i++) {
            num |= (code[i]& 0xFF) << (8 * (pc-i+1));
        }
        pc += 4;
        return num;
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

    public int getPc() {
        return pc;
    }
}
