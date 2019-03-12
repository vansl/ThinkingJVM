package com.vansl.classfile.attribute;

import com.vansl.classfile.ClassReader;
import com.vansl.classfile.constantpool.ConstantPool;

/**
 * @description 属性是可扩展的，因此不使用tag而使用属性名来区别不同的属性
 * @date 2019-03-10 17:12:10
 **/
public abstract class AttributeInfo {


    public abstract void readInfo(ClassReader classReader);

    public static AttributeInfo[] readAttributes(ClassReader classReader, ConstantPool constantPool) {
        int attributesCount = classReader.readU2();
        AttributeInfo[] attributes = new AttributeInfo[attributesCount];
        for(int i=0;i<attributesCount;i++) {
            int attrNameIndex = classReader.readU2();
            String attrName = constantPool.getUtf8(attrNameIndex);  // 属性名
            long attrLen = classReader.readU4();                    // 属性长度
            AttributeInfo attributeInfo = AttributeFactory.newAttributeInfo(attrName,attrLen,classReader,constantPool);
            attributes[i] = attributeInfo;
        }
        return attributes;
    }
}
