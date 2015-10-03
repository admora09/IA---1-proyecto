/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import test.BabMatrix;

/**
 * This class represents a Matrix
 * @author Cristian Araya
 */
public class Matrix {
    
   /**
    * Creates a new matrix
    * @param pRow: Row's number 
    * @param pColumn: Column's number
    * @return String [][]
    * @author Cristian Araya
    */
    public static String[][] createMatrix(int pRow, int pColumn ) {
        return new String[pRow][pColumn]; 
    }
 
   /**
    * Creates the classic Babylon matrix, it has 5 rows and 4 columns.
    * @param 
    * @return String [][]
    * @author Cristian Araya
    */
    public static String[][] createBabylonMatrix()
    {
        return Matrix.createBabylonMatrix(5,4);
    }
    
   /**
    * Assigns the corresponding numbers to Babylon matrix.
    * @param pRow: Row's number 
    * @param pColumn: Column's number
    * @return String [][]
    * @author Cristian Araya
    */
    public static String[][] createBabylonMatrix(int pRow, int pColumn ) {
        String mat[][] = createMatrix( pRow, pColumn );
        for(int i = 0; i < pRow; i++) {
            for(int j = 0; j < pColumn; j++) {
                if (i == 0) {mat[i][j] = "*";}
                else {mat[i][j] = Integer.toString(j+1);} 
                if (i == 0 && j == 3) {mat[i][j] = "0";} 
            }
        }
        return mat; 
    }
 
   /**
    * Prints a matrix
    * @param mat: Matrix
    * @author Cristian Araya
    */
    public static void printMatrix( String mat[][] ) { 
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                System.out.print( mat[i][j] ); 
            }
            System.out.println( );
        }
    }
    
    public static List<List<String>> getList(String mat[][])
    {
        List<List<String>> list = new ArrayList<>();
        for(int i = 0; i < mat.length; i++) {
            list.add(Arrays.asList(mat[i]));
        }
        
        return list;
    }
    
    public static ArrayList<String[][]> getArray(List <BabMatrix> list)
    {
        ArrayList<String[][]> mat = new ArrayList<String[][]>(); 
        List<List<String>> a = new ArrayList<List<String>>();
        String[][] tempMat = createBabylonMatrix();
        
        for(int i = 0; i < list.size(); i++){
            a = list.get(i).getMatrix();
            for(int j = 0; j < a.size(); j++) {
                List<String> p = a.get(j);
                tempMat[i][j] = p.get(j);
            }
            mat.add(tempMat);
        }
        return mat;
    }

    /**
    * Creates a BabylonMatrix from a given file
    * @param pFile: txt file with a matrix
    * @return String [][]
    * @author Cristian Araya
    */
    public static String[][] createBabylonMatrix(File pFile)
    {
        String vMatrix[][] = createMatrix(5, 4);
        String vString, vReturn = "";
        int vRowCount = 0;
        try {
            BufferedReader vBuffer= new BufferedReader(new FileReader(pFile));
            while((vString = vBuffer.readLine())!= null) {
                int vSize = vString.length();
                for (int vCont = 0; vCont < vSize ;vCont++)
                {
                    vMatrix[vRowCount][vCont] = Character.toString(vString.charAt(vCont));
                }
                vRowCount += 1;
            }
        } catch (Exception ex) {
            vReturn += (ex.getMessage());
       }
        return vMatrix;
    }
}
