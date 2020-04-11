package lesson_1;

public class Main {
    public static void main(String[] args) {

        Member[] members = {
                new Cat(100, 1),
                new Human(1500, 2),
                new Robot(5000, 5)
        };

        Barrier[] barriers = {
                new Track(100),
                new Wall(1),
                new Track(1500),
                new Wall(2),
                new Track(5000),
                new Wall(5)
        };

        for (Member m : members) {
            boolean result = true;
            for (Barrier b : barriers) {
                System.out.println(b.getNAME() + " " + b.getValue() + " м");
                switch (b.getNAME()){
                    case "Стена":
                        result = (m.getJumpMax() >= b.getValue()) ? true: false;
                        if (result) {
                            m.jump();
                            System.out.println();
                        }
                        break;
                    case "Дорожка":
                        result = (m.getRunMax() >= b.getValue()) ? true: false;
                        if (result) {
                            m.run();
                            System.out.println();
                        }
                        break;
                }
                if (!result) {
                    System.out.println("Участник выбыл " + m.toString());
                    System.out.println();
                    break;
                }
            }
        }
    }
}