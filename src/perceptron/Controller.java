/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import java.awt.Graphics;

/**
 *
 * @author tmerkle
 */
public class Controller extends Thread {

    private boolean running = false;
    private final PPanel thePanel;
    
    private boolean DEBUGGING = true;
    
    Controller(PPanel panel) {
        thePanel = panel;
        

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


    }

    public void step() {
        


    }

    private void delay() {
        try {
            this.sleep(30);
        } catch (Exception ex) {

        }
    }

    void startStop() {
        running = !running;
    }

   void stopit(){
        running = false;
    }
   
   void startit(){
       running = true;
   }
}
