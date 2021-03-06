package com.hoanpc.lesson22.view;

import com.hoanpc.lesson22.model.CrazyMath;
import com.hoanpc.lesson22.model.ScoreManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrazyMathPanel extends BasePanel implements ActionListener {
    private static final String SELECT_TRUE = "SELECT_TRUE";
    private static final String SELECT_FALSE = "SELECT_FALSE";
    private static final String SELECT_START = "SELECT_START";

    private static final int PADDING_START = 100;

    private JButton btnTrue;
    private JButton btnFalse;
    private JButton btnStartGame;

    private JLabel lbScore;
    private JLabel lbScoreNumber;

    private JLabel lbHighScore;
    private JLabel lbHighScoreNumber;

    private JLabel lbPlus;
    private JLabel lbEqual;

    private JTextField tfNumberOne;
    private JTextField tfNumberTwo;
    private JTextField tfAnswer;

    private CrazyMath crazyMath;
    private ScoreManager scoreManager;

    private Font myFont;
    private int myFontHeight;

    @Override
    public void initSubComponents() {
        crazyMath = new CrazyMath();
        scoreManager = new ScoreManager();

        initMyFont();
        initBtnStartGame();
        initLbScore();
        initLbHighScore();
        initTfNumberOne();
        initLbPlus();
        initTfNumberTwo();
        initLbEqual();
        initTfAnswer();
        initBtnTrue();
        initBtnFalse();
    }

    private void initMyFont() {
        myFont = new Font("Arial", Font.BOLD, 32);
        myFontHeight = getFontMetrics(myFont).getHeight();
    }

    private void initBtnFalse() {
        btnFalse = new JButton("FALSE");
        btnFalse.setBounds(tfNumberTwo.getX(), btnTrue.getY(), 100, 50);
        btnFalse.setActionCommand(SELECT_FALSE);
        add(btnFalse);
    }

    private void initBtnTrue() {
        btnTrue = new JButton("TRUE");
        btnTrue.setBounds(PADDING_START, tfNumberOne.getY() + tfNumberOne.getHeight() + 50, 100, 50);
        btnTrue.setActionCommand(SELECT_TRUE);
        add(btnTrue);
    }

    private void initTfAnswer() {
        tfAnswer = new JTextField();
        tfAnswer.setBounds(lbEqual.getX() + lbEqual.getWidth(), lbEqual.getY(), 100, myFontHeight);
        tfAnswer.setFont(myFont);
        tfAnswer.setEditable(false);
        add(tfAnswer);
    }

    private void initLbEqual() {
        lbEqual = new JLabel("=");
        lbEqual.setBounds(tfNumberTwo.getX() + tfNumberTwo.getWidth() + 20, tfNumberTwo.getY(), 50, myFontHeight);
        lbEqual.setFont(myFont);
        add(lbEqual);
    }

    private void initTfNumberTwo() {
        tfNumberTwo = new JTextField();
        tfNumberTwo.setBounds(lbPlus.getX() + lbPlus.getWidth(), lbPlus.getY(), 100, myFontHeight);
        tfNumberTwo.setFont(myFont);
        tfNumberTwo.setEditable(false);
        add(tfNumberTwo);
    }

    private void initLbPlus() {
        lbPlus = new JLabel("+");
        lbPlus.setBounds(tfNumberOne.getX() + tfNumberOne.getWidth() + 20, tfNumberOne.getY(), 50, myFontHeight);
        lbPlus.setFont(myFont);
        add(lbPlus);
    }

    private void initTfNumberOne() {
        tfNumberOne = new JTextField();
        tfNumberOne.setBounds(PADDING_START, 300 - myFontHeight, 100, myFontHeight);
        tfNumberOne.setFont(myFont);
        tfNumberOne.setEditable(false);
        add(tfNumberOne);
    }

    private void initLbScore() {
        lbScore = new JLabel("Your Score:");
        lbScore.setBounds(500, btnStartGame.getY(), 200, myFontHeight);
        lbScore.setFont(myFont);
        add(lbScore);

        lbScoreNumber = new JLabel("0");
        lbScoreNumber.setBounds(lbScore.getX() + lbScore.getWidth() + 10, lbScore.getY(), 50, lbScore.getHeight());
        lbScoreNumber.setFont(myFont);
        add(lbScoreNumber);
    }

    private void initLbHighScore() {
        lbHighScore = new JLabel("High Score:");
        lbHighScore.setBounds(lbScore.getX(), lbScore.getY() + lbScore.getHeight() + 20, 200, myFontHeight);
        lbHighScore.setFont(myFont);
        add(lbHighScore);

        lbHighScoreNumber = new JLabel("0");
        lbHighScoreNumber.setBounds(lbHighScore.getX() + lbHighScore.getWidth() + 10, lbHighScore.getY(), 50, lbHighScore.getHeight());
        lbHighScoreNumber.setFont(myFont);
        add(lbHighScoreNumber);
    }

    private void updateHighScoreNumber() {
        lbHighScoreNumber.setText(String.valueOf(scoreManager.getHighScore()));
    }

    private void initBtnStartGame() {
        btnStartGame = new JButton("Start Game");
        btnStartGame.setBounds(PADDING_START, 20, 100, 100);
        btnStartGame.setActionCommand(SELECT_START);
        add(btnStartGame);
    }

    @Override
    public void initListeners() {
        btnTrue.addActionListener(this);
        btnFalse.addActionListener(this);
        btnStartGame.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case SELECT_START: {
                startGame();
                break;
            }
            case SELECT_TRUE: {
                doOnTrueButton();
                break;
            }
            case SELECT_FALSE: {
                doOnFalseButton();
                break;
            }
        }
    }

    private void doOnFalseButton() {
        boolean result = crazyMath.checkQuestionNegative();
        if (result) {
            doOnTrueAnswer();
        } else {
            stopGame();
        }
    }

    private void doOnTrueButton() {
        boolean result = crazyMath.checkQuestionPositive();
        if (result) {
            doOnTrueAnswer();
        } else {
            stopGame();
        }
    }

    private void startGame() {
        updateHighScoreNumber();
        updateScoreValue();

        btnTrue.setEnabled(true);
        btnFalse.setEnabled(true);

        prepareQuestionUI();
    }

    private void stopGame() {
        btnTrue.setEnabled(false);
        btnFalse.setEnabled(false);
        tfNumberOne.setText(null);
        tfNumberTwo.setText(null);
        tfAnswer.setText(null);

        checkHighScore();
        scoreManager.setScore(0);
    }

    private void doOnTrueAnswer() {
        scoreManager.increaseScore();
        updateScoreValue();
        prepareQuestionUI();
    }

    private void prepareQuestionUI() {
        crazyMath.makeQuestion();
        tfNumberOne.setText(String.valueOf(crazyMath.getNumberOne()));
        tfNumberTwo.setText(String.valueOf(crazyMath.getNumberTwo()));
        tfAnswer.setText(String.valueOf(crazyMath.getAnswer()));
    }

    private void updateScoreValue() {
        lbScoreNumber.setText(String.valueOf(scoreManager.getScore()));
    }

    private void checkHighScore() {
        int score = scoreManager.getScore();
        if (scoreManager.isHighScore()) {
            String name = JOptionPane.showInputDialog(this, "Enter Your Name", "High Score", JOptionPane.INFORMATION_MESSAGE);
            if (name != null) {
                scoreManager.writeData(name, score);
                updateHighScoreNumber();
            } else {
                JOptionPane.showMessageDialog(this, "Your Score: " + score, "Game Over", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
