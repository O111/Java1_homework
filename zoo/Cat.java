package homework.lesson_5.zoo;

import homework.lesson_5.Animal;

public class Cat extends Animal {   // задание 1

    private final short maxRun = 200;    // задание 3
    private final float maxJump = 2f;
    private final short maxSwim = 0;

    private final short deltaRun = 50;    // задание 5
    private final float deltaJump = 1f;
    private final short deltaSwim = 2;

    public Cat(short maxDistRun, float maxDistJump, short maxDistSwim) {
        super(maxDistRun, maxDistJump, maxDistSwim);
    }

    public Cat() {    // задание 3
        new Cat(maxDistRun, maxDistJump, maxDistSwim);
        this.setAnimalParameters(maxRun,deltaRun,maxJump, deltaJump, maxSwim, deltaSwim);  // задание 5
    }

    public void run(short dist) {    // задания 2 и 4
        this.run(dist, "Котик пробежал!", "Котик не добежал");
    }

    public void jump(float dist) {
        this.jump(dist, "Котик перепрыгнул!", "Котик не допрыгнул");
    }

    public void swim(short dist) {
        this.swim(dist, "Котик проплыл!!!", "Котик не любит плавать, не доплыл");
    }
}
