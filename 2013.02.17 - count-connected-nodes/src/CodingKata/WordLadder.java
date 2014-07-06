package CodingKata;

import java.util.*;

public class WordLadder
{
    public class Node {
        public String word;
        public Set<Node> neighbors;

        public Node(String word) {
            this.word = word;
            this.neighbors = new HashSet<Node>();
        }

        @Override
        public String toString() {
            return this.word;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (!word.equals(node.word)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return word.hashCode();
        }
    }

    private static Set<String> dictionary = new HashSet<String>(Arrays.asList("junk", "funk", "bunk", "sunk", "dunk", "bunt"));

    public static boolean isValidWord(String word) {
        return dictionary.contains(word);
    }

    public Set<Node> GenerateGraph(String startingWord) {
        Set<Node> nodes = new HashSet<Node>();
        Queue<Node> working = new LinkedList<Node>();

        Node start = new Node(startingWord);
        working.add(start);
        while (!working.isEmpty()) {
            Node next = working.remove();
            nodes.add(next);

            for(Node n : GenerateNeighbors(next)) {

                // create an between the two nodes
                n.neighbors.add(next);
                next.neighbors.add(n);

                if (!nodes.contains(n)) {
                    working.add(n);
                }
            }
        }

        return nodes;
    }

    public List<Node> GenerateNeighbors(Node node) {
        String word = node.word;
        List<Node> results = new ArrayList<Node>();

        for(int i=0; i<word.length(); i++) {
            char curr = word.charAt(i);
            for(char j = 'a'; j <= 'z'; j++) {
                if (j == curr) {
                    continue;
                }
                char[] temp = word.toCharArray();
                temp[i] = j;
                String newWord = String.valueOf(temp);
                if (isValidWord(newWord)) {
                    results.add(new Node(newWord));
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        Set<Node> graph = ladder.GenerateGraph("junk");

        System.out.println(graph);
    }
}
