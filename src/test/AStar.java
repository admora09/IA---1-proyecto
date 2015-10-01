/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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

/**
 *
 * @author adonis
 */
public class AStar {
    private final GraphAStar graph;


    public AStar (GraphAStar graphAStar) {
        this.graph = graphAStar;
    }

    // extend comparator.
    public class NodeComparator implements Comparator<NodeData> {
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
    public List<List<List<String>>> astar(List<List<String>> source, List<List<String>> destination) {
        /**
         * http://stackoverflow.com/questions/20344041/why-does-priority-queue-has-default-initial-capacity-of-11
         */
        final Queue<NodeData> openQueue = new PriorityQueue<NodeData>(11, new NodeComparator()); 

        NodeData sourceNodeData = graph.getNodeData(source);
        sourceNodeData.setG(0);
        sourceNodeData.calcF(destination);
        openQueue.add(sourceNodeData);

        final Map<List<List<String>>, List<List<String>>> path = new HashMap<List<List<String>>, List<List<String>>>();
        final Set<NodeData> closedList = new HashSet<NodeData>();

        while (!openQueue.isEmpty()) {
            final NodeData nodeData = openQueue.poll();

            if (nodeData.getNodeId().equals(destination)) { 
                return path(path, destination);
            }

            closedList.add(nodeData);

            for (Map.Entry<NodeData, Double> neighborEntry : graph.edgesFrom(nodeData.getNodeId()).entrySet()) {
                NodeData neighbor = neighborEntry.getKey();

                if (closedList.contains(neighbor)) continue;

                double distanceBetweenTwoNodes = neighborEntry.getValue();
                double tentativeG = distanceBetweenTwoNodes + nodeData.getG();

                if (tentativeG < neighbor.getG()) {
                    neighbor.setG(tentativeG);
                    neighbor.calcF(destination);

                    path.put(neighbor.getNodeId(), nodeData.getNodeId());
                    if (!openQueue.contains(neighbor)) {
                        openQueue.add(neighbor);
                    }
                }
            }
        }

        return null;
    }


    private List<List<List<String>>> path(Map<List<List<String>>, List<List<String>>> path, List<List<String>> destination) {
        assert path != null;
        assert destination != null;

        final List<List<List<String>>> pathList = new ArrayList<>();
        pathList.add(destination);
        while (path.containsKey(destination)) {
            destination = path.get(destination);
            pathList.add(destination);
        }
        Collections.reverse(pathList);
        return pathList;
    }
}
