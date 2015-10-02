package test;

import java.util.ArrayList;
import java.util.List;

public class BabMatrix {
    private List<List<String>> _Matrix;
    
    public BabMatrix (){
        this._Matrix = new ArrayList<>();
    }
    
    public BabMatrix (List<List<String>> Matrix){
        this._Matrix = Matrix;
    }
    
    /**
     * @return the _Matrix
     */
    public List<List<String>> getMatrix() {
        return _Matrix;
    }

    /**
     * @param _Matrix the _Matrix to set
     */
    public void setMatrix(List<List<String>> _Matrix) {
        this._Matrix = _Matrix;
    }
    
    public String get(int i, int j){
        try{
            return this._Matrix.get(i).get(j);
        }catch(Exception e){
            return null;
        }
    }
    
    public int getRows(){
        try{
            return this._Matrix.size();
        }catch(Exception e){
            return 0;
        } 
    }
    
    public int getColumns(){
        try{
            return this._Matrix.get(0).size();
        }catch(Exception e){
            return 0;
        } 
    }

    public List<BabMatrix> generateStates(){
        return null;
    }
    
    public void print(){
        for(int i=0; i<getRows(); i++){
            for(int j=0; j<getColumns(); j++){
                System.out.print( get(i, j) + " " );
            }
            System.out.println();
        }
    }
}
