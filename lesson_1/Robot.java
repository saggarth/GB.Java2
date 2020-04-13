package lesson_1;

public class Robot implements Member{
    private int runMax, jumpMax;

    @Override
    public void run() {
        System.out.println("Робот пробежал");
    }

    public void jump() {
        System.out.println("Робот прыгнул");
    }

    public int getRunMax() {
        return runMax;
    }

    public int getJumpMax() {
        return jumpMax;
    }

    public Robot(int runMax, int jumpMax) {
        this.runMax = runMax;
        this.jumpMax = jumpMax;
    }
}