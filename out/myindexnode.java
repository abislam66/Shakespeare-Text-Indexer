package index;

import java.util.ArrayList;
import java.util.List;

public class myindexnode{
    String word;
    int occurences;
    List<Integer> lineNumbers;
    myindexnode left;
    myindexnode right;

    public myindexnode(String word, int linenumber){
        this.word = word;
        this.occurences = 1;
        this.lineNumbers = new ArrayList<Integer>();
        this.lineNumbers.add(linenumber);3
        this.left = null;
        this.right = null;
    }
    public void addLine(int linenumber){
        if(!lineNumbers.contains(linenumber)){
            lineNumbers.add(linenumber);
        }
        occurences++;
    }
    public String toString(){
        return word + "[ count: " + occurences + ",lines: ["+ lineNumbers.toString()+"] ]";
    }
}
