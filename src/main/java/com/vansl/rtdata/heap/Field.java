package com.vansl.rtdata.heap;

import com.vansl.classfile.MemberInfo;
import com.vansl.classfile.attribute.ConstantValueAttribute;
import lombok.Data;

@Data
public class Field extends ClassMember{

    private int slotId;             // 字段在实例/静态变量数组中的编号
    private int constValueIndex;    // 字段值在常量池里的索引

    public static Field[] newFields(Clazz clazz, MemberInfo[] classFileFields) {
        Field[] fields = new Field[classFileFields.length];
        for(int i=0;i<fields.length;i++) {
            fields[i] = new Field();
            fields[i].clazz = clazz;
            fields[i].copyMemberInfo(classFileFields[i]);
            fields[i].copyAttributes(classFileFields[i]);
        }
        return fields;
    }

    public void copyAttributes(MemberInfo classFileFiled) {
        ConstantValueAttribute attribute = classFileFiled.getConstantValueAttribute();
        if (attribute!=null) {
            constValueIndex = attribute.getConstantValueIndex();
        }
    }

    public boolean isPublic() {
        return (accessFlags&AccessFlags.ACC_PUBLIC.getFlag()) != 0;
    }

    public boolean isPrivate() {
        return (accessFlags&AccessFlags.ACC_PRIVATE.getFlag()) != 0;
    }

    public boolean isProtected() {
        return (accessFlags&AccessFlags.ACC_PROTECTED.getFlag()) != 0;
    }

    public boolean isStatic() {
        return (accessFlags&AccessFlags.ACC_STATIC.getFlag()) != 0;
    }

    public boolean isFinal() {
        return (accessFlags&AccessFlags.ACC_FINAL.getFlag()) != 0;
    }

    public boolean isVolatile() {
        return (accessFlags&AccessFlags.ACC_VOLATILE.getFlag()) != 0;
    }

    public boolean isTransient() {
        return (accessFlags&AccessFlags.ACC_TRANSIENT.getFlag()) != 0;
    }

    public boolean isSynthetic() {
        return (accessFlags & AccessFlags.ACC_SYNTHETIC.getFlag()) != 0;
    }

    public boolean isEnum() {
        return (accessFlags & AccessFlags.ACC_ENUM.getFlag()) != 0;
    }
}
