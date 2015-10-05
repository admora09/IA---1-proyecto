package test;

import java.util.ArrayList;
import java.util.List;

public class BabMatrix{
    
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
    
    public List<List<String>> cloneMatrix(){
        List<List<String>> result = new ArrayList<>();
        
        for(int i=0; i<this.getRows(); i++){
            List<String> row = new ArrayList<>();
            for(int j=0; j<this.getColumns(); j++){
                row.add(this.get(i, j));
            }
            result.add(row);
        }
        
        return result;
    }
    
    public String get(int i, int j){
        try{
            return this._Matrix.get(i).get(j);
        }catch(Exception e){
            return null;
        }
    }
       
    public void swap(int i, int j, int x, int y){
        String save = this.get(i, j);
        this._Matrix.get(i).set(j, this.get(x, y));
        this._Matrix.get(x).set(y, save);
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
    
    public void print(){
        System.out.println();
        for(int i=0; i<getRows(); i++){
            for(int j=0; j<getColumns(); j++){
                System.out.print( get(i, j) + " " );
            }
            System.out.println();
        }
    }
}
