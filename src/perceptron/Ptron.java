package perceptron;

import java.awt.Font;
import java.util.ArrayList;


/**
 *
 * @author Tom
 */
public class Ptron {

    PPanel panel;
    int x;
    int eta = 1;
    int[][] detectors;
    int[][] weights;
    ArrayList<Integer> trainingList;
    ArrayList<Integer> pTronOutput;
    PatternList patterns;
    String path;
    int threshold = 200;
    boolean DEBUG = false;
    boolean errors = true;
    int patternNo = 0; // Number of the pattern we are currently looping through 0 to 29 i.e. 30 patterns
    int[][] selectedPatternWeights;
    ArrayList<Integer> wrongList;

    Ptron() {

    }

    Ptron(PPanel panel, String path) {
        this.panel = panel;
        this.patterns = panel.getPatterns();
        this.path = path;
        x = patterns.get(0).list.get(0).length(); // getting dimensions of the detector
        System.out.println("x= " + x);
        detectors = new int[x][x];
        weights = new int[x][x];
        this.trainingList = patterns.getTraininglist();
        pTronOutput = new ArrayList<>();

    }

    void run() {
        int count = 0;
        int right;
        int wrong;
        while (errors) {
            right = 0;
            wrong = 0;
            wrongList = new ArrayList<>();
            count ++;
            errors = false;
            pTronOutput.clear();

            for (int i = 0; i < patterns.size(); i++) { // for each pattern
                initDetectors(patterns.get(i));
                int output = categorize(patterns.get(i));

                if (output != patterns.get(i).getYes()) {
                    wrong ++;
                    wrongList.add(i+1);
                    errors = true;
                    learn(patterns.get(i), output);

                } else{
                    right ++;
                }
                
                pTronOutput.add(output);
                //displayPattern(patterns.get(i));

                //new PauseDialog();
            }
            System.out.println("Run through " + count + " has identified: " + right + " correct, and " + wrong + " incorrect");
            System.out.println("Incorrectly identified patterns: " + wrongList );
            panel.setTheTA("\n\nRun through " + count + " has identified: " + right + " correct, and " + wrong + " incorrect");
            panel.setTheTA("\nIncorrectly identified patterns: " + wrongList );
        }
        System.out.println("FINISHED");
        panel.setTheOutputTA("\nFINISHED");

        System.out.println("trueCategory= " + trainingList.toString());
        panel.setTheOutputTA("\n\ntrueCategory= " + trainingList.toString());

        System.out.println("pTron Final Output= " + pTronOutput.toString());
        panel.setTheOutputTA("\npTron Output= " + pTronOutput.toString());

        System.out.println("Time through = " + count);
        panel.setTheOutputTA("\n\nRuns through = " + count);

    }

    private void initDetectors(Pattern p) {
        detectors = new int[x][x];
        int patternSize = x; // get the actual length / width of a pattern       
        for (int i = 0; i < patternSize; i++) {
            //panel.setTheTA("\t");
            for (int j = 0; j < patternSize; j++) {
                if (p.getList().get(i).charAt(j) == '*') {
                    detectors[i][j] = 1;
                }
                //panel.setTheTA("" + detectors[i][j]);
                //System.out.print(detectors[i][j]);
            }
            //panel.setTheTA("\n");
            //System.out.println("\n");
        }
        // panel.setTheTA("\n\n\n");

    }

    private int categorize(Pattern p) {
        int sum = 0;
        int output;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                sum += detectors[i][j] * weights[i][j];
                //System.out.println("sum = " + sum);
            }
        }
        if (sum > threshold) {
            output = 1;
            //System.out.println("YES");
        } else {
            output = 0;
            //System.out.println("NO");
        }
        return output;
    }

    private void learn(Pattern p, int o) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                int t = p.yes;
                weights[i][j] += ((t - o) * detectors[i][j] * eta);
                if (DEBUG) {
                    System.out.println("weight= " + weights[i][j]);
                }
            }
        }
    }

    public String toStringTrainingList() {
        return trainingList.toString();
    }

    public String toStringFinalOutput() {
        return pTronOutput.toString();
    }

    void displayPatterns(PatternList patterns) {
        Font font = new Font("Verdana", Font.PLAIN, 12);
        panel.setTAFont(font);

        panel.setTheTA("\n");
        for (Pattern p : patterns) {
            int[][] display = new int[x][x];
            int patternSize = x - 1; // get the actual length / width of a pattern       
            for (int i = 0; i < patternSize; i++) {
                panel.setTheTA("        ");
                for (int j = 0; j < patternSize; j++) {

                    if (p.getList().get(i).charAt(j) == '*') {
                        display[i][j] = 1;
                    }
                    panel.setTheTA("" + display[i][j]);

                }
                panel.setTheTA("\n");

            }
            panel.setTheTA("\n\n\n");
        }
        panel.setTACarat(0);

    }

    private String outputText(int i) {
        return (i == 1) ? "YES" : "NO";
    }

    void displayPattern(Pattern p) {
        panel.clearTheTA();
        panel.setTheTA("\n");

        //int[][] display = new int[x][x];
        int patternSize = x - 1; // get the actual length / width of a pattern       
        for (int i = 0; i < patternSize; i++) {
            panel.setTheTA("        ");
            for (int j = 0; j < patternSize; j++) {

                panel.setTheTA(" " + p.getList().get(i).charAt(j));

            }
            panel.setTheTA("\n");
        }

        panel.setTheTA("\n");

        for (int i = 0; i < patternSize; i++) {
            panel.setTheTA("        ");

            for (int j = 0; j < patternSize; j++) {

                panel.setTheTA(" " + weights[i][j]);

            }
            panel.setTheTA("\n");

        }
        panel.setTACarat(0);
    }

    public Integer getCurrentPattern() {
        return patternNo;
    }
    
    void setCurrentPattern(int x){
        patternNo = x;
    }
}
