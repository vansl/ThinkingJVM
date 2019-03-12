package com.vansl.classfile.attribute;

import com.vansl.classfile.ClassReader;

class LocalVariableTableEntry {

    private int startPc;
    private int length;
    private int nameIndex;
    private int descriptorIndex;
    private int index;

    public LocalVariableTableEntry(int startPc, int length, int nameIndex, int descriptorIndex, int index) {
        this.startPc = startPc;
        this.length = length;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.index = index;
    }
}

/**
 * @description 存放方法的局部变量信息，用于调试
 * @date 2019-03-10 20:20:30
 **/
class LocalVariableTableAttribute extends AttributeInfo{

    private LocalVariableTableEntry[] localVariableTable;

    @Override
    public void readInfo(ClassReader classReader) {
        int tableLength = classReader.readU2();
        localVariableTable = new LocalVariableTableEntry[tableLength];
        for (int i=0;i<tableLength;i++) {
            localVariableTable[i] = new LocalVariableTableEntry(
                    classReader.readU2(),
                    classReader.readU2(),
                    classReader.readU2(),
                    classReader.readU2(),
                    classReader.readU2()
            );
        }
    }
}
