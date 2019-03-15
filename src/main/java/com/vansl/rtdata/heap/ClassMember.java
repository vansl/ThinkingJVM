package com.vansl.rtdata.heap;

import com.vansl.classfile.ClassFile;
import com.vansl.classfile.MemberInfo;
import lombok.Data;

/**
 * @description 字段/方法
 * @date 2019-03-14 14:04:29
 **/
@Data
public class ClassMember {

    int accessFlags;
    String name;
    String descriptor;
    Clazz clazz;

    /**
     * @description 把classfile中的member复制到classMember中
     * @date 2019-03-14 14:31:13
     **/
    public void copyMemberInfo(MemberInfo memberInfo) {
        accessFlags = memberInfo.getAccessFlags();
        name = memberInfo.getName();
        descriptor = memberInfo.getDescriptor();
    }

    /**
     * @description 访问权限
     * @date 2019-03-15 20:01:02
     **/
    public boolean isAccessibleTo(Clazz d) {
        if (isPublic()) {
            return true;
        }
        Clazz c = clazz;
        if (isProtected()) {
            return d == c || /*d.isSubClassOf(c) || TODO */
                    c.getPackageName().equals(d.getPackageName());
        }
        if (!isPrivate()) {
            return c.getPackageName().equals(d.getPackageName());
        }
        return d == c;
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
}
