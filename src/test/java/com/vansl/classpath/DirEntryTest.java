package com.vansl.classpath;

import com.vansl.util.IOUtil;

import java.io.IOException;

class DirEntryTest {

    @org.junit.jupiter.api.Test
    void readClass() throws IOException {
        String path = "target\\classes\\com\\vansl";
        String className = "Main.class";
        byte[] result = new DirEntry(path).readClass(className);
        System.out.println(IOUtil.bytesToHex(result));
    }
}