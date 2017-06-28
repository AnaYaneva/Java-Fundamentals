package IO;//Lab: Stacks and Queues I.2.

import StaticData.SessionData;

import java.util.LinkedList;
import java.io.File;
import java.util.List;

public class OutputWriter {
    public static void writeMessage(String message) {
        System.out.print(message);
    }

    public static void writeMessageOnNewLine(String message) {
        System.out.println(message);
    }

    public static void writeEmptyLine() {
        System.out.println();
    }

    public static void displayException(String message) {
        System.out.print(message);
    }

//Lab: Stacks and Queues II.3.
//Lab: Files and Directories II.6
    public static void traverseFolder(int depth) {
        LinkedList<File> subFolders=new LinkedList<>();
        String path= SessionData.currentPath;
        int initialIndentation=path.split("\\\\").length;

        File root=new File(path);

        subFolders.add(root);//?

        while(subFolders.size()!=0){
            File currentFolder=subFolders.removeFirst();
            int currentIndentation=currentFolder.toString().split("\\\\").length-initialIndentation;

            if (depth-currentIndentation<0){
                break;
            }

            OutputWriter.writeMessageOnNewLine(currentFolder.toString());

            if (currentFolder.listFiles()!=null){
                for (File file : currentFolder.listFiles()) {
                    if (file.isDirectory()){
                        //TODO
                        subFolders.add(file);
                    }else{
                        int indexOfLastSlash=file.toString().lastIndexOf("\\");
                        for (int i = 0; i <indexOfLastSlash ; i++) {
                            OutputWriter.writeMessage("-");
                        }

                        OutputWriter.writeMessageOnNewLine(file.getName());
                    }
                }
            }
            System.out.println(currentFolder.toString());
        }
    }

    //Lab: Sets and Maps II.5.

    public static void printStudent(String name, List<Integer>marks) {
        String output=String.format("%s - %s",name,marks.toString());
        OutputWriter.writeMessageOnNewLine(output);
    }
}
