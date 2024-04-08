package javatests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSystemArray {
    private static final String FILE_NAME = "TREE.txt";
    public static void main(String[] args) throws IOException {
        File[] disks=File.listRoots();

        //File files = new File("D:\\AI");
        FileWriter fileWriter = new FileWriter(FILE_NAME);

        try (PrintWriter writer = new PrintWriter(fileWriter)) {

            for (File disk : disks) {
                writer.write(String.valueOf(disk+"\n"));
                nextPath(disk, writer);

            }
        }

    }

    private static void nextPath(File f, PrintWriter writer) {
        String[] sPaths = f.list();
        File[] fPaths = f.listFiles();

        if (sPaths != null && fPaths != null) {
            for (int i = 0; i < sPaths.length; i++) {

                for (int j = 0; j < fPaths[i].toPath().getNameCount(); j++) {
                    writer.write("   ");
                }

                writer.write(sPaths[i] + "\n");

                if (fPaths[i].isDirectory()) {
                    nextPath(fPaths[i], writer);
                }
            }
        }
    }

}



