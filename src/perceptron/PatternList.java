package perceptron;

import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class PatternList extends ArrayList<Pattern> {

    ArrayList<Integer> traininglist = new ArrayList<>();

    public ArrayList<Integer> getTraininglist() {
        return traininglist;
    }

    public void setTraininglist(ArrayList<Integer> traininglist) {
        this.traininglist = traininglist;
    }

    void addPattern(Pattern p) {
        this.add(p);
        StringList list = p.getList();

        String lastString = list.get(list.size() - 1);
        //System.out.println("lastString = " + lastString);

        if (lastString.equals("yes")) {
            traininglist.add(1); //1 for true
        } else {
            traininglist.add(0); //0 for false
        }

    }
}
