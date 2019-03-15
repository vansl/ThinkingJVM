package com.vansl.rtdata.heap;

import com.vansl.classfile.constantpool.ConstantMemberrefInfo;

/**
 * @description 字段/方法符号引用
 * @date 2019-03-14 23:26:25
 **/
public class MemberRef extends SymRef {

    String name;
    String descriptor;

    /**
     * @description 从class文件提取数据
     * @date 2019-03-14 22:12:36
     **/
    public void copyMemberRefInfo(ConstantMemberrefInfo constantMemberrefInfo){
        this.className = constantMemberrefInfo.getClassName();
        String[] nameAndDescriptor = constantMemberrefInfo.getNameAndDescriptor();
        this.name = nameAndDescriptor[0];
        this.descriptor = nameAndDescriptor[1];
    }
}
