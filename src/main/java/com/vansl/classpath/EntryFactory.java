package com.vansl.classpath;

public class EntryFactory {

    public static Entry getEntry(String path) {
        if (path.contains(Entry.PATH_SEP)) {
            return new CompositeEntry(path);
        }
        if (path.endsWith("*")) {
            return new WildcardEntry(path);
        }
        if (path.endsWith(".jar")||path.endsWith(".zip")||
                path.endsWith(".JAR")||path.endsWith(".ZIP")) {
            return new ZipEntry(path);
        }
        return new DirEntry(path);
    }
}
