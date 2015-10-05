package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class AStar {

    public AStar () {
    }

    // extend comparator.
    public class NodeComparator implements Comparator<NodeData> {
        @Override
        public int compare(NodeData nodeFirst, NodeData nodeSecond) {
            if (nodeFirst.getF() > nodeSecond.getF()) return 1;
            if (nodeSecond.getF() > nodeFirst.getF()) return -1;
            return 0;
        }
    } 
    
    private void printQueue(NodeData[] list){
        System.out.println("-----------");
        for(int i=0; i<list.length; i++){
            System.out.println("F(): " + list[i].getF());
        }
        System.out.println("-----------");
    }

    /**
     * Implements the A-star algorithm and returns the path from source to destination
     * 
     * @param source        the source nodeid
     * @param destination   the destination nodeid
     * @return              the path from source to destination
     */
    public List<BabMatrix> astar(BabMatrix source, BabMatrix destination) {
        /**
         * http://stackoverflow.com/questions/20344041/why-does-priority-queue-has-default-initial-capacity-of-11
         */
        final Queue<NodeData> openQueue = new PriorityQueue<>(11, new NodeComparator()); 

        NodeData sourceNodeData = new NodeData(source, null, 0);//graph.getNodeData(source);
        sourceNodeData.setG(0);
        sourceNodeData.calcF(destination);
        openQueue.add(sourceNodeData);

        //final Map<BabMatrix, BabMatrix> path = new HashMap<>();
        final Set<BabMatrix> closedList = new HashSet<>();

        while (!openQueue.isEmpty()) {
//            printQueue(openQueue.toArray(new NodeData[openQueue.size()]));
//            System.out.println("closed: " + closedList.size());
//            System.out.println("opened: " + openQueue.size() + "\nactual F(): " + openQueue.peek().getF());
            
            final NodeData nodeData = openQueue.poll();
            
//            nodeData.getNodeId().print();
            
            if (compare(nodeData.getNodeId(), (destination))) { 
                return path(nodeData);
            }

            closedList.add(nodeData.getNodeId());
            //nodeData.getNodeId().print();

            for (BabMatrix neighborEntry : nodeData.generateStates()){//graph.edgesFrom(nodeData.getNodeId()).entrySet()) {
                List<BabMatrix> clList = new ArrayList<>(closedList);
                if (contains(clList, neighborEntry)) continue;
                
                double tentativeG = nodeData.getG() + (1.0/20);
                boolean gScoreIsBest = false;
                
                NodeData neighbor = find(openQueue.toArray(new NodeData[openQueue.size()]), neighborEntry);
                
                if(neighbor == null){
                    gScoreIsBest = true;
                    neighbor = new NodeData(neighborEntry);
                    
                }
                else if(tentativeG < neighbor.getG()) {
//                    System.out.println(tentativeG + " < " + neighbor.getG());
                    gScoreIsBest = true;
                }
                
//                neighbor.getNodeId().print();
                
                if(gScoreIsBest) {
                    neighbor.setNodeParent(nodeData);
                    neighbor.setG(tentativeG);
                    neighbor.calcF(destination);
                    openQueue.add(neighbor);
//                    System.out.println("added");
                    
                    Heuristic heuristic = new Heuristic();
//                    System.out.println("H(): " + heuristic.calcH(neighborEntry, destination));
//                    System.out.println("G(): " + neighbor.getG());
//                    System.out.println("F(): " + neighbor.getF());
                }
                
                
                
                //neighbor.getNodeId().print();
                //if (closedList.contains(neighbor.getNodeId())) continue;

                
               
                //System.out.println(nodeData.getG());
//                System.out.println(tentativeG + " < " + neighbor.getG());
//                neighbor.getNodeId().print();
                
//                if (tentativeG < neighbor.getG()) {
//                    neighbor.setG(tentativeG);
//                    neighbor.calcF(destination);
//
//                    //path.put(neighbor.getNodeId(), nodeData.getNodeId());
//                    List<BabMatrix> opList = getMatrixList(openQueue.toArray(new NodeData[openQueue.size()]));
//                    //if (!openQueue.contains(neighbor)) {
//                    if (!contains(opList, neighborEntry)) {
//                        openQueue.add(neighbor);
//                       // neighbor.getNodeId().print();
//                    }
//                }
            }
        }

        return new ArrayList<>();
    }
    
    private boolean compare(BabMatrix source, BabMatrix destination){
        for(int i=0; i<source.getRows(); i++){
            for(int j=0; j<source.getColumns(); j++){
                if(!source.get(i, j).equals(destination.get(i, j))){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean contains(List<BabMatrix> matrixs, BabMatrix matrix){
        for(int i=0; i<matrixs.size(); i++){
            if(compare(matrix, matrixs.get(i))){
                return true;
            }
        }
        
        return false;
    }
    
    private NodeData find(NodeData[] openList, BabMatrix matrix){
        for(int i=0; i<openList.length; i++){
            if(compare(matrix, openList[i].getNodeId())){
                return openList[i];
            }
        }
        return null;
    }
    
    private List<BabMatrix> getMatrixList(NodeData[] list){
        List<BabMatrix> result = new ArrayList<>();
        
        for(int i=0; i<list.length; i++){
            result.add(list[i].getNodeId());
        }
        return result;
    }

    private List<BabMatrix> path(Map<BabMatrix, BabMatrix> path, BabMatrix destination) {
        assert path != null;
        assert destination != null;

        final List<BabMatrix> pathList = new ArrayList<>();
        pathList.add(destination);
        while (path.containsKey(destination)) {
            destination = path.get(destination);
            pathList.add(destination);
        }
        Collections.reverse(pathList);
        return pathList;
    }
    
    private List<BabMatrix> path( NodeData nodeData ){
        final List<BabMatrix> pathList = new ArrayList<>();
        NodeData temp = nodeData;
        
        pathList.add(temp.getNodeId());
        while(true){
            temp = temp.getNodeParent();
            if(temp == null)
                break;
            pathList.add(temp.getNodeId());
        }
        
        Collections.reverse(pathList);
        return pathList;
    }
}
