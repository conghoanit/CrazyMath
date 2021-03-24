package com.hoanpc.lesson22.model;

import java.io.*;

public class ScoreManager {
    private int highScore;

    public ScoreManager() {
        highScore = readData();
    }

    private int readData() {
        try {
            String path = "D:\\data.txt";
            File file = new File(path);
            if (!file.exists()) {
                return 0;
            }
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String text = br.readLine();
            int firstIndexHighScore = text.lastIndexOf(".");
            String numberText = text.substring(firstIndexHighScore + 1);
            highScore = Integer.parseInt(numberText);

            fr.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return highScore;
    }

    public void writeData(String name, int highScore) {
        try {
            String path = "D:\\data.txt";
            File file = new File(path);
            FileWriter fr = new FileWriter(file);
            BufferedWriter br = new BufferedWriter(fr);

            br.write(name);
            br.write("...");
            br.write(String.valueOf(highScore));

            fr.flush();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getHighScore() {
        return highScore = readData();
    }
}
