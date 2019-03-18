package com.vansl.rtdata.heap;

import lombok.Data;

@Data
public class HeapObject {

    Clazz clazz;            // 对象所属类
    Slots fields;           // 实例变量

    public HeapObject(Clazz clazz) {
        this.clazz = clazz;
        this.fields = new Slots(clazz.getInstanceSlotCount());
    }

    public IsInstanceOf(class *Class) bool {
        return class.isAssignableFrom(self.class)
    }
}
