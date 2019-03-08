package com.vansl.classpath;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 指定多个目录/文件：java -cp path\to\classes;lib\a.jar;lib\b.jar;lib\c.zip ...
 * @date 2019-03-03 17:56:46
 **/
public class CompositeEntry implements Entry{

    private List<Entry> subEntryList;

    public CompositeEntry(String pathList) {
        subEntryList = new ArrayList<>();
        for(String path:pathList.split(PATH_SEP)) {
            subEntryList.add(EntryFactory.getEntry(path));
        }
    }

    @Override
    public byte[] readClass(String className) {
        byte[] result = null;
        for (Entry entry:subEntryList) {
            result = entry.readClass(className);
            if (result!=null) {
                return result;
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
