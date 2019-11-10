package homework;

public class Staff {    // задание 1
    private String name;
    private String position;
    private String phone;
    private double salary;
    private int age;
    private int id;    // задание 7
    private static int counter;

    Staff(String name, String position, String phone, double salary, int age){   // задание 2
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        id = counterId();  //  задание 7 - присвоение глобального значения соответствующему полю конкретного объекта
    }

    public String getName() {    // задание 3
        return name;
    }

    public String getPosition() {
        return position;
    }

    String getPhone() {
        return phone;
    }

    double getSalary() {
        return salary;
    }

    int getAge() {
        return age;
    }

    void getInfo() {  // к заданию 5
        System.out.printf("Имя: %s\t Должность: %s\t Тел.: %s\t Зарплата: %.2f\t Возраст: %d\n", name, position, phone, salary, age);
    }

//    void setSalaryfromAge1 (boolean isOlder, int age, double changeSalary) {  // задание 6 вариант 1
//        if (isOlder) {
//            if (this.age > age) {
//                salary += changeSalary;
//                if (salary < 0)
//                    salary = 0;
//            }
//        } else {
//            if (this.age < age) {
//                salary += changeSalary;
//                if (salary < 0)
//                    salary = 0;
//            }
//        }
//    }

    void setSalaryfromAge2 (int fromAge, int toAge, double changeSalary) {  // задание 6 вариант 2
        if (age >= fromAge && age < toAge) {    // с моей точки зрения более гибкий вариант: верхней границы возраста 100 хватит для реальных случаев
                salary += changeSalary;
                if (salary < 0)
                    salary = 0;
        }
    }

    private int counterId() {    // к заданию 7 - глобальный счетчик количества созданных объектов данного класса
        return ++counter;
    }

//    int getId() {    // к заданию 7
//        return id;
//    }
}
