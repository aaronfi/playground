package CodingKata;

import java.util.*;

public class WordLadder
{
    public static class Node {
        public String word;

        public SortedMap<String, Node> neighbors;

        public Node(String word) {
            this.word = word;
            this.neighbors = new TreeMap<String, Node>();
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(this.word);
            builder.append(":[");

            for(String neighbor : neighbors.keySet()) {
                builder.append(neighbor);
                builder.append(",");
            }
            builder.deleteCharAt(builder.length()-1);
            builder.append("]");

            return builder.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (!word.equals(node.word)) {
                return false;
            }

            if (neighbors == null && node.neighbors == null) {
                return true;
            } else if (neighbors != null && node.neighbors != null) {
                return neighbors.toString().equals(node.neighbors.toString());  // TODO(aaron,7.8.14) very wrong, don't rely on toString() here.
            } else {
                return false;
            }
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

    public Node[] GenerateGraph(String startingWord) {
        SortedMap<String, Node> nodes = new TreeMap<String, Node>();

        Set<String> visited = new HashSet<String>();
        Queue<String> working = new LinkedList<String>();

        working.add(startingWord);

        while (!working.isEmpty()) {
            String currentWord = working.remove();

            visited.add(currentWord);

            Node currentNode = new Node(currentWord);
            nodes.put(currentWord, currentNode);

            for(String neighbor : GenerateNeighbors(currentWord)) {

                if (visited.contains(neighbor)) {  // then create two edges between the two nodes
                    Node neighborNode = nodes.get(neighbor);

                    neighborNode.neighbors.put(currentWord, currentNode);
                    currentNode.neighbors.put(neighbor, neighborNode);
                } else {
                    working.add(neighbor);
                }
            }
        }

        Node[] values = new Node[nodes.size()];
        int index = 0;
        for (Map.Entry<String, Node> entry : nodes.entrySet()) {
            values[index++] = entry.getValue();
        }

        return values;
    }

    public List<String> GenerateNeighbors(String word) {
        List<String> results = new ArrayList<String>();

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
                    results.add(newWord);
                }
            }
        }

        return results;
    }
}
