package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Heuristic {
    
    final static int maxI = 5;
    final static int maxJ = 4;
    final static int pieces = 19;

    public double calcH(BabMatrix source, BabMatrix destination) {
        double cont = 0;
        List<point> lista = new ArrayList<>();
        
        for(int i = 0; i<maxI; i++){
            for(int j = 0; j<maxJ; j++){
                if(!source.get(i, j).equals(destination.get(i, j)))
                    lista.add(new point(i,j,source.get(i, j)));
            }
        }
        
        while(!lista.isEmpty()){
            point temp = lista.remove(0);
            if(!temp.value.equals(destination.get(temp.i, temp.j))){
                for(int i=0; i<lista.size(); i++ ){
                    if(lista.get(i).value.equals(destination.get(temp.i, temp.j))){
                        swap(temp, lista.get(i));
                        cont += (Math.abs(temp.i - lista.get(i).i) + Math.abs(temp.j - lista.get(i).j));
                        break;
                    }
                }
            }
        }
        
        return (cont / pieces);
    }
    
    private void swap(point source, point destination){
        String save = source.value;
        source.value = destination.value;
        destination.value = save;
    }
    
    private class point{
        public int i;
        public int j;
        public String value;
        
        public point(int i, int j, String value){
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
}
