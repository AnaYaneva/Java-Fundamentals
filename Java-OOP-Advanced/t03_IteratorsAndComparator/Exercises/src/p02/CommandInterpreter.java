package p02;

import java.util.stream.Stream;

public class CommandInterpreter {

    ListyIterator<String> iterator;

    public void readCommands(String input){
        String[]args=input.split("\\s+");
        switch (args[0]){
            case "Create":
                String[]varargs= Stream.of(args).skip(1)
                        .toArray(String[]::new);
                iterator=new ListyIterator<>(varargs);
                break;
            case "Move":
                System.out.println(iterator.move());
                break;
            case "HasNext":
                System.out.println(iterator.hasNext());
                break;
            case "Print":
                iterator.print();
                break;
            case "PrintAll":
                iterator.printAll();
        }
    }
}
