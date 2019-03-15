package com.vansl.rtdata.heap;


import com.vansl.rtdata.Slot;

/**
 * @description 类变量和实例变量数组
 * @date 2019-03-15 15:22:09
 **/
public class Slots {
    private Slot[] slots;

    public Slots(int slotCount) {
        slots = new Slot[slotCount];
        for(int i=0;i<slotCount;i++) {
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
