package com.vansl.rtdata.heap;

import com.vansl.classfile.ClassFile;
import com.vansl.classfile.MemberInfo;

/**
 * @description 字段/方法
 * @date 2019-03-14 14:04:29
 **/
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
}
