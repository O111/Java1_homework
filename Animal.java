package homework.lesson_5;

import java.util.Random;

public class Animal {

    protected short maxDistRun;    // задание 3
    protected float maxDistJump;
    protected short maxDistSwim;

    protected Animal(short maxDistRun, float maxDistJump, short maxDistSwim) {
        this.maxDistRun = maxDistRun;
        this.maxDistJump = maxDistJump;
        this.maxDistSwim = maxDistSwim;
    }

    protected Animal() {        // задание 3
        new Animal(maxDistRun, maxDistJump, maxDistSwim);
    }

    protected void setAnimalParameters(short run, short deltaRun, float jump, float deltaJump, short swim, short deltaSwim) {    // задание 5
        Random random = new Random();
        this.maxDistRun = (short) (run - deltaRun + random.nextInt(2 * deltaRun + 1));
        this.maxDistJump = (float) (jump - deltaJump + 0.1 * random.nextInt((int) (20 * deltaJump) + 1));
        this.maxDistSwim = (short) (swim - deltaSwim + random.nextInt(2 * deltaSwim + 1));
        if (this.maxDistRun < 0)
            this.maxDistRun = (short) 0;
        if (this.maxDistJump < 0)
            this.maxDistJump = 0f;
        if (this.maxDistSwim < 0)
            this.maxDistSwim = (short) 0;
    }

    protected boolean isRun(short dist) {    // к заданию 4
        boolean isRun = false;
        if (this.maxDistRun >= dist) {
            isRun = true;
        }
        return isRun;
    }

    protected boolean isJump(float dist) {
        boolean isJump = false;
        if (this.maxDistJump >= dist) {
            isJump = true;
        }
        return isJump;
    }

    protected boolean isSwim(short dist) {
        boolean isSwim = false;
        if (this.maxDistSwim >= dist) {
            isSwim = true;
        }
        return isSwim;
    }

    protected void run(short dist, String s1, String s2) {    // задания 2 и 4
        if (this.isRun(dist)) {
            System.out.println(s1);
        } else {
            System.out.printf(s2 + " :( Пройденная дистанция %d м из %d.\n", this.maxDistRun, dist);
        }
    }

    protected void run(short dist) {
        String s1 = "";
        String s2 = "";
        this.run(dist, s1, s2);
    }

    protected void jump(float dist, String s1, String s2) {
        if (this.isJump(dist)) {
            System.out.println(s1);
        } else {
            System.out.printf(s2 + " :( Достигнутая высота %.2f м из %.2f.\n", this.maxDistJump, dist);
        }
    }

    protected void jump(float dist) {
        String s1 = "";
        String s2 = "";
        this.jump(dist, s1, s2);
    }

    protected void swim(short dist, String s1, String s2) {
        if (this.isSwim(dist)) {
            System.out.println(s1);
        } else {
            System.out.printf(s2 + " :( Проплыто %d м из %d.\n", this.maxDistSwim, dist);
        }
    }

    protected void swim(short dist) {
        String s1 = "";
        String s2 = "";
        this.swim(dist, s1, s2);
    }
}
