package zzzz;

import test.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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

        final Map<BabMatrix, BabMatrix> path = new HashMap<>();
        final Set<NodeData> closedList = new HashSet<>();

        while (!openQueue.isEmpty()) {
            final NodeData nodeData = openQueue.poll();

            if (compare(nodeData.getNodeId(), (destination))) { 
                return path(nodeData);
            }

            closedList.add(nodeData);
            //nodeData.getNodeId().print();

            for (BabMatrix neighborEntry : nodeData.getNodeId().generateStates()){//graph.edgesFrom(nodeData.getNodeId()).entrySet()) {
                Heuristic h = new Heuristic();
                double distance = nodeData.getG() + 50;// + h.calcH(neighborEntry, nodeData.getNodeId());
                NodeData neighbor = new NodeData(neighborEntry, nodeData, distance);//neighborEntry.getKey();
                //neighbor.getNodeId().print();

                if (closedList.contains(neighbor)) continue;

                double distanceBetweenTwoNodes = h.calcH(neighborEntry, nodeData.getNodeId());
                double tentativeG = distanceBetweenTwoNodes + nodeData.getG();
               
                //System.out.println(nodeData.getG());
                //System.out.println(tentativeG + " < " + neighbor.getG());
                
                if (tentativeG < neighbor.getG()) {
                    neighbor.setG(tentativeG);
                    neighbor.calcF(destination);

                    path.put(neighbor.getNodeId(), nodeData.getNodeId());
                    //if (!openQueue.contains(neighbor)) {
                        openQueue.add(neighbor);
                       // neighbor.getNodeId().print();
                    //}
                }
            }
        }

        return null;
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
