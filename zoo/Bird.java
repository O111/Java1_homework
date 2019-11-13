package homework.lesson_5.zoo;

import homework.lesson_5.Animal;

public class Bird extends Animal {   // задание 1

    private final short maxRun = 5;    // задание 3
    private final float maxJump = 0.2f;
    private final short maxSwim = 0;

    private final short deltaRun = 6;    // задание 5
    private final float deltaJump = 0.3f;
    private final short deltaSwim = 2;

    public Bird(short maxDistRun, float maxDistJump, short maxDistSwim) {
        super(maxDistRun, maxDistJump, maxDistSwim);
    }

    public Bird() {
        new Bird(maxDistRun, maxDistJump, maxDistSwim);
        this.setAnimalParameters(maxRun,deltaRun,maxJump, deltaJump, maxSwim, deltaSwim);
    }

    public void run(short dist) {
        this.run(dist, "Птичка пробежала!", "Птичка не добежала");
    }

    public void jump(float dist) {
        this.jump(dist, "Птичка перепрыгнула!", "Птичка не допрыгнула");
    }

    public void swim(short dist) {
        this.swim(dist, "Птичка проплыла!!!", "Птичка плавать не любит");
    }
}
