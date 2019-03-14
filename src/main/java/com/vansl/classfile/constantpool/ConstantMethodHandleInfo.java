package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;

class ConstantMethodHandleInfo extends ConstantInfo {

    private short referenceKind;
    private int referenceIndex;

    @Override
    public void readInfo(ClassReader classReader) {
        this.referenceKind = classReader.readU1();
        this.referenceIndex = classReader.readU2();
    }


    public short getReferenceKind() {
        return referenceKind;
    }

    public int getReferenceIndex() {
        return referenceIndex;
    }
}
