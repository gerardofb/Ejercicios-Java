/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ultrasist.javaallench2;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Character;
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 *
 * @author jerrymac
 */
public class CheckSum {
    
    public static void main(String[]args){
        if(args.length == 0)
            System.out.println("No se especificó ningún archivo");
        for(String nombreArchivo:args){
            System.out.println("Checksum del archivo "+nombreArchivo+": "+checkSumFile(nombreArchivo));
        }        
    }
    
    public static int checkSumFile(String nombreArchivo){
      Scanner fileIn = null;
      int suma = 0;
      System.out.println("Archivo: "+nombreArchivo);
      try{
          fileIn = new Scanner(new FileReader(nombreArchivo));
          while(fileIn.hasNextLine()){
              String linea = fileIn.nextLine();
              for(int i = 0; i<linea.length(); i++){
                  char valor = linea.charAt(i);
                  int numero = Character.getNumericValue(valor);
                  suma+= numero;
              }
          }
      }
      catch(IOException e){
          System.out.println(e);
      }
      finally{
          if(fileIn!= null){
              fileIn.close();
          }
      }
      return suma;
    }
}
