package com.vansl.rtdata;

import com.vansl.rtdata.heap.HeapObject;

/**
 * @description 局部变量表,boolean、byte、short、char类型转为int处理
 * 只存放数据的值，不存放数据类型，操作数栈同样也是
 * @date 2019-03-12 16:33:47
 **/
public class LocalVars {

    private Slot[] slots;

    public LocalVars(int maxLocals) {
        slots = new Slot[maxLocals];
        for(int i=0;i<maxLocals;i++) {
            slots[i] = new Slot();
        }
    }

    public int getInt(int index) {
        return slots[index].getNum();
    }

    public void setInt(int index,int val) {
        slots[index].setNum(val);
    }

    public float getFloat(int index) {
        return Float.intBitsToFloat(slots[index].getNum());
    }

    public void setFloat(int index,float val) {
        slots[index].setNum(Float.floatToIntBits(val));
    }

    public long getLong(int index) {
        // 先转为unsigned int
        long lowVal = slots[index].getNum()&0xFFFFFFFFL;
        long highVal = slots[index+1].getNum()&0x0FFFFFFFFL;
        return highVal << 32 | lowVal;
    }

    public void setLong(int index,long val) {
        slots[index].setNum((int)val);
        slots[index+1].setNum((int)(val >> 32));
    }

    public double getDouble(int index) {
        return new Long(getLong(index)).doubleValue();
    }

    public void setDouble(int index,double val) {
        setLong(index,new Double(val).longValue());
    }

    public HeapObject getRef(int index) {
        return slots[index].getRef();
    }

    public void setRef(int index,HeapObject ref) {
        slots[index].setRef(ref);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Slot slot:slots) {
            stringBuilder.append(slot.getNum()+" ");    // 只返回num
        }
        return stringBuilder.toString();
    }
}
