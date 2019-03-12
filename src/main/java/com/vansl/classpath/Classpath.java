package com.vansl.classpath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Classpath implements Entry{

    private Entry bootClasspath;
    private Entry extClasspath;
    private Entry userClasspath;

    public Classpath(String jreOption,String cpOption) {
        parseBootAndExtClasspath(jreOption);
        parseUserClasspath(cpOption);
    }

    public void parseBootAndExtClasspath(String jreOption) {
        String jreDir = getJreDir(jreOption);
        String jreLibPath = Paths.get(jreDir,"lib") + SEP + "*";
        System.out.println(jreLibPath);
        bootClasspath = new WildcardEntry(jreLibPath);
        String jreExtPath = Paths.get(jreDir ,"lib","ext") + SEP + "*";;
        extClasspath = new WildcardEntry(jreExtPath);
    }

    /*
     * @description 获取jre目录，查找顺序：-Xjre -> 当前目录下的jre目录 -> 环境变量
     * @date 2019-03-06 19:26:02
     **/
    public String getJreDir(String jreOption) {
        try {
            if (jreOption != null && new File(jreOption).exists()) {
                return jreOption;
            }
            if (new File("./jre").exists()) {
                return "./jre";
            }
            String JAVA_HOME = System.getenv("JAVA_HOME");
            if (JAVA_HOME != null) {
                return Paths.get(JAVA_HOME,"jre").toString();
            }
            throw new Exception("JRE not found");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    /*
     * @description 解析用户类路径，查找顺序：-cp -> 当前目录
     * @date 2019-03-07 10:15:23
     **/
    public void parseUserClasspath(String cpOption) {
        if (cpOption == null) {
            cpOption = ".";
        }
        userClasspath = EntryFactory.getEntry(cpOption);
    }

    @Override
    public byte[] readClass(String className) throws IOException, ClassNotFoundException {
        className = className + ".class";
        byte[] result;
        if ((result = bootClasspath.readClass(className))!=null) {
            return result;
        }
        if ((result = extClasspath.readClass(className))!=null) {
            return result;
        }
        return userClasspath.readClass(className);
    }

    @Override
    public String toString() {
        return userClasspath.toString();
    }

}
