package lesson_1;

public class Track implements Barrier{
    final private String NAME = "Дорожка";
    private int value;

    public Track(int distance) {
        this.value = distance;
    }

    @Override
    public String getNAME() {
        return NAME;
    }

    public int getValue() {
        return value;
    }
}