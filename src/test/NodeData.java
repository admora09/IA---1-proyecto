/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;
import java.util.Map;

final public class NodeData { 

    private final BabMatrix nodeId;
    private NodeData nodeParent;
    private final Map<BabMatrix, Double> heuristic;

    private double g;  // g is distance from the source
    private double h;  // h is the heuristic of destination.
    private double f;  // f = g + h 
    
    public NodeData (BabMatrix nodeId, NodeData nodeParent, double distance) {
        this.nodeId = nodeId;
        this.nodeParent = nodeParent;
        this.g = distance;
        
        this.heuristic = new HashMap<>();
    }
    
    public NodeData (BabMatrix nodeId, Map<BabMatrix, Double> heuristic) {
        this.nodeId = nodeId;
        this.g = Double.MAX_VALUE; 
        this.heuristic = heuristic;
        
        this.nodeParent = null;
    }

    public BabMatrix getNodeId() {
        return nodeId;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }
    
    public void calcF(BabMatrix nodeDest){
        Heuristic h = new Heuristic();
        this.h = h.calcH((BabMatrix) nodeId, (BabMatrix) nodeDest);
        this.f = this.h + this.g;
    }

    public double getH() {
        return h;
    }

    public double getF() {
        return f;
    }

    /**
     * @return the nodeParent
     */
    public NodeData getNodeParent() {
        return nodeParent;
    }

    /**
     * @param nodeParent the nodeParent to set
     */
    public void setNodeParent(NodeData nodeParent) {
        this.nodeParent = nodeParent;
    }
 }
