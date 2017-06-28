package Repository;//Lab: Functional Programming II.4
//Lab: Stream API 2.
import IO.OutputWriter;

import java.util.*;
import java.util.stream.Collectors;

public class RepositorySorters {
    public static void printSortedStudents(HashMap<String, ArrayList<Integer>> courseData,
                                           String comparisonType,
                                           Integer numberOfStudents) {
        Comparator<Map.Entry<String,ArrayList<Integer>>> comparator=(x,y)->
                Double.compare(x.getValue().stream().mapToInt(Integer::valueOf).average().getAsDouble(),
                               y.getValue().stream().mapToInt(Integer::valueOf).average().getAsDouble());

        //ArrayList<Map.Entry<String,ArrayList<Integer>>> sortedStudents=new ArrayList<>();
        //sortedStudents.addAll(courseData.entrySet());
        //Collections.sort(sortedStudents,comparator);

        List<String> sortedStudents = courseData.entrySet()
                .stream()
                .sorted(comparator)
                .limit(numberOfStudents)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (comparisonType.equals("descending")) {
            Collections.reverse(sortedStudents);
        }

        for (String student : sortedStudents) {
            OutputWriter.printStudent(student, courseData.get(student));
        }
    }

}

    //Lab: Functional Programming II.5
    //private static Comparator<Map.Entry<String,ArrayList<Integer>>> createComparator(String comparisonType) {
    //    switch (comparisonType) {
    //        case "ascending":
    //            return new Comparator<Map.Entry<String, ArrayList<Integer>>>() {
    //                @Override
    //                public int compare(
    //                        Map.Entry<String, ArrayList<Integer>> firstStudent,
    //                        Map.Entry<String, ArrayList<Integer>> secondStudent) {

    //                    Double firstStudentTotal=getTotalScore(firstStudent.getValue());
    //                    Double secondStudentTotal=getTotalScore(secondStudent.getValue());

    //                    return firstStudentTotal.compareTo(secondStudentTotal);
    //                }
    //            };
    //        case "descending":
    //            return new Comparator<Map.Entry<String, ArrayList<Integer>>>() {
    //                @Override
    //                public int compare(
    //                        Map.Entry<String, ArrayList<Integer>> firstStudent,
    //                        Map.Entry<String, ArrayList<Integer>> secondStudent) {

    //                    Double firstStudentTotal=getTotalScore(firstStudent.getValue());
    //                    Double secondStudentTotal=getTotalScore(secondStudent.getValue());

    //                    return secondStudentTotal.compareTo(firstStudentTotal);
    //                }
    //            };
    //        default:
    //            return null;
    //    }

    //}

   //private static Double getTotalScore(ArrayList<Integer> grades) {
   //    Double total=0d;
   //    //TODO:
   //    for (Integer grade : grades) {
   //        total+=grade;
   //    }
   //    return total/grades.size();
   //}

