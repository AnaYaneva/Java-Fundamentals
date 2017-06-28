package FilesAndDirsLab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//You are provided a folder named "Files-and-Streams". Create a program that lists the names of all directories in it (including all nested directories).
//On the last line, print the count of all folders, including the root folder.

public class NestedFolders {
    public static void main(String[] args) {

        String path="D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams";
        File root=new File(path);

        Deque<File> dirs=new ArrayDeque<>();
        dirs.offer(root);

        int count=1;
        while(!dirs.isEmpty()){
            File current=dirs.poll();
            File[]nestedDirs=current.listFiles();
            for (File dir : nestedDirs) {
                if (dir.isDirectory()){
                    dirs.offer(dir);
                    count++;
                }
            }
            System.out.println(current.getName());

        }
        System.out.printf("%d folders", count);





    }
}
