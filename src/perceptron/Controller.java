/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author tmerkle
 */
public class Controller extends Thread {

    private final PPanel thePanel;
    private boolean running = false;
    private boolean DEBUGGING = true;
    Ptron tron;
    int delay = 30;

    int patternX = 75, patternY = 100, weightsX = 75, weightsY = 350, boxSize = 10;

    PatternList patterns;
    public int patternDim = 20;

    Controller(PPanel panel) {
        thePanel = panel;
        patterns = thePanel.getPatterns();
        tron = thePanel.getTron();

    }

    public void run() {
        for (;;) {
            if (running) {
                step();
            }
            delay();
        }

    }

    void paint(Graphics g) {
        initPatternGrid(g);
        initWeightsGrid(g);
    }

    public void step() {
        thePanel.step();
    }

    private void delay() {
        try {
            this.sleep(delay);
        } catch (Exception ex) {

        }
    }

    void startStop() {
        running = !running;
    }

    void stopit() {
        running = false;
    }

    void startit() {
        running = true;
    }

    void initPatternGrid(Graphics g) {
        int patternNo = thePanel.tron.getCurrentPattern();

        for (int row = 0; row < patternDim; row++) {
            for (int col = 0; col < patternDim; col++) {
                if (patterns.get(patternNo).getList().get(row).charAt(col) != '*') {
                    g.setColor(Color.white);
                }
                g.fillRect(patternX + col * boxSize, patternY + row * boxSize, boxSize, boxSize);
                g.setColor(Color.BLACK);
            }
        }
    }

    private void initWeightsGrid(Graphics g) {

        for (int row = 0; row < patternDim; row++) {
            for (int col = 0; col < patternDim; col++) {
                int dist = Math.abs(tron.weights[row][col]);

                if (tron.weights[row][col] < 0) {
                    g.setColor(Color.RED);
                } else if (tron.weights[row][col] > 0) {
                    g.setColor(Color.GREEN);
                } else {

                    g.setColor(Color.BLUE);
                }

                g.fillRect(weightsX + col * boxSize, weightsY + row * boxSize, boxSize, boxSize);

            }
        }
    }



}
