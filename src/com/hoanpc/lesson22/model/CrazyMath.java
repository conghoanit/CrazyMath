package com.hoanpc.lesson22.model;

import java.util.Random;

public class CrazyMath {
    private int numberOne;
    private int numberTwo;
    private int trueAnswer;
    private int answer;
    private Random random;

    public CrazyMath() {
        random = new Random();
    }

    public void makeQuestion() {
        numberOne = random.nextInt(100);
        numberTwo = random.nextInt(100);
        trueAnswer = numberOne + numberTwo;
        if (numberOne % 2 == 0) {
            answer = trueAnswer;
        } else {
            answer = trueAnswer + 1 + new Random().nextInt(5);
        }
    }

    public boolean checkQuestionPositive() {
        if (answer == trueAnswer) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkQuestionNegative() {
        if (answer != trueAnswer) {
            return true;
        } else {
            return false;
        }
    }

    public int getNumberOne() {
        return numberOne;
    }

    public int getNumberTwo() {
        return numberTwo;
    }

    public int getTrueAnswer() {
        return trueAnswer;
    }

    public int getAnswer() {
        return answer;
    }
}
