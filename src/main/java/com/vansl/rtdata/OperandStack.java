package com.vansl.rtdata;

import com.vansl.rtdata.heap.HeapObject;

/**
 * @description 操作数栈
 * @date 2019-03-12 17:01:23
 **/
public class OperandStack {

    private Slot[] slots;
    private int size;       // 记录栈顶位置

    public OperandStack(int maxOperandStack) {
        slots = new Slot[maxOperandStack];
        for(int i=0;i<maxOperandStack;i++) {
            slots[i] = new Slot();
        }
    }

    public int popInt() {
        return slots[--size].getNum();
    }

    public void pushInt(int val) {
        slots[size++].setNum(val);
    }

    public float popFloat() {
        return Float.intBitsToFloat(slots[--size].getNum());
    }

    public void pushFloat(float val) {
        slots[size++].setNum(Float.floatToIntBits(val));
    }

    public long popLong() {
        // 先转为unsigned int
        long highVal = slots[--size].getNum()&0xFFFFFFFFL;
        long lowVal = slots[--size].getNum()&0x0FFFFFFFFL;
        return highVal << 32 | lowVal;
    }

    public void pushLong(long val){
        slots[size++].setNum((int)val);
        slots[size++].setNum((int)(val >> 32));
    }

    public double popDouble() {
        return Double.longBitsToDouble(popLong());
    }

    public void pushDouble(double val) {
        pushLong(Double.doubleToLongBits(val));
    }

    public HeapObject popRef() {
        size --;
        HeapObject ref = slots[size].getRef();
        slots[size].setRef(null);           // 让垃圾收集器回收对象
        return ref;
    }

    public void pushRef(HeapObject object) {
        slots[size++].setRef(object);
    }

    public Slot popSlot() {
        size --;
        return slots[size];
    }

    public void pushSlot(Slot slot) {
        slots[size++] = slot;
    }
}
