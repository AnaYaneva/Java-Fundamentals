package p03;

import java.util.stream.Stream;

public class CommandInterpreter {

    private Stack<Integer> stack;

    public CommandInterpreter() {
        this.stack = new Stack<>();
    }

    public Stack<Integer> getStack() {
        return this.stack;
    }

    private void setStack(Stack<Integer> stack) {
        this.stack = stack;
    }

    public void commandReader(String input){
        String []args=input.split("[\\s+|,]+");

        switch (args[0]){
            case "Push":
                Integer[]varargs= Stream.of(args)
                        .skip(1)
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
                this.stack.push(varargs);
                break;
            case "Pop":
                try{
                    this.stack.pop();
                }catch (UnsupportedOperationException ex){
                    System.out.println(ex.getMessage());
                }

        }
    }
}
