/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 *
 * @author mario
 */
public class File {
    static Character[] vgAcceptedSymbols  = {'1', '2', '3', '4', '0', '*'};
    public static String readFile(java.io.File pFile){
        String vReturn = "";
        try {
           if(pFile.exists()){
               BufferedReader vBuffer= new BufferedReader(new FileReader(pFile));
               vReturn += checkFile(pFile); 
               vBuffer.close();
             }else{
               vReturn += "Error, No existe el archivo \n";
             }
       } catch (Exception ex) {
            vReturn += (ex.getMessage());
       }
       return vReturn;
    }
    
    public static String checkFile(java.io.File pFile)
    {
        String vString, vReturn = "";
        try {
            BufferedReader vBuffer= new BufferedReader(new FileReader(pFile));
            vReturn += lexicalCheck(pFile);
            vReturn += syntacticCheck(pFile);
            while((vString = vBuffer.readLine())!= null) {
                    int vSize = vString.length();
                    for (int vCont = 0; vCont < vSize ;vCont++)
                    {
                        //System.out.print(vString.charAt(vCont));
                    }
                    //System.out.println(vString);
                   }
        } catch (Exception ex) {
            vReturn += (ex.getMessage());
       }
        return vReturn;
    }
    
    public static String lexicalCheck(java.io.File pFile)
    {
        String vString, vReturn = "";
        int vSizeFile = 0;
        try {
            BufferedReader vBuffer= new BufferedReader(new FileReader(pFile));
            while((vString = vBuffer.readLine())!= null) {
                    int vSize = vString.length();
                    for (int vCont = 0; vCont < vSize ;vCont++)
                    {
                        char vElement = vString.charAt(vCont);
                        if (!(Arrays.asList(vgAcceptedSymbols).contains(vElement))) {
                            vReturn += ("Error, Símbolo no aceptado: "+ vElement +". Fila: " + vSizeFile + ", Columna: " + vCont + " \n"); 
                        }
                    }
                    vSizeFile += 1;
                   }
        } catch (Exception ex) {
            vReturn += (ex.getMessage());
       }
       return vReturn;
    }
    
    public static String syntacticCheck(java.io.File pFile)
    {
        String vString, vReturn = "";
        char vElement;
        int vSizeFile = 0;
        int vBall1 = 0, vBall2 = 0, vBall3 = 0, vBall4 = 0, vWall = 0, vSpace = 0;
        try {
            BufferedReader vBuffer= new BufferedReader(new FileReader(pFile));
            while((vString = vBuffer.readLine())!=null) {
                    int vSize = vString.length();
                    for (int vCont = 0; vCont < vSize ;vCont++)
                    {
                        vElement = vString.charAt(vCont);
                        String vP = String.valueOf(vElement);
                        switch(vP){ 
                            case ("1"): vBall1 +=1; 
                                        break;
                            case ("2"): vBall2 +=1; 
                                        break;
                            case ("3"): vBall3 +=1; 
                                        break;
                            case ("4"): vBall4 +=1; 
                                        break;
                            case ("0"): vSpace +=1; 
                                        break;
                            case ("*"): vWall +=1; 
                                        break;
                            default: break;
                        }  
                    }
                    if (vSizeFile == 0) 
                    {
                        if (vWall != 3) {vReturn += ("Error, deben de haber 3 paredes en la primera fila \n");} 
                    }
                    vSizeFile += 1;
                   }
            vReturn += syntacticCheck(vBall1, vBall2, vBall3, vBall4, vSpace, vWall);
        } catch (Exception ex) {
            vReturn += (ex.getMessage());
       }
        return vReturn;
    }
    
    public static String syntacticCheck(int pBall1, int pBall2, int pBall3, int pBall4, int pSpace, int pWall)
    {
        String vReturn = "";
        if (pBall1 >= 5) {vReturn +=("Error, deben de haber 4 bolitas de tipo 1 \n");}
        if (pBall2 >= 5) {vReturn +=("Error, deben de haber 4 bolitas de tipo 2  \n");}
        if (pBall3 >= 5) {vReturn +=("Error, deben de haber 4 bolitas de tipo 3 \n");}
        if (pBall4 >= 5) {vReturn +=("Error, deben de haber 4 bolitas de tipo 4 \n");}
        if (pSpace >= 2) {vReturn +=("Error, solo debe de haber 1 espacio en blanco \n");}
        if (pWall >= 4)  {vReturn +=("Error, solo pueden existir 3 paredes \n");}
        return vReturn;
    }
    
    static boolean contains(char[] array,char c) {
    for (char x : array) {
        if (x == c) {
            return true;
        }
    }
    return false;
    }
}
