package com.javalesson.javaio;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;

public class FileAttributor {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:\\Games");
//        System.out.println("Размер "+ Files.size(path));
//        System.out.println("Дата изменения "+ Files.getLastModifiedTime(path));
//        System.out.println("Можно ли изменять? "+ Files.isWritable(path));
//
//    FileStore fs = Files.getFileStore(path);
//
//    validateView(fs, BasicFileAttributeView.class);
//    validateView(fs, DosFileAttributeView.class);
//    validateView(fs, PosixFileAttributeView.class);
//    validateView(fs, AclFileAttributeView.class);
//    validateView(fs, UserDefinedFileAttributeView.class);
//    validateView(fs, FileOwnerAttributeView.class);

        DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println("дата создания "+dosFileAttributes.creationTime());
        System.out.println("Скрытая?"+dosFileAttributes.isHidden());

        UserPrincipal user = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("AGZ");
        AclFileAttributeView view = Files.getFileAttributeView(path, AclFileAttributeView.class);
        AclEntry acl = AclEntry.newBuilder().build();

    }

    private static void validateView(FileStore fs, Class<? extends  FileAttributeView> viewClass) {
        boolean supports = fs.supportsFileAttributeView(viewClass);
        System.out.println(" Помощь " +viewClass.getSimpleName()+" - "+ supports);
    }
}
