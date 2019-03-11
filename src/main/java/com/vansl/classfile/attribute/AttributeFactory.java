package com.vansl.classfile.attribute;


import com.vansl.classfile.ClassReader;
import com.vansl.classfile.constantpool.ConstantPool;

public class AttributeFactory {

    public static AttributeInfo newAttributeInfo(String attrName, long attrLen, ClassReader classReader,ConstantPool constantPool) {
        AttributeInfo attributeInfo;
        switch (attrName) {
            case "Code":
                attributeInfo = new CodeAttribute(constantPool);
                break;
            case "ConstantValue":
                attributeInfo = new ConstantValueAttribute();
                break;
            case "Deprecated":
                attributeInfo = new DeprecatedAttribute();
                break;
            case "Exceptions":
                attributeInfo = new ExceptionsAttribute();
                break;
            case "LineNumberTable":
                attributeInfo = new LineNumberTableAttribute();
                break;
            case "LocalVariableTable":
                attributeInfo = new LocalVariableTableAttribute();
                break;
            case "SourceFile":
                attributeInfo = new SourceFileAttribute();
                break;
            case "Synthetic":
                attributeInfo = new SyntheticAttribute();
                break;
            default:
                attributeInfo = new UnparsedAttribute(attrName,attrLen);
        }
        attributeInfo.readInfo(classReader);
        return attributeInfo;
    }
}
