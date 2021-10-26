import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class AlienDictionary {

  static class Graph {
    LinkedList<Integer>[] edges;

    public Graph(int numNodes) {
      edges = new LinkedList[numNodes];
      for (int i = 0; i < numNodes; i++) {
        edges[i] = new LinkedList<>();
      }
    }

//    void addEdge(int startVertex, int endVertex){
//      edges
//    }
  }

  public static void main(String[] args) {
    String[] words = {"baa", "abcd", "abca", "cab", "cad"};
    AlienDictionary ad = new AlienDictionary();
    System.out.println(ad.getOrder(words));
  }

  HashSet<Integer>[] constructGraph(HashSet<Integer>[] graph, String[] words, HashMap<Character, Integer> hmapReverse) {

    for (int i = 1; i < words.length; i++) {
      String firstWord = words[i - 1];
      String secondWord = words[i];

      int j = 0;

      while (j < firstWord.length() && j < secondWord.length()) {
        if (firstWord.charAt(j) != secondWord.charAt(j)) {
          int start = hmapReverse.get(firstWord.charAt(j));
          int end = hmapReverse.get(secondWord.charAt(j));
          graph[start].add(end);
        }
        j++;
      }
    }


    return graph;
  }

  String getOrder(String[] words) {
    HashMap<Integer, Character> hmap = new HashMap<>();
    HashMap<Character, Integer> hmapReverse = new HashMap<>();
    HashSet<Character> hset = new HashSet<>();
    int counter = 0;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      for (int j = 0; j < word.length(); j++) {
        if (!hset.contains(word.charAt(j))) {
          hmap.put(counter, word.charAt(j));
          hmapReverse.put(word.charAt(j), counter);
          hset.add(word.charAt(j));
          counter++;
        }
      }
    }

    HashSet<Integer>[] graph = new HashSet[counter];
    for (int i = 0; i < counter; i++) {
      graph[i] = new HashSet<>();
    }

    //System.out.println("graph size: "+graph.length);

    graph = constructGraph(graph, words, hmapReverse);

    //System.out.println("graph size: "+graph.length);

    LinkedList<Integer> stack = new LinkedList<>();

    stack = topologicalSort(stack, graph);

    String res = "";

    while (!stack.isEmpty()) {
      int node = stack.removeFirst();
      Character cc = hmap.get(node);
      res += cc;
    }

    return res;
  }

  LinkedList<Integer> topologicalSort(LinkedList<Integer> stack, HashSet<Integer>[] graph) {

    int numNodes = graph.length;
    boolean[] visited = new boolean[numNodes];

    for (int i = 0; i < numNodes; i++) {
      if (!visited[i]) {
        topologicalSortUtil(stack, graph, visited, i);
      }
    }
    return stack;
  }

  void topologicalSortUtil(LinkedList<Integer> stack, HashSet<Integer>[] graph, boolean[] visited, int vertex) {

    visited[vertex] = true;

    for (Integer v : graph[vertex]) {
      if (!visited[v]) {
        topologicalSortUtil(stack, graph, visited, v);
      }
    }

    stack.addFirst(vertex);
  }
}
