public class Smartphone implements Browseable,Callable {

    @Override
    public void Call(String number) {
        System.out.printf("Calling... %s\n",number);
    }

    @Override
    public void Browse(String url) {
        System.out.printf("Browsing: %s!\n",url);
    }
}
