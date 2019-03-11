package com.vansl.classpath;

import com.vansl.util.IOUtil;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @description 指定jar/zip文件：java -cp path\to\lib.jar
 * @date 2019-03-03 17:46:04
 **/
public class ZipEntry implements Entry{

    private String absPath;

    public ZipEntry(String path) {
        try {
            // 把相对路径转换为绝对路径
            absPath = Paths.get(path).toAbsolutePath().toString();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public byte[] readClass(String className) throws IOException, ClassNotFoundException {
        return IOUtil.readZipClassFile(absPath,className);
    }

    @Override
    public String toString() {
        return absPath;
    }

}
