package test;

import java.util.ArrayList;
import java.util.List;

final public class NodeData { 

    private final BabMatrix nodeId;
    private NodeData nodeParent;

    private double g;  // g is distance from the source
    private double h;  // h is the heuristic of destination.
    private double f;  // f = g + h 
    
    public NodeData(BabMatrix nodeId){
        this.nodeId = nodeId;
    }
    
    public NodeData (BabMatrix nodeId, NodeData nodeParent, double distance) {
        this.nodeId = nodeId;
        this.nodeParent = nodeParent;
        if(nodeParent != null)
            this.g = nodeParent.getG() + distance;
        else
            this.g = distance;
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
        Heuristic heuristic = new Heuristic();
        this.h = heuristic.calcH((BabMatrix) nodeId, (BabMatrix) nodeDest);
        this.f = this.g + this.h;
    }

    public double getH() {
        return h;
    }

    public double getF() {
        return f;
    }
    
    public List<BabMatrix> generateStates(){
        List<BabMatrix> result = new ArrayList<>();
        BabMatrix test = this.getNodeId();
        BabMatrix temp;
        int[] blackPosition = findBlank();

        temp = moveUp(test, blackPosition[0], blackPosition[1]);
        if(temp != null){
            result.add(temp);
        }

        temp = moveDown(test, blackPosition[0], blackPosition[1]);
        if(temp != null){
            result.add(temp);
        }

        for(int i=0; i<test.getRows(); i++){
            result.add(shiftLeft(test, i));
            result.add(shiftRight(test, i));
        }
        
        return result;
    }
    
    private int[] findBlank(){
        int[] result = new int[2];
        for(int i=0; i<this.nodeId.getRows(); i++){
            for(int j=0; j<this.nodeId.getColumns(); j++){
                if(this.nodeId.get(i, j).equals("0")){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
    
    private BabMatrix shiftLeft(BabMatrix matrix, int i){
        BabMatrix result = new BabMatrix();
        result.setMatrix(matrix.cloneMatrix());
        
        for(int j=0; j<matrix.getColumns()-1; j++){
            if(j == (matrix.getColumns()-1)){
                result.swap(i, j, i, 0);
                continue;
            }
            result.swap(i, j, i, j+1);
        }
        
        return result;
    }
    
    private BabMatrix shiftRight(BabMatrix matrix, int i){
        BabMatrix result = new BabMatrix();
        result.setMatrix(matrix.cloneMatrix());
        
        for(int j=matrix.getColumns()-1; j>0; j--){
            if(j == 0){
                result.swap(i, j, i, (matrix.getColumns()-1));
                continue;
            }
            result.swap(i, j, i, j-1);
        }
        
        return result;
    }
    
    private BabMatrix moveUp(BabMatrix matrix, int i, int j){
        BabMatrix result = new BabMatrix();
        result.setMatrix(matrix.cloneMatrix());
        
        if(i == result.getRows()-1){
            return null;
        }
        
        result.swap(i, j, i+1, j);
        
        return result;
    }
    
    private BabMatrix moveDown(BabMatrix matrix, int i, int j){
        BabMatrix result = new BabMatrix();
        result.setMatrix(matrix.cloneMatrix());
        
        if(i == 0){
            return null;
        }
        
        result.swap(i, j, i-1, j);
        
        return result;
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
