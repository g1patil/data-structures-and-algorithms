package graph;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author g1patil
 * WIP : TODO
 */
public class DeleteDuplicateFoldersSystem {

    Map<String , List<String>> graph = new HashMap<>();
    Set<String> visited = new HashSet<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        buildGraph(paths);
        dfs(graph , "/");
        return null;
    }

    private boolean dfs(Map<String, List<String>> graph , String node) {
        if (visited.contains(node))
            return true;

        visited.add(node);
        List<String> child = graph.get(node);
        if (child == null)
            return false;

        for (String _node : child){
            if (dfs(graph , _node)){
                if (isSubTreeVisited(_node)){
                    System.out.println(_node + " was visited . parent is " + node);
                    //then find the previous node and delete its parent
                    //delete the parent
                }
            }
        }

        return false;

    }

    private boolean isSubTreeVisited(String _node){
        for (String _current : graph.get(_node)){
            if (!visited.contains(_current))
                return false;
        }

        return true;
    }

    private void buildGraph(List<List<String>> paths) {
        for (List<String> path : paths) {
            if (path.size() == 1){
                graph.putIfAbsent("/" , new ArrayList<>());
                graph.get("/").add(path.get(0));
            } else {
                graph.put(path.get(0), new ArrayList<>());
                graph.get(path.get(0)).add(path.get(1));
            }
        }

        System.out.println(graph);
    }

    @Test
    public void test_(){
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        List<String> l3 = new ArrayList<>();

        l1.add("a");
        l2.add("d");
        l3.add("c");

        List<String> l11 = new ArrayList<>();
        List<String> l22 = new ArrayList<>();
        List<String> l33 = new ArrayList<>();

        l11.add("a");
        l11.add("b");

        l22.add("c");
        l22.add("b");

        l33.add("d");
        l33.add("a");

        List<List<String>> mainList = new ArrayList<>();
        mainList.add(l1);
        mainList.add(l2);
        mainList.add(l3);
        mainList.add(l11);
        mainList.add(l22);
        mainList.add(l33);

        deleteDuplicateFolder(mainList);
    }
}
