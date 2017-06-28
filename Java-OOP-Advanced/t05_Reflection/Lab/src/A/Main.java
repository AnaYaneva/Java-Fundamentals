public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class aclass=Reflection.class;
        System.out.println(aclass);

        System.out.println(aclass.getSuperclass());

        Class[]interf=aclass.getInterfaces();
        for (Class aClass : interf) {
            System.out.println(aClass);
        }

        Reflection ref= (Reflection) aclass.newInstance();
        System.out.println(ref);
    }
}
