package com.vansl.util;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class IOUtil {

    public static String bytesToHex(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        for(short b : bytes) {
            buf.append(String.format("%02x",new Integer(b & 0xff)));
        }
        return buf.toString();
    }

    // TODO NIO
    public static byte[] readClassFile(InputStream input) throws IOException {
        byte[] result = null;
        ByteArrayOutputStream  output = null;
        try{
            output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024*4];
            int n = 0;
            while (-1 != (n = input.read(buffer))) {
                output.write(buffer, 0, n);
            }
            result = output.toByteArray();
        }catch (Exception e) {
            throw e;
        }finally{
            try{
                if (input!=null) {
                    input.close();
                }
                if (output!=null) {
                    output.close();
                }
            }catch (Exception e2) {
                throw e2;
            }
        }
        return result;
    }

    public static byte[] readClassFile(String fullPath) throws IOException {
        return readClassFile(new FileInputStream(fullPath));
    }

//    public static byte[] readZipClassFile(String path,String className) throws IOException,ClassNotFoundException {
//        ZipFile zipFile = null;
//        try {
//            zipFile = new ZipFile(path);
//            Enumeration<? extends ZipEntry> entries = zipFile.entries();
//            while (entries.hasMoreElements()) {
//                ZipEntry zipEntry = entries.nextElement();
//                if (zipEntry.isDirectory()) {
//                    File file = new File(path+File.separator+zipEntry.getName());
//                    file.mkdirs();
//                } else if (zipEntry.getName().equals(className)) {
//                    InputStream inputStream = zipFile.getInputStream(zipEntry);
//                    return readClassFile(inputStream);
//                }
//            }
//            throw new ClassNotFoundException();
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            try {
//                // TODO: zipFile的缓存
//                if (zipFile!=null) {
//                    zipFile.close();
//                }
//            } catch (Exception e2) {
//                throw e2;
//            }
//        }
//    }

    public static byte[] readZipClassFile(String path,String className) throws IOException,ClassNotFoundException {
        List<byte[]> result = new ArrayList<>();
        FileSystem fileSystem = FileSystems.newFileSystem(Paths.get(path),null);

        Files.walkFileTree(fileSystem.getPath("/"), new MyFilesVisitor(className,result));
        if (result.size() != 0) {
            return result.get(0);
        }
        return null;
    }

    private static class MyFilesVisitor extends SimpleFileVisitor<Path> {

        private List<byte[]> result;

        private String className;

        public MyFilesVisitor(String className,List<byte[]> result) {
            this.className = className;
            this.result = result;
        }
        // 遍历文件
        @Override
        public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) throws IOException {
            if (filePath.toAbsolutePath().toString().equals(className)) {
                result.add(readClassFile(Files.newInputStream(filePath)));
                return FileVisitResult.TERMINATE;
            }
            return FileVisitResult.CONTINUE;
        }

        // 遍历目录
        @Override
        public FileVisitResult preVisitDirectory(Path dirPath, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    }
}
