package Repository;//Lab: Sets and Maps I.2.

import IO.OutputWriter;
import StaticData.ExceptionMessages;
import StaticData.SessionData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentsRepository {

    public static boolean isDataInitialiazed = false;
    public static HashMap<String, HashMap<String, ArrayList<Integer>>> studentsByCourse;

    //Lab: Sets and Maps I.3.
    //Lab: Manual String Processing 2.
    public static void initialiazeData(String fileName) throws IOException {
        if (isDataInitialiazed) {
            System.out.println(ExceptionMessages.DATA_ALREADY_INITIALIZED);
            return;
        }

        studentsByCourse = new HashMap<String, HashMap<String, ArrayList<Integer>>>();
        readData(fileName);
    }
    
    //Lab: Sets and Maps I.3.
    //Lab: Manual String Processing 2.
    //Lab: Regular Expressions 2.
    public static void readData(String fileName) throws IOException {
        String regex="([A-Z][a-zA-Z#+]*_[A-Z][a-z]{2}_\\d{4})\\s+([A-Z][a-z]{0,3}\\d{2}_\\d{2,4})\\s+(\\d+)";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher;

        String path= SessionData.currentPath+"\\"+fileName;
        List<String> lines= Files.readAllLines(Paths.get(path));
        //Scanner scanner = new Scanner(System.in);
        //String input = scanner.nextLine();

        //while (!input.equals("")) {
        for (String line : lines) {
            matcher = pattern.matcher(line);

            if (!line.isEmpty() && matcher.find()) {
                String course = matcher.group(1);
                String student = matcher.group(2);
                Integer mark = Integer.parseInt(matcher.group(3));


                //String[] tokens = line.split("\\s+");
                //String course = tokens[0];
                //String student = tokens[1];
                //Integer mark = Integer.parseInt(tokens[2]);

                if (mark >= 0 && mark <= 100) {
                    if (!studentsByCourse.containsKey(course)) {
                        studentsByCourse.put(course, new HashMap<>());
                    }

                    if (!studentsByCourse.get(course).containsKey(student)) {
                        studentsByCourse.get(course).put(student, new ArrayList<>());
                    }

                    studentsByCourse.get(course).get(student).add(mark);
                    //input = scanner.nextLine();
                }
            }
        }

        isDataInitialiazed = true;
        OutputWriter.writeMessageOnNewLine("Data read.");
    }

//Lab: Sets and Maps I.4.
    private static boolean isQueryForCoursePossible(String courseName){
        if (!isDataInitialiazed){
            OutputWriter.displayException(ExceptionMessages.DATA_NOT_INITIALIZED);
            return false;
        }

        if (!studentsByCourse.containsKey(courseName)){
            OutputWriter.displayException(ExceptionMessages.NON_EXISTENT_COURSE);
        }

        return true;
    }

    private static boolean isQueryForStudentPossiblе(String courseName, String studentName){
        if (!isQueryForCoursePossible(courseName)){
            return false;
        }

        if (!studentsByCourse.get(courseName).containsKey(studentName)){
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_STUDENT);
            return false;
        }

        return true;
    }

    //Lab: Sets and Maps II.6.
    public  static void getStudentMarksInCourse(String course, String student){
        if(!isQueryForStudentPossiblе(course,student)){
            return;
        }

        ArrayList<Integer> marks=studentsByCourse.get(course).get(student);
        OutputWriter.printStudent(student,marks);
    }

    public  static void getStudentsByCourse(String course) {
        if (!isQueryForCoursePossible(course)) {
            return;
        }

        OutputWriter.writeMessageOnNewLine(course + ":");
        for (Map.Entry<String, ArrayList<Integer>> student : studentsByCourse.get(course).entrySet()) {
            OutputWriter.printStudent(student.getKey(), student.getValue());
        }
    }

    //Lab: Functional Programming III.6
    public static void printFilteredStudents(String course, String filter, Integer numberOfStudents ) {
        if (!isQueryForCoursePossible(course)){
            return;
        }

        if (numberOfStudents==null){
            numberOfStudents=studentsByCourse.get(course).size();
        }

        RepositoryFilters.printFilteredStuents(studentsByCourse.get(course),filter,numberOfStudents);
    }

    public static void printOrderedStudents(String course, String compareType, Integer numberOfStudents ) {
        if (!isQueryForCoursePossible(course)){
            return;
        }

        if (numberOfStudents==null){
            numberOfStudents=studentsByCourse.get(course).size();
        }

        RepositoryFilters.printFilteredStuents(studentsByCourse.get(course),compareType,numberOfStudents);
    }
}