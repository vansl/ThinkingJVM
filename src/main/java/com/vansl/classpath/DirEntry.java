package com.vansl.classpath;


import com.vansl.util.IOUtil;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @description 目录型路径：java -cp path
 * @date 2019-03-03 16:15:47
 **/
public class DirEntry implements Entry {

    private String absPath;

    public DirEntry(String path) {
        try {
            // 把相对路径转换为绝对路径
            absPath = Paths.get(path).toAbsolutePath().toString();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        String fullPath = Paths.get(absPath,className).toString();
        return IOUtil.readClassFile(fullPath);
    }

    @Override
    public String toString() {
        return absPath;
    }
}
