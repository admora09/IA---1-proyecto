/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

import java.util.Map;

/**
 * http://codereview.stackexchange.com/questions/38376/a-search-algorithm
 * http://www.codeproject.com/Articles/9880/Very-simple-A-algorithm-implementation
 */
final public class NodeData<T> { 

    private final T nodeId;
    private final Map<T, Double> heuristic;

    private double g;  // g is distance from the source
    private double h;  // h is the heuristic of destination.
    private double f;  // f = g + h 

    public NodeData (T nodeId, Map<T, Double> heuristic) {
        this.nodeId = nodeId;
        this.g = Double.MAX_VALUE; 
        this.heuristic = heuristic;
    }

    public T getNodeId() {
        return nodeId;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public void calcF(T destination) {
        this.h = heuristic.get(destination);
        this.f = g + h;
    } 

    public double getH() {
        return h;
    }

    public double getF() {
        return f;
    }
 }
