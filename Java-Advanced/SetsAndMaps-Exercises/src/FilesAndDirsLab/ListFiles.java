package FilesAndDirsLab;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.io.File;

//You are provided a folder named "Files-and-Streams". Create a program that lists the names and file sizes (in bytes) of all files that are placed directly in it (do not include files in nested folders).

public class ListFiles {
    public static void main(String[] args) {
      File file=new File("D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams");

        if (file.exists()){
            if (file.isDirectory()){
                File[]files=file.listFiles();
                for (File file1 : files) {
                    if (!file1.isDirectory()) {
                        System.out.printf("%s: %s%n",file1.getName(),file1.length());
                    }
                }
            }
        }

    }
}
