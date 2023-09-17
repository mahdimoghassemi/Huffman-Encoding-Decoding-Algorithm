package ir.ac.kntu;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Node implements Comparable<Node>{
    public int count;
    public char word;

    Node left, right;

    public Node(char subject) {
        this.word = subject;
        this.count = 1;
        left = right = null;
    }

    public Node(int count, Node left, Node right) {
        this.word = 0;
        this.count = count;
        this.left = left;
        this.right = right;
    }

    //==== for print ====

    public String toString() {
        return word + ": " + count;
    }

    //=== count each word ===

    public static PriorityQueue<Node> count(String target) {
        LinkedList<Node> result = new LinkedList<>();
        for (int i = 0; i < target.length(); i++) {
            boolean flag = false;
            for (Node candidate : result) {
                if (target.charAt(i) == candidate.word) {
                    candidate.count++;
                    flag = true;
                }
            }
            if (!flag) {
                result.add(new Node(target.charAt(i)));
            }
        }
        return new PriorityQueue<Node>(result);
    }

    @Override
    public int compareTo(Node other) {
//        return other.count-count; // max
        return count-other.count; // min
    }
}
