package IO;//Lab: Stacks and Queues I.1.

import StaticData.ExceptionMessages;
import StaticData.SessionData;

import java.io.File;

public class IOManager {
    //Lab: Files and Directories II.5
    public static void createDirectoryInCurrentFolder(String name){
        String path=getCurrentDirectoryPath()+"\\"+name;
        File file=new File(path);
        file.mkdir();
    }

    public static String getCurrentDirectoryPath() {
        String currentPath= SessionData.currentPath;
        return currentPath;
    }

    //Lab: Files and Directories II.7
    public static void changeCurrentDirRelativePath(String relativePath){
        if (relativePath.equals("..")){
            //go one dir up
            String currentPath= SessionData.currentPath;
            int indexOfLastLash=currentPath.lastIndexOf("\\");
            String newPath=currentPath.substring(0,indexOfLastLash);
            SessionData.currentPath=newPath;
        }else{
            //go to a given dir
            String currentPath= SessionData.currentPath;
            currentPath+="\\"+relativePath;
            changeCurrentDirAbsolute(currentPath);
        }
    }

    public static void changeCurrentDirAbsolute(String absolutePath) {
        File file=new File(absolutePath);
        if (!file.exists()){
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);
            return;
        }

        SessionData.currentPath=absolutePath;
    }
}
