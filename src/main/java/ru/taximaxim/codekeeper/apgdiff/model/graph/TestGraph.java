package ru.taximaxim.codekeeper.apgdiff.model.graph;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

public class TestGraph {

    public DirectedGraph<String, DefaultEdge> graph;
    
    {
        graph = new SimpleDirectedGraph<>(DefaultEdge.class);
        
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        
        graph.addEdge("2", "1");
        graph.addEdge("3", "1");
        
        for(DefaultEdge e : graph.incomingEdgesOf("1")) {
            System.out.println(graph.getEdgeSource(e));
        }
    }
    
}
