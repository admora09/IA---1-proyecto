/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adonis
 */
public class xxx {
    
    public xxx(){
        
    }
    
    public void x (BabMatrix matrix){
        BabMatrix test = matrix;
        BabMatrix temp;

        temp = moveUp(test, 0, 0);
        if(temp != null){
            System.out.println("\nmove up");
            temp.print();
        }

        temp = moveDown(test, 0, 0);
        if(temp != null){
            System.out.println("\nmove down");
            temp.print();
        }

        for(int i=0; i<test.getRows(); i++){
            System.out.println("\nshift izq");
            shiftLeft(test, i).print();

            System.out.println("\nshift der");
            shiftRight(test, i).print();
        }
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
}
