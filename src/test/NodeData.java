/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

final public class NodeData { 

    private final List<List<String>> nodeId;
    private final NodeData nodeParent;
    private final Map<List<List<String>>, Double> heuristic;

    private double g;  // g is distance from the source
    private double h;  // h is the heuristic of destination.
    private double f;  // f = g + h 
    
    public NodeData (List<List<String>> nodeId, NodeData nodeParent, double distance) {
        this.nodeId = nodeId;
        this.nodeParent = nodeParent;
        this.g = distance;
        
        this.heuristic = new HashMap<>();
    }
    
    public NodeData (List<List<String>> nodeId, Map<List<List<String>>, Double> heuristic) {
        this.nodeId = nodeId;
        this.g = Double.MAX_VALUE; 
        this.heuristic = heuristic;
        
        this.nodeParent = null;
    }

    public List<List<String>> getNodeId() {
        return nodeId;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }
    
    public void calcF(List<List<String>> nodeDest){
        this.h = Heuristic.calcH((List<List<String>>) nodeId, (List<List<String>>) nodeDest);
        this.f = this.h + this.g;
    }

    public double getH() {
        return h;
    }

    public double getF() {
        return f;
    }
 }
