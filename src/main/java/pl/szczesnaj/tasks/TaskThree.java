package pl.szczesnaj.tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.*;

class TaskThree {
    private Set<Edge> usedEdges;
    private List<Edge> allEdges;

    List<Edge> getEdgesFromFile(String path) {
        try (Stream<String> fileStream = Files.lines(Paths.get(path))) {
            return fileStream
                    .skip(1)
                    .map(s -> Arrays.stream(s.split("\\s+", 2))
                            .map(Integer::parseInt)
                            .toList())
                    .map(list -> new Edge(list.get(0), list.get(1)))
                    .collect(toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TaskThree task = new TaskThree();
        String path = "xs_2graphs.txt";
//        String path = "m_3graphs.txt";
//        String path = "l_graphs.txt";

        List<Edge> edgeList = task.getEdgesFromFile(path);

        List<Graph> graphs = task.getGraphs(edgeList);

        System.out.println(graphs.size());

// po za konkursem
//        Set<Integer> vertices = edgeList.stream()
//                .flatMap(e -> List.of(e.x, e.y).stream())
//                .collect(toSet());
//
//        Map<Integer, Set<Edge>> graph2 = vertices.stream()
//                .collect(toMap(vertex -> vertex, vertex ->
//                        edgeList.stream()
//                                .filter(edge ->
//                                        edge.y.equals(vertex) || edge.x.equals(vertex))
//                                .collect(toSet())
//                ));

    }

    List<Graph> getGraphs(List<Edge> edges) {
        this.usedEdges = new HashSet<>();
        this.allEdges = edges;

        return edges.stream()
                .filter(not(this::wasUsed))
                .map(this::scanToGraph)
                .collect(toList());
    }

    private Graph scanToGraph(Edge edge) {
        return new Graph(scan(edge).toList());
    }

    private Stream<Edge> scan(Edge edge) {
        markUsed(edge);

        Set<Edge> searchedEdges = getEdgesConnectedWihVertices(edge).collect(toSet());
        searchedEdges.forEach(this::markUsed);

        return Stream.concat(Stream.of(edge), searchedEdges.stream()
                .flatMap(this::scan));
    }

    private Stream<Edge> getEdgesConnectedWihVertices(Edge edge) {
        Stream<Edge> edgesFirst = allEdgesWhichContainsNum(edge.x);
        Stream<Edge> edgesSecond = allEdgesWhichContainsNum(edge.y);

        return Stream.concat(edgesFirst, edgesSecond);
    }

    private Stream<Edge> allEdgesWhichContainsNum(Integer number) {
        return this.allEdges.stream()
                .filter(not(this::wasUsed))
                .filter(edge -> edge.x.equals(number) || edge.y.equals(number));
    }

    private void markUsed(Edge edge) {
        this.usedEdges.add(edge);
    }

    private boolean wasUsed(Edge edge) {
        return usedEdges.contains(edge);
    }

    class Edge {
        Integer x;
        Integer y;

        Edge(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge edge)) return false;
            return x.equals(edge.x) && y.equals(edge.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "[" +
                    "x=" + x +
                    ", y=" + y +
                    ']';
        }
    }

    class Graph {
        private Set<Edge> edges;

        Graph(List<Edge> edges) {
            this.edges = new HashSet<>();
            this.edges.addAll(edges);
        }

        @Override
        public String toString() {
            return "Graph{ " +
                    "edges=" + edges +
                    '}';
        }
    }
}
