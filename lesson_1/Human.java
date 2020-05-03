package lesson_1;

public class Human implements Member{
    private int runMax, jumpMax;

    @Override
    public void run() {
        System.out.println("Человек пробежал");
    }

    public void jump() {
        System.out.println("Человек прыгнул");
    }

    public int getRunMax() {
        return runMax;
    }

    public int getJumpMax() {
        return jumpMax;
    }

    public Human(int runMax, int jumpMax) {
        this.runMax = runMax;
        this.jumpMax = jumpMax;
    }
}