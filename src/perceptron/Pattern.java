package perceptron;

import perceptron.io.MyReader;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public final class Pattern {

    StringList list = new StringList();
    int yes;
    int[][] matrix;
    PPanel panel;
    int x;

    Pattern(String absolutepath) {
        
        MyReader mr = new MyReader(absolutepath);
        while (mr.hasMoreData()) {
            list.add(mr.giveMeTheNextLine());
        }
        
        mr.close();
        initDetectorsFromText();
        initTeaching();
    }

    Pattern(PPanel p) {

        panel = p;
        x = panel.getDrawingDim();
        initDetectorsFromDrawingPad();
        initList();
        initTeaching();
    }

    public StringList getList() {
        return list;
    }

    public void setList(StringList list) {
        this.list = list;
    }

    public String toString() {
        String ret = "";
        for (String s : list) {
            ret += s + "\n";
        }
        return ret;
    }

    private void initTeaching() {
        if (list.get(list.size() - 1).isEmpty()) {
            list.remove(list.size() - 1);
        }
        if (list.get(list.size() - 1).equals("yes")) {
            yes = 1;

        } else {
            yes = 0;

        }

    }

    int getYes() {
        return yes;
    }

    void initDetectorsFromText() {
        x = list.get(0).length();
        int[][] returnMe = new int[x][x];
       
        int patternSize = x; // get the actual length / width of a pattern       
        for (int i = 0; i < patternSize; i++) {
            //panel.setTheTA("\t");
            for (int j = 0; j < patternSize; j++) {
                if (this.getList().get(i).charAt(j) == '*') {
                    returnMe[i][j] = 1;

                }
                //panel.setTheTA("" + detectors[i][j]);
                //System.out.print(detectors[i][j]);
            }
            //panel.setTheTA("\n");
            //System.out.println("\n");
        }
        // panel.setTheTA("\n\n\n")
        
        matrix = returnMe;
        

    }

    void initDetectorsFromDrawingPad() {
        
        
        int[][] returnMe = panel.getDrawingGrid();
        
        
        
        matrix = returnMe;
    }

    int[][] initDetectors() { 
        return matrix;
    }

    private void initList() {
        for(int row = 0; row < x; row ++){
            String ret = "";
            for (int col = 0; col < x ; col++){
                ret += matrix[row][col];
            }
            list.add(ret);
        }
    }


}
