package IO;//Lab: Manual String Processing 2.

import IO.IOManager;
import IO.OutputWriter;
import Judge.Tester;
import Repository.StudentsRepository;
import StaticData.SessionData;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CommandInterpreter {

    public static void interpretCommand(String input) throws IOException {
        String[] data=input.split("\\s+");
        String command=data[0];

        switch (command) {
            case "open":
//open – open file
                tryOpenFile(input, data);
                break;
            case "mkdir":
//TODO: mkdir directoryName – make directory in current directory
                tryCreateDirectory(input, data);
                break;
            case "ls":
//TODO: ls (depth) – traverse current directory in given depth
                tryTraverseFolders(input, data);
                break;
            case "cmp":
/*TODO: cmp absolutePath1 absolutePath2 –
comparing two files by given two absolute paths */
                tryCompareFiles(input, data);
                break;
            case "changeDirRel":
//TODO: changeDirRel relativePath – change current directory by a relative path
                tryChangeRelativePath(input, data);
                break;
            case "changeDirAbs":
//TODO: changeDirAbs absolutePath – change current directory by an absolute path
                tryChangeAbsolutePath(input, data);
                break;
            case "readDb":
/*TODO: readDb dataBaseFileName – read students data base by given the name
 of the data base file which is searched in the current folder  */
                tryReadDatabaseFromFile(input, data);
                break;
            case "filter":
/*TODO: filter courseName poor/average/excellent take 2/10/42/all –
filter students from some course by given filter and add quantity
for the number of students to take, or all, if you want to take all
the students matching the current filter */
                tryPrintFilteredStudents(input, data);
                break;
            case "order":
/*TODO: order courseName ascending/descending take 3/26/52/all –
order student from given course by ascending or descending
order and then taking some quantity of the filter, or all that match it*/
                tryPrintOrderStudents(input, data);
                break;
            case "download":
//TODO: download (path of file) – download file
                break;
            case "downloadAsynch:":
//TODO: downloadAsynch: (path of file) – download file asynchronously
                break;
            case "help":
//TODO: help – get help
                OutputWriter.writeMessageOnNewLine(" Commands list:\n" +
                        "•\tmkdir directoryName – make directory in current directory\n" +
                        "•\tls (depth) – traverse current directory in given depth\n" +
                        "•\tcmp absolutePath1 absolutePath2 – comparing two files by given two absolute paths\n" +
                        "•\tchangeDirRel relativePath – change current directory by a relative path\n" +
                        "•\tchangeDirAbs absolutePath – change current directory by an absolute path\n" +
                        "•\treadDb dataBaseFileName – read students data base by given the name of the data base file which is searched in the current folder\n" +
                        "•\tfilter courseName poor/average/excellent take 2/10/42/all – filter students from some course by given filter and add quantity for the number of students to take, or all, if you want to take all the students matching the current filter\n" +
                        "•\torder courseName ascending/descending take 3/26/52/all – order student from given course by ascending or descending order and then taking some quantity of the filter, or all that match it\n" +
                        "•\tdownload (path of file) – download file\n" +
                        "•\tdownloadAsynch: (path of file) – download file asynchronously\n" +
                        "•\thelp – get help\n" +
                        "•\topen – open file ");
                break;
            case "show":
                tryShowWantedCourse(input, data);
            default:
                displayInvalidCommandMessage(input);
                break;
        }
    }

    //Lab: Functional Programming III.7
    public static void tryPrintFilteredStudents(String input,String[] data) {
        //TODO:
        if (data.length!=3&&data.length!=4){
            displayInvalidCommandMessage(input);
        }

        String course=data[1];
        String filter=data[2];

        if (data.length==3){
            StudentsRepository.printFilteredStudents(course,filter,null);
        return;
        }

        Integer numberOfStudents=Integer.valueOf(data[3]);

        if (data.length==4){
            StudentsRepository.printFilteredStudents(course,filter,numberOfStudents);
        }
    }

    public static void tryPrintOrderStudents (String input,String[] data) {
//TODO:
        if (data.length!=3&&data.length!=4){
            displayInvalidCommandMessage(input);
        }

        String course=data[1];
        String filter=data[2];

        if (data.length==3){
            StudentsRepository.printOrderedStudents(course,filter,null);
            return;
        }

        Integer numberOfStudents=Integer.valueOf(data[3]);

        if (data.length==4){
            StudentsRepository.printOrderedStudents(course,filter,numberOfStudents);
        }
    }

    //Lab: Regular Expressions 3.
    private static void tryShowWantedCourse(String input, String[] data) {
        if (data.length!=2&&data.length!=3){
            displayInvalidCommandMessage(input);
        }

        if (data.length==2){
            String courseName=data[1];
            StudentsRepository.getStudentsByCourse(courseName);
        }

        if (data.length==3){
            String courseName=data[1];
            String userName=data[2];
            StudentsRepository.getStudentMarksInCourse(courseName,userName);
        }
    }
    //Lab: Manual String Processing 2.
    private static void tryReadDatabaseFromFile(String input, String[] data) throws IOException {
        if (data.length!=2){
            displayInvalidCommandMessage(input);
            return;
        }

        String fileName=data[1];
        StudentsRepository.initialiazeData(fileName);
    }

    private static void tryChangeAbsolutePath(String input, String[] data) {
        if (data.length!=2){
            displayInvalidCommandMessage(input);
            return;
        }

        String absolutePath=data[1];
        IOManager.changeCurrentDirAbsolute(absolutePath);
    }

    private static void tryChangeRelativePath(String input, String[] data) {
        if (data.length!=2){
            displayInvalidCommandMessage(input);
            return;
        }

        String relativePath=data[1];
        IOManager.changeCurrentDirRelativePath(relativePath);
    }

    private static void tryCompareFiles(String input, String[] data) {
        if (data.length!=3){
            displayInvalidCommandMessage(input);
            return;
        }

        String firstPath=data[1];
        String secondPath=data[2];

        Tester.compareContent(firstPath,secondPath);
    }

    private static void tryTraverseFolders(String input, String[] data) {
        if (data.length!=1&&data.length!=2){
            displayInvalidCommandMessage(input);
            return;
        }

        if (data.length==1){
            //TODO:
            OutputWriter.traverseFolder(0);
        }

        if (data.length==2){
            //TODO:
            OutputWriter.traverseFolder(Integer.valueOf(data[1]));
        }
    }

    private static void tryCreateDirectory(String input, String[] data) {
        if (data.length!=2){
            displayInvalidCommandMessage(input);
            return;
        }

        String folderName=data[1];
        IOManager.createDirectoryInCurrentFolder(folderName);
    }

    private static void tryOpenFile(String input, String[] data) {
        if (data.length!=2){
            displayInvalidCommandMessage(input);
            return;
        }

        String fileName=data[1];
        String filePath= SessionData.currentPath+"\\"+fileName;
        File file=new File(filePath);
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayInvalidCommandMessage(String input) {
        String output=String.format("The command '%s' is invalid", input);
        OutputWriter.writeMessageOnNewLine(output);
    }
}
