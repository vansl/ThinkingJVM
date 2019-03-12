package com.vansl.classfile;


import java.util.Arrays;

/**
 * @description 封装字节码数组
 * @date 2019-03-12 13:48:02
 **/
public class ClassReader {

    private byte[] data;

    // 读取位置指针
    private int index = 0;

    public ClassReader(byte[] data) {
        this.data = data;
    }

    /**
     * @description 用两字节的有符号整数表示一字节无符号整数，以下同理
     * @date 2019-03-10 13:05:55
     **/
    public short readU1() {
        short value = (short) (data[index] & 0xFF);
        index += 1;
        return value;
    }

    public int readU2(){
        int num = 0;
        for (int i= index; i < index+2 ; i++) {
            num <<= 8;
            num |= (data[i] & 0xff);
        }
        index += 2;
        return num;
    }

    public long readU4() {
        long num = 0;
        for (int i= index; i < index+4; i++) {
            num <<= 8;
            num |= (data[i] & 0xff);
        }
        index += 4;
        return num;
    }

    public int[] readU2s() {
        int size = readU2();
        int[] result = new int[size];
        for (int i=0;i<size;i++) {
            result[i] = readU2();
        }
        return result;
    }

    public byte[] readBytes(int n) {
        byte[] bytes = Arrays.copyOfRange(data,index,index+n);
        index += n;
        return bytes;
    }
}
