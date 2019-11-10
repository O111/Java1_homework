package homework;

public class Main {

    private static Staff[] pers = new Staff[5];

    public static void main(String[] args) {
        pers[0] = new Staff("Маг", "Босс", "999-9999", 1000000.01, 2019);
        pers[1] = new Staff("Некромант", "Советник", "666-6666", 666666.66, 666);
        pers[2] = new Staff("Варвар", "Помощник босса", "123-4567", 100000.01, 39);
        pers[3] = new Staff("Паладин", "Помощник помощника", "777-7777", 1000.01, 30);
        pers[4] = new Staff("Друид", "Волонтёр", "256-1024", 1.01, 18);

        for (int i = 0; i < pers.length; i++) {    // задание 4
            System.out.printf("Имя: %s\t Должность: %s\n", pers[i].getName(), pers[i].getPosition());
        }
        System.out.println();    // необязательная строка
        for (int i = 0; i < pers.length; i++) {    // задание 5
            if (pers[i].getAge() > 40)
                pers[i].getInfo();
        }

//        for (int i = 0; i < pers.length; i++) {    // задание 6 вариант 1
//            pers[i].setSalaryfromAge1(true, 45, 5000);
//        }

        for (int i = 0; i < pers.length; i++) {    // задание 6 вариант 2
            pers[i].setSalaryfromAge2(46, 3000, 5000);
        }
    }
}
