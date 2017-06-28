package DefineClassPerson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        /*P01
        Class person=Person.class;

        Field[] fields=person.getDeclaredFields();
        System.out.println(fields.length);*/

        /*P02
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        Class personClass = Person.class;

        Constructor emptyCtor = personClass.getDeclaredConstructor();
        Constructor ageCtor = personClass.getDeclaredConstructor(int.class);
        Constructor nameAgeCtor = personClass.getDeclaredConstructor(String.class, int.class);

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        Person basePerson = (Person) emptyCtor.newInstance();
        Person personWithAge = (Person) ageCtor.newInstance(age);
        Person personFull = (Person) nameAgeCtor.newInstance(name, age);

        System.out.printf("%s %s%n", basePerson.name, basePerson.age);
        System.out.printf("%s %s%n", personWithAge.name, personWithAge.age);
        System.out.printf("%s %s%n", personFull.name, personFull.age);*/

       /*P03
       InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        int n = Integer.parseInt(reader.readLine());

        List<Person> people=new ArrayList<>();

        while(n-->0){
            Person person=null;
            String[]tokens=reader.readLine().split("\\s+");
            String currName=tokens[0];
            int currAge=Integer.parseInt(tokens[1]);

            person=new Person(currName,currAge);
            people.add(person);
        }
        people.stream().filter(p->p.age>30)
                .sorted((p1,p2)->p1.name.compareTo(p2.name))
                .forEach(p-> System.out.println(p.name+" - "+p.age));*/

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        int n = Integer.parseInt(reader.readLine());

        Map<String,List<Employee>> employees=new HashMap<>();

        while(n-->0) {
            Employee employee = null;
            String[] tokens = reader.readLine().split("\\s+");
            String currName = tokens[0];
            double currSalary = Double.parseDouble(tokens[1]);
            String currPosition = tokens[2];
            String currDepart = tokens[3];
            //String currEmail;
            employees.putIfAbsent(currDepart,new ArrayList<>());

            switch (tokens.length) {
                case 4:
                    employee = new Employee(currName, currSalary, currPosition, currDepart);
                    break;
                case 5:
                    try {
                        int currAge = Integer.valueOf(tokens[4]);
                        employee = new Employee(currName, currSalary, currPosition, currDepart,currAge);
                    } catch (NumberFormatException ex) {
                        String currEmail = tokens[4];
                        employee = new Employee(currName, currSalary, currPosition, currDepart,currEmail);
                    }
                    break;
                case 6:
                    String currEmail = tokens[4];
                    int currAge = Integer.valueOf(tokens[5]);
                    employee = new Employee(currName, currSalary, currPosition, currDepart,currEmail,currAge);
                    break;
            }
            employees.get(currDepart).add(employee);
        }

        employees.entrySet().stream()
                .sorted((e1,e2)->Double.compare(
                        e2.getValue().stream().mapToDouble(a->a.getSalary()).average().getAsDouble(),
                        e1.getValue().stream().mapToDouble(a->a.getSalary()).average().getAsDouble()
                )).limit(1)
                .forEach(e->{
                    System.out.println(String.format("Highest Average Salary: %s",e.getKey()));
                    e.getValue().stream()
                                .sorted((e1,e2)->Double.compare(
                                        e2.getSalary(),e1.getSalary()
                                )).collect(Collectors.toList()).forEach(System.out::println);
                });
    }
}

