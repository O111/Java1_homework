package homework.lesson_5.zoo;

import homework.lesson_5.Animal;

public class Dog extends Animal {   // задание 1

    private final short maxRun = 500;    // задание 3
    private final float maxJump = 0.5f;
    private final short maxSwim = 10;

    private final short deltaRun = 100;    // задание 5
    private final float deltaJump = 1f;
    private final short deltaSwim = 10;

    public Dog(short maxDistRun, float maxDistJump, short maxDistSwim) {
        super(maxDistRun, maxDistJump, maxDistSwim);
    }

    public Dog() {
        new Dog(maxDistRun, maxDistJump, maxDistSwim);
        this.setAnimalParameters(maxRun,deltaRun,maxJump, deltaJump, maxSwim, deltaSwim);  // задание 5
    }

    public void run(short dist) {
        this.run(dist, "Пёсик пробежал!", "Пёсик не добежал");
    }

    public void jump(float dist) {
        this.jump(dist, "Пёсик перепрыгнул!", "Пёсик не допрыгнул");
    }

    public void swim(short dist) {
        this.swim(dist, "Пёсик проплыл!", "Пёсик не доплыл");
    }
}
