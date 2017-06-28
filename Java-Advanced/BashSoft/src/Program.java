
/*Commands list:
•	mkdir directoryName – make directory in current directory
•	ls (depth) – traverse current directory in given depth
•	cmp absolutePath1 absolutePath2 – comparing two files by given two absolute paths
•	changeDirRel relativePath – change current directory by a relative path
•	changeDirAbs absolutePath – change current directory by an absolute path
•	readDb dataBaseFileName – read students data base by given the name of the data base file which is searched in the current folder
•	filter courseName poor/average/excellent take 2/10/42/all – filter students from some course by given filter and add quantity for the number of students to take, or all, if you want to take all the students matching the current filter
•	order courseName ascending/descending take 3/26/52/all – order student from given course by ascending or descending order and then taking some quantity of the filter, or all that match it
•	download (path of file) – download file
•	downloadAsynch: (path of file) – download file asynchronously
•	help – get help
•	open – open file */

import IO.InputReader;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        //Lab: Sets and Maps II.7.
        //Repository.StudentsRepository.initialiazeData();
        //Repository.StudentsRepository.getStudentsByCourse("Java_fundamentals");

        //Lab: Files and Directories I.3
        //String test1path="C:\\Users\\PC\\IdeaProjects\\BashSoft\\test1.txt";
        //String test2path="C:\\Users\\PC\\IdeaProjects\\BashSoft\\test2.txt";
        //Judge.Tester.compareContent(test1path,test2path);

        //Lab: Files and Directories II.5
        //IO.IOManager.createDirectoryInCurrentFolder("pesho");

        //Lab: Regular Expressions 4.
        InputReader.readCommands();
    }
}
