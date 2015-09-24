/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author mario
 */
public class Matrix {
    
    public static String[][] createMatrix(int pRow, int pColumn ) {
        return new String[pRow][pColumn]; 
    }
 
    public static String[][] createBabylonMatrix()
    {
        return Matrix.createBabylonMatrix(5,4);
    }
    
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
 
 
    public static void printMatrix( String mat[][] ) { 
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                System.out.print( mat[i][j] ); 
            }
            System.out.println( );
        }
    }
    
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
