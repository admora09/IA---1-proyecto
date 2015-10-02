package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BabMatrix{
    private final static int maxPosI = 4;
    private final static int maxPosJ = 3;
    
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

    public List<BabMatrix> generateStates(){
        List<BabMatrix> result = new ArrayList<>();
        BabMatrix test = this;
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
        for(int i=0; i<getRows(); i++){
            for(int j=0; j<getColumns(); j++){
                if(this.get(i, j).equals("0")){
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
