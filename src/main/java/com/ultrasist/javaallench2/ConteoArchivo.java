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
public class ConteoArchivo {
    
    public static void main(String[] args){
        Scanner fileIn = null;
        Scanner in = null;
        System.out.println("Escriba la ruta del archivo");
        try{
            String ruta = null;
            in = new Scanner(System.in);
            ConteoCaracter[] arreglo = new ConteoCaracter[0];
            String[] lineas = new String[1];
            if(in.hasNextLine()){
                ruta = in.nextLine();
                fileIn = new Scanner(new FileReader(ruta));
                in.close();
                int cuenta = 0;
                while(fileIn.hasNextLine()){
                    String get = fileIn.nextLine();
                    if(lineas.length == cuenta)
                        lineas = resize(lineas,lineas.length+1);
                    lineas[cuenta] = get;
                    cuenta++;
                }
            }
            arreglo = GetConteoCaracteres(arreglo, lineas);
            BubbleSort(arreglo);
            System.out.println("Número de líneas en el archivo: "+lineas.length);
            int palabras = ConteoPalabras(lineas);
            System.out.println("Número de palabras en el archivo: "+palabras);
            for (ConteoCaracter cuenta : arreglo) {
               System.out.print(cuenta.GetCaracter()+": "+cuenta.GetCuenta()+" ");
            }
            System.out.println();
            }
        catch(IOException ex){
            
        }
        finally{
            if(fileIn != null)
                fileIn.close();
        }
    }
    
    public static void BubbleSort(ConteoCaracter[] arreglo){
        Boolean swap = true;
        while(swap){
            swap = false;
            for(int j = 0; j < arreglo.length-1; j++){
                if(arreglo[j].GetCaracter() > arreglo[j+1].GetCaracter()){
                    ConteoCaracter temporal = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = temporal;
                    swap = true;
                }
            }
        }
    }
    
    
    public static int ConteoPalabras(String[]lineas){
        int _result = 0;
        for(String linea:lineas){
            Boolean bandera = false;
            for(int i = 0; i < linea.length(); i++){
                
                char car = linea.charAt(i);
                if(car != ' ' && !bandera){
                    bandera = true;
                    _result++;
                }
                else if(car == ' '){
                    bandera = false;
                }
            }
        }
        return _result;
    }
    
    public static ConteoCaracter[] GetConteoCaracteres(ConteoCaracter[] arreglo,String[] lineas){
        for(String linea:lineas){
        for(int i = 0; i < linea.length(); i++){
            char car = linea.charAt(i);
            if(!ExisteCaracter(arreglo, car)){
                arreglo = resize(arreglo, arreglo.length+1);
                arreglo[arreglo.length-1] = new ConteoCaracter();
                arreglo[arreglo.length-1].SetCaracter(car);
                arreglo[arreglo.length-1].SetCuenta(1);
            }
            else{
                int Pos = GetPosCaracter(arreglo, car);
                int CuentaExiste = arreglo[Pos].GetCuenta();
                arreglo[Pos].SetCuenta(++CuentaExiste);
            }
        }
        }
        return arreglo;
    }
    public static Boolean ExisteCaracter(ConteoCaracter[] arreglo, char car){
        Boolean _result = false;
        for(var i = 0; i < arreglo.length; i++){
           if(arreglo[i].GetCaracter() == car){
               _result = true;
               break;
           }
        }
        return _result;
    }
    public static int GetPosCaracter(ConteoCaracter[]arreglo, char car){
        int _result = 0;
        for(var i = 0; i< arreglo.length; i++){
        if(arreglo[i].GetCaracter() == car){
            _result = i;
            break;
        }
        }
        return _result;
    }
    public static String[] resize(String[] args, int newSize){
        String[]original = args;
        int numCopy = Math.min(args.length, newSize);
        args = new String[newSize];
        for(int i = 0; i < numCopy; i++){
            args[i] = original[i];
        }
        return args;
    }
    public static ConteoCaracter[] resize(ConteoCaracter[] args, int newSize){
        ConteoCaracter[]original = args;
        int numCopy = Math.min(args.length, newSize);
        args = new ConteoCaracter[newSize];
        for(int i = 0; i < numCopy; i++){
            args[i] = original[i];
        }
        return args;
    }
}

