package com.vansl.rtdata.heap;

import com.vansl.classfile.MemberInfo;

public class Field extends ClassMember{

    public static Field[] newFields(Clazz clazz, MemberInfo[] classFileFields) {
        Field[] fields = new Field[classFileFields.length];
        for(int i=0;i<fields.length;i++) {
            fields[i] = new Field();
            fields[i].clazz = clazz;
            fields[i].copyMemberInfo(classFileFields[i]);
        }
        return fields;
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
