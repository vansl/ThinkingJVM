package com.vansl.classfile.attribute;

import com.vansl.classfile.ClassReader;

class LineNumberTableEntry {

    private int startPc;
    private int lineNumber;

    public LineNumberTableEntry(int startPc, int lineNumber) {
        this.startPc = startPc;
        this.lineNumber = lineNumber;
    }
}

/**
 * @description 存放方法的行号信息，用于调试
 * @date 2019-03-10 20:07:09
 **/
class LineNumberTableAttribute extends AttributeInfo{

    private LineNumberTableEntry[] lineNumberTable;

    @Override
    public void readInfo(ClassReader classReader) {
        int tableLength = classReader.readU2();
        lineNumberTable = new LineNumberTableEntry[tableLength];
        for(int i=0;i<tableLength;i++) {
            lineNumberTable[i] = new LineNumberTableEntry(
                    classReader.readU2(),
                    classReader.readU2()
            );
        }
    }
}
