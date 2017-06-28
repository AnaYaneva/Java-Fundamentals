package P05BorderControl;

public abstract class Entities implements Checkable{
    private String ID;

    public Entities(String ID) {
        this.setID(ID);
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return ID;
    }
}
