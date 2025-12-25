package index;

import java.util.ArrayList;
import java.util.List;

/**
 * IndexNode class
 * Represents a single node in the IndexTree.
 * Stores the word, occurrence count, and line numbers.
 */
public class IndexNode {

    String word;
    int occurrences;
    List<Integer> lineNumbers;
    IndexNode left;
    IndexNode right;

    public IndexNode(String word, int lineNumber) {
        this.word = word;
        this.occurrences = 1;
        this.lineNumbers = new ArrayList<>();
        this.lineNumbers.add(lineNumber);
    }

    public void addLine(int lineNumber) {
        if (!lineNumbers.contains(lineNumber)) {
            lineNumbers.add(lineNumber);
        }
        occurrences++;
    }

    @Override
    public String toString() {
        return word + " [count: " + occurrences + ", lines: " + lineNumbers + "]";
    }
}
