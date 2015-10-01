/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adonis
 */
final public class Heuristic {
    
    final static int maxI = 5;
    final static int maxJ = 4;
    final static int pieces = 19;

    public static double calcH(List<List<String>> source, List<List<String>> destination) {
        double diff = 0;
        
        for(int i = 0; i<maxI; i++){
            for(int j = 0; j<maxJ; j++){
                if(!source.get(i).get(j).equals(destination.get(i).get(j)))
                    diff++;
            }
        }
        
        if(diff != 0) diff--;
        
        return (diff / pieces);
    }
}
