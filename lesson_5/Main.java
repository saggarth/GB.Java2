package lesson_5;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE/2;
    public static float[] arr = new float[SIZE];
    public static long startTime;

    public static void main(String[] args) {
        singleThread();
        doubleThread();
    }

    public static void singleThread(){
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        System.out.println("Метод 1:");
        MyThread t = new MyThread("Один поток", arr);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public static void doubleThread(){
        float[] a1 =new float[HALF];
        float[] a2 =new float[HALF];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        System.out.println("Метод 2:");
        startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);
        System.out.println("Время разбивки: " + (System.currentTimeMillis() - startTime)  + " мс");
        MyThread t1 = new MyThread("Первый поток", a1);
        MyThread t2 =  new MyThread("Второй поток", a2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startTime = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        System.out.println("Время склейки: " + (System.currentTimeMillis() - startTime) + " мс");
    }

    static class MyThread extends Thread {
        float[] array;

        public MyThread(String name, float[] array) {
            super(name);
            this.array = array;
        }

        @Override
        public void run() {
            startTime = System.currentTimeMillis();
            for (int i = 0; i < array.length; i++) {
                array[i] = (float)(array[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
            }
            System.out.println(this.getName() + ", время выполнения: " + (System.currentTimeMillis() - startTime) + " мс");
        }
    }
}