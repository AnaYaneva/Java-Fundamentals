package p02WarningLevels;

public class Message {
    private Importance impLevel;
    private String content;

    public Message(Importance impLevel, String content) {
        this.setImpLevel(impLevel);
        this.setContent(content);
    }

    public Importance getImpLevel() {
        return this.impLevel;
    }

    private void setImpLevel(Importance impLevel) {
        this.impLevel = impLevel;
    }

    public String getContent() {
        return this.content;
    }

    private void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.getImpLevel() +
                ": " + this.getContent();
    }
}
