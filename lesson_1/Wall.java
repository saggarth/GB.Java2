package lesson_1;

public class Wall implements Barrier{
    final private String NAME = "Стена";
    private int value;

    public Wall(int height) {
        this.value = height;
    }

    @Override
    public String getNAME() {
        return NAME;
    }

    public int getValue() {
        return value;
    }
}