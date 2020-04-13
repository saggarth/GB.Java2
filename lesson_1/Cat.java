package lesson_1;

public class Cat implements Member{
    private int runMax, jumpMax;

    @Override
    public void run() {
        System.out.println("Кот пробежал");
    }

    public void jump() {
        System.out.println("Кот прыгнул");
    }

    public int getRunMax() {
        return runMax;
    }

    public int getJumpMax() {
        return jumpMax;
    }

    public Cat(int runMax, int jumpMax) {
        this.runMax = runMax;
        this.jumpMax = jumpMax;
    }
}