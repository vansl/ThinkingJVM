package com.vansl.classfile.attribute;

import com.vansl.classfile.ClassReader;

/**
 * @description 用于指出源文件名
 * @date 2019-03-10 19:38:23
 **/
class SourceFileAttribute extends AttributeInfo{

    private int sourceFileIndex;

    @Override
    public void readInfo(ClassReader classReader) {
        this.sourceFileIndex = classReader.readU2();
    }

}
