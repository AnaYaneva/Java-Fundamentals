package StreamAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String facultyNumber;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private Integer group;
    private List<Integer> grades;
    private String phone;

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getGroup() {
        return group;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public String getPhone() {
        return phone;
    }


    public Student(String facultyNumber,
                   String firstName,
                   String lastName,
                   String email,
                   Integer age,
                   Integer group,
                   //List<Integer> grades,
                   String phone) {
        this.facultyNumber = facultyNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.group = group;
        this.grades = new ArrayList<>();
        this.phone = phone;
    }
}

    public class Main {
    public static void main(String[] args) {
       Path studentsDataPath= Paths.get("StudentData.txt");
        List<String>data=new ArrayList<>();

        try{
            data= Files.readAllLines(studentsDataPath);
        }catch (IOException e){
            e.printStackTrace();
        }

        List<Student> students=new ArrayList<>();
        fillStudentsList(data, students);

        //studentsByGroup(students);//1.

        //studentsByFirstAndLastName(students);//2.

        //studentsByAge(students);//3.

        //sortStudents(students);//4.

        //filterStudentsByEmailDomain(students);//5.

        //filterStudentsByPhone(students);//6.

        //excellentStudents(students);//7.

       //weekStudents(students);//8.
    }

    private static void weekStudents(List<Student> students) {
        students.stream()
                .filter(s -> {
                    List<Integer> grades = s.getGrades().stream()
                            .filter(g -> g <= 3)
                            .collect(Collectors.toList());
                    return grades.size() >= 2;
                })
                .sorted((s1, s2) ->
                        Integer.compare(s1.getGrades().stream().mapToInt(x -> x).sum(),
                                s2.getGrades().stream().mapToInt(x -> x).sum()))
                .forEach(s -> {
                    System.out.print(s.getFirstName() + " " + s.getLastName() + " ");
                    s.getGrades().stream()
                            .sorted(Integer::compareTo) // (g1, g2) -> g1.compareTo(g2)
                            .forEach(g -> System.out.print(g + " "));
                    System.out.println();
                });
    }

    private static void excellentStudents(List<Student> students) {
        students.stream()
                .filter(st->st.getGrades().contains(6))
                .forEach(student -> {
                    System.out.print(student.getFirstName()+" "+student.getLastName()+" ");
                    student.getGrades().stream()
                            .sorted((g1,g2)->g2.compareTo(g1))
                            .forEach(g-> System.out.print(g+" "));
                    System.out.println();
                });
    }

    private static void filterStudentsByPhone(List<Student> students) {
        students.stream()
                .filter(st->st.getPhone().startsWith("+3592")||st.getPhone().startsWith("02"))
                .forEach(student -> System.out.println(student.getFirstName()+" "+student.getLastName()+" "+student.getPhone()));
    }

    private static void filterStudentsByEmailDomain(List<Student> students) {
        students.stream()
                .filter(st->st.getEmail().endsWith("@gmail.com"))
                .forEach(student -> System.out.println(student.getFirstName()+" "+student.getLastName()+" "+student.getEmail()));
    }

    private static void sortStudents(List<Student> students) {
        Comparator<Student> lastAscending=
                (s1,s2)->s1.getLastName().compareTo(s2.getLastName());

        Comparator<Student> studentComparator=
                lastAscending
                        .thenComparing(
                                (s1,s2)->s2.getFirstName().compareTo(s1.getFirstName()));
        students.stream()
                .sorted(studentComparator)
                .forEach(student -> System.out.println(student.getFirstName()+" "+student.getLastName()));
    }

    private static void studentsByAge(List<Student> students) {
        students.stream()
                .filter(student->student.getAge()>=18&&student.getAge()<=24)
                .forEach(student -> System.out.println(student.getFirstName()+" "+student.getLastName()+" "+student.getAge()));
    }

    private static void fillStudentsList(List<String> data, List<Student> students) {
        for (int i = 1; i < data.size(); i++) {
            String[] tokens = data.get(i).split("\\s+");
            String facNumber = tokens[0];
            String firstName = tokens[1];
            String lastName = tokens[2];
            String email = tokens[3];
            Integer age = Integer.valueOf(tokens[4]);
            Integer group = Integer.valueOf(tokens[5]);
            String phone = tokens[10];

            Student student = new Student(
                    facNumber, firstName, lastName, email, age, group, phone);

            for (int gradeIndex = 6; gradeIndex <= 9; gradeIndex++) {
                Integer grade = Integer.valueOf(tokens[gradeIndex]);
                student.getGrades().add(grade);
            }

            students.add(student);

        }
    }

    private static void studentsByFirstAndLastName(List<Student> students) {
        students.stream()
                .filter(student->student.getFirstName().compareTo(student.getLastName())<0)
                .forEach(student -> System.out.println(student.getFirstName()+" "+student.getLastName()));
    }

    private static void studentsByGroup(List<Student> students) {
        students.stream()
                .filter(student -> student.getGroup()==2)
                .sorted((s1,s2) ->s1.getFirstName().compareTo(s2.getFirstName()))
                .forEach(student -> System.out.println(student.getFirstName()+" "+student.getLastName()));
    }
}
