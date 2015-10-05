/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

//import backup.GraphAStar;
//import backup.AStar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://codereview.stackexchange.com/questions/38376/a-search-algorithm
 * http://www.codeproject.com/Articles/9880/Very-simple-A-algorithm-implementation
 */
public class Main {
    public static void main(String[] args) {
//        Map<String, Map<String, Double>> hueristic = new HashMap<>();
//        // map for A    
//        Map<String, Double> mapA = new HashMap<>();
//        mapA.put("A",  0.0);
//        mapA.put("B", 10.0);
//        mapA.put("C", 20.0);
//        mapA.put("E", 100.0);
//        mapA.put("F", 110.0);
//
//
//        // map for B
//        Map<String, Double> mapB = new HashMap<>();
//        mapB.put("A", 10.0);
//        mapB.put("B",  0.0);
//        mapB.put("C", 10.0);
//        mapB.put("E", 25.0);
//        mapB.put("F", 40.0);
//
//
//        // map for C
//        Map<String, Double> mapC = new HashMap<>();
//        mapC.put("A", 20.0);
//        mapC.put("B", 10.0);
//        mapC.put("C",  0.0);
//        mapC.put("E", 10.0);
//        mapC.put("F", 30.0);
//
//
//        // map for X
//        Map<String, Double> mapX = new HashMap<>();
//        mapX.put("A", 100.0);
//        mapX.put("B", 25.0);
//        mapX.put("C", 10.0);
//        mapX.put("E",  0.0);
//        mapX.put("F", 10.0);
//
//        // map for X
//        Map<String, Double> mapZ = new HashMap<>();
//        mapZ.put("A", 110.0);
//        mapZ.put("B",  40.0);
//        mapZ.put("C",  30.0);
//        mapZ.put("E", 10.0);
//        mapZ.put("F",  0.0);
//
//        hueristic.put("A", mapA);
//        hueristic.put("B", mapB);
//        hueristic.put("C", mapC);
//        hueristic.put("E", mapX);
//        hueristic.put("F", mapZ);
//
//        GraphAStar<String> graph = new GraphAStar<>(hueristic);
//        graph.addNode("A");
//        graph.addNode("B");
//        graph.addNode("C");
//        graph.addNode("E");
//        graph.addNode("F");
//
//        graph.addEdge("A", "B",  10);
//        graph.addEdge("A", "E", 100);
//        graph.addEdge("B", "C", 10);
//        graph.addEdge("C", "E", 10);
//        graph.addEdge("C", "F", 30);
//        graph.addEdge("E", "F", 10);
//
//        AStar<String> aStar = new AStar<>(graph);
//
//        for (String path : aStar.astar("A", "F")) {
//            System.out.println(path);
//        }
        
        List<List<String>> so = new ArrayList<>();
        List<List<String>> de = new ArrayList<>();
        List<List<String>> so1 = new ArrayList<>();
        
        List<String> s1 = new ArrayList<>(Arrays.asList("*", "*", "*", "0"));
        List<String> s2 = new ArrayList<>(Arrays.asList("1", "1", "1", "1"));
        List<String> s3 = new ArrayList<>(Arrays.asList("2", "2", "2", "2"));
        List<String> s4 = new ArrayList<>(Arrays.asList("3", "3", "3", "3"));
        List<String> s5 = new ArrayList<>(Arrays.asList("4", "4", "4", "4"));
        
        so.add(s1);
        so.add(s2);
        so.add(s3);
        so.add(s4);
        so.add(s5);
        
        List<String> s11 = new ArrayList<>(Arrays.asList("*", "2", "*", "*"));
        List<String> s12 = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        List<String> s13 = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        List<String> s14 = new ArrayList<>(Arrays.asList("3", "4", "1", "4"));
        List<String> s15 = new ArrayList<>(Arrays.asList("0", "1", "2", "3"));
        
        so1.add(s11);
        so1.add(s12);
        so1.add(s13);
        so1.add(s14);
        so1.add(s15);
        
        List<String> r1 = new ArrayList<>(Arrays.asList("*", "*", "*", "0"));
        List<String> r2 = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        List<String> r3 = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        List<String> r4 = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        List<String> r5 = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        
        de.add(r1);
        de.add(r2);
        de.add(r3);
        de.add(r4);
        de.add(r5);
        
        //System.out.println(Heuristic.calcH(so, de, 1));
        System.out.println(1.0/19); 
        
//        NodeData n = new NodeData(new BabMatrix(so), null, 1);
//        n.calcF(new BabMatrix(de));
//        System.out.println(n.getF()); 
//        
//        NodeData n2 = new NodeData(new BabMatrix(so1), null, 1);
//        n2.calcF(new BabMatrix(de));
//        System.out.println(n2.getF()); 
        
//        System.out.println("esta es la parte");
//        new BabMatrix(so1).generateStates();
//        new BabMatrix(de).getFreePosition();
//        new BabMatrix(so).generateStates();
        
        // test ***************************************************************
        BabMatrix bo = new BabMatrix(so);
        BabMatrix bo2 = new BabMatrix(so1);
        BabMatrix bd = new BabMatrix(de);
        
//        Map<BabMatrix, Map<BabMatrix, Double>> h2 = new HashMap<>();
//        // map for b0    
//        Map<BabMatrix, Double> mapA1 = new HashMap<>();
//        mapA1.put(bo,   0.0);
//        mapA1.put(bo2,  0.25);
//        mapA1.put(bd,   1.0);
//
//        // map for bd
//        Map<BabMatrix, Double> mapB1 = new HashMap<>();
//        mapB1.put(bo,   1.0);
//        mapB1.put(bo2,  0.25);
//        mapB1.put(bd,   0.0);
//        
//        // map for Bo2
//        Map<BabMatrix, Double> mapC1 = new HashMap<>();
//        mapC1.put(bo,  0.25);
//        mapC1.put(bo2, 0.0);
//        mapC1.put(bd,  0.25);
//        
//        h2.put(bo, mapA1);
//        h2.put(bd, mapB1);
//        h2.put(bo2, mapC1);
//
//        GraphAStar graph1 = new GraphAStar(bd);
//        graph1.addNode(bo);
//        graph1.addNode(bd);
//        //graph1.addNode(bo2);
//
//        graph1.addEdge(bo, bd,  1.0);
//        //graph1.addEdge(bo, bo2,  0.25);
//        //graph1.addEdge(bo2, bd,  0.25);
//
        AStar aStar1 = new AStar();

        List<BabMatrix> paths = aStar1.astar(bo, bd);
        System.out.println(paths.size());
        for (BabMatrix path : paths) {
            //System.out.println(path);
            path.print();
            System.out.println();
        }
        
//        System.out.println("esta es la parte");
//        List<BabMatrix> states = (new BabMatrix(so)).generateStates();
//        for (BabMatrix path : states) {
//            //System.out.println(path);
//            path.print();
//        }
    }
}
