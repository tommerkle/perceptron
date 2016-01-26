package perceptron;

import perceptron.io.MyReader;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class Pattern {

    StringList list = new StringList();
    int yes;
    

    Pattern(String absolutepath) {
        MyReader mr = new MyReader(absolutepath);
        while (mr.hasMoreData()) {
            list.add(mr.giveMeTheNextLine());
        }
        mr.close();
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

}
