/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ultrasist.javaallench2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jerrymac
 */
public class ListarEntrada {

public static void main(String[] args){
    if(args.length == 0){
        while(listEntrada()){
            
        }
    }
    else{
        for(String fileName:args){
            listFile(fileName);
        }
    }
}

public static Boolean listEntrada(){
    Scanner entIn = null;
    try{
        entIn = new Scanner(System.in);
        while(entIn.hasNextLine()){
            String line = entIn.nextLine();
            System.out.println(line);
            if(line.isEmpty())
                break;
        }
        return false;
    }
    catch(Exception e){
        System.out.println(e);
    }
    finally{
        if(entIn != null)
            entIn.close();
    }
    return true;
}

public static void listFile(String fileName){
Scanner fileIn = null;
System.out.println("Archivo: "+fileName); 
try{
    fileIn = new Scanner(new FileReader(fileName));
    while(fileIn.hasNextLine()){
        System.out.println(fileIn.nextLine());
    }
}
catch(IOException e){
    System.out.println(e);
}
finally{
    if(fileIn != null)
        fileIn.close();
}
}
}
