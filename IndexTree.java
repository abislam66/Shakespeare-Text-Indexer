package index;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * IndexTree class
 * Builds an alphabetical index of all unique words from a text file.
 * Each node stores the word, number of occurrences, and line numbers where it appears.
 */
public class IndexTree {

    private IndexNode root;

    public IndexTree() {
        root = null;
    }

    public void add(String word, int lineNumber) {
        root = add(root, word, lineNumber);
    }

    private IndexNode add(IndexNode node, String word, int lineNumber) {
        if (node == null) {
            return new IndexNode(word, lineNumber);
        }

        int cmp = word.compareTo(node.word);
        if (cmp == 0) {
            node.addLine(lineNumber);
        } else if (cmp < 0) {
            node.left = add(node.left, word, lineNumber);
        } else {
            node.right = add(node.right, word, lineNumber);
        }
        return node;
    }

    public IndexNode search(String word) {
        return search(root, word);
    }

    private IndexNode search(IndexNode node, String word) {
        if (node == null) return null;
        int cmp = word.compareTo(node.word);
        if (cmp == 0) return node;
        else if (cmp < 0) return search(node.left, word);
        else return search(node.right, word);
    }

    public void printIndex() {
        printIndex(root);
    }

    private void printIndex(IndexNode node) {
        if (node == null) return;
        printIndex(node.left);
        System.out.println(node);
        printIndex(node.right);
    }

    public static void main(String[] args) {
        IndexTree tree = new IndexTree();
        File file = new File("shakespeare.txt");

        try (Scanner scanner = new Scanner(file)) {
            int lineNumber = 0;

            // Build the tree
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();
                String[] words = line.split(" "); // split by spaces only

                for (String word : words) {
                    // remove everything except letters and apostrophes
                    word = word.replaceAll("[^a-zA-Z']", "").toLowerCase();

                    if (word.isEmpty()) continue; // skip blanks
                    tree.add(word, lineNumber);
                }
            } //  close while loop here

            System.out.println("\n FULL INDEX TREE (Alphabetical Order):\n");
            tree.printIndex();  // print full index before search

            // Let user search after printing
            Scanner input = new Scanner(System.in);
            String searchWord = "";

            System.out.println("\n Now type a word to search or 'q' to quit:");

            while (true) {
                searchWord = input.nextLine().trim().toLowerCase();

                if (searchWord.equals("q")) {
                    System.out.println(" Program ended. Goodbye!");
                    break;
                }

                if (searchWord.isEmpty()) continue;

                IndexNode result = tree.search(searchWord);
                if (result != null) {
                    System.out.println(" Found: " + result);
                } else {
                    System.out.println(" Word not found in text.");
                }
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: shakespeare.txt not found.");
        }
    }
}
