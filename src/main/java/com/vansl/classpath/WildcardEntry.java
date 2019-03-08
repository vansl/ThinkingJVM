package com.vansl.classpath;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @description 使用通配符（*）指定某个目录下的所有JAR文件：java -cp classes;lib\*
 * @date 2019-03-04 13:11:46
 **/
public class WildcardEntry implements Entry{

    private List<Entry> subEntryList;

    public WildcardEntry(String path) {
        subEntryList = new ArrayList<>();
        // 去除结尾的"*"
        path = path.substring(0,path.length()-1);
        // 把相对路径转换为绝对路径
        String absPath = Paths.get(path).toAbsolutePath().toString();
        File dir = new File(absPath);
        for(File file:dir.listFiles()) {
            if (file.getName().endsWith(".jar")||file.getName().endsWith(".JAR")) {
                subEntryList.add(new ZipEntry(file.getPath()));
            }
        }
    }

    @Override
    public byte[] readClass(String className) {
        byte[] result = null;
        for (Entry entry:subEntryList) {
            try {
                result = entry.readClass(className);
            } catch (Exception e) {
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Entry entry:subEntryList) {
            result.append(entry.toString());
        }
        return result.toString();
    }
}
