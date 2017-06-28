package P11;

public class Tuple<E1,E2,E3> {
    private E1 item1;
    private E2 item2;
    private E3 item3;

    public Tuple(E1 item1, E2 item2,E3 item3) {
        this.setItem1(item1);
        this.setItem2(item2);
        this.setItem3(item3);
    }

    public E1 getItem1() {
        return this.item1;
    }

    private void setItem1(E1 item1) {
        this.item1 = item1;
    }

    public E2 getItem2() {
        return this.item2;
    }

    private void setItem2(E2 item2) {
        this.item2 = item2;
    }

    public E3 getItem3() {
        return this.item3;
    }

    private void setItem3(E3 item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return this.getItem1() +
                " -> " + this.getItem2()+" -> " + this.getItem3();
    }
}
