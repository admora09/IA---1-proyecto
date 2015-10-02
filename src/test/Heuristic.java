package test;

public class Heuristic {
    
    final static int maxI = 5;
    final static int maxJ = 4;
    final static int pieces = 19;

    public static double calcH(BabMatrix source, BabMatrix destination) {
        double diff = 0;
        
        for(int i = 0; i<maxI; i++){
            for(int j = 0; j<maxJ; j++){
                if(!source.get(i, j).equals(destination.get(i, j)))
                    diff++;
            }
        }
        
        if(diff != 0) diff--;
        
        return (diff / pieces);
    }
}
