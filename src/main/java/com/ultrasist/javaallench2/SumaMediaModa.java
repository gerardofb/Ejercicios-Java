/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ultrasist.javaallench2;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author jerrymac
 */
public class SumaMediaModa {
    public static void main(String[]args){
        /*if(args.length == 0)
            System.out.println("No se especificó ningún archivo");
        for(String nombreArchivo:args){
            System.out.println("Checksum del archivo "+nombreArchivo+": "+checkSumFile(nombreArchivo));
        }*/
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese al menos 10 números con decimales separados por retorno de carro");
        try{
            double[]arr = new double[11];
            int items = 0;
            while(in.hasNextDouble()){
                
                if(items == arr.length){
                    arr = SumaMediaModa.resize(arr, arr.length * 2);
                }
                arr[items++] = in.nextDouble();
            }
            double suma = SumaMediaModa.sum(arr);
            double average = SumaMediaModa.average(arr);
            double moda = SumaMediaModa.moda(arr);
            System.out.println("La suma de los números es: "+suma+", el promedio de los números es: "+average+", la moda de los números es: "+(moda > -1?moda:"no existe moda"));
        }
        catch(NoSuchElementException e){
            System.err.println("Error, se requiere un número con punto decimal");
        }
    }
    public static double[] resize(double[] args, int newSize){
    double[] original = args;
    int numCopiar = Math.min(original.length, newSize);
    args = new double[newSize];
    for(int i = 0; i < numCopiar; i++){
        args[i] = original[i];
    }
    return args;
}
    public static double sum(double[] args){
       double suma = 0.0;
       for(int i= 0; i < args.length; i++){
           suma+=args[i];
       }
       return suma;
    }
    public static double average(double[] args){
        double average = 0.0;
        for(int i = 0; i< args.length; i++){
            average+= args[i];
        }
        average/=args.length;
        return average;
    }
    public static double moda(double[] args){
        int i,j,moda = 0, n = args.length;
        int frecTemp, frecModa = 0; double moda1 = -1.0;
        args = burbuja(args,0);
        for(i = 0; i < n; i++){
            frecTemp = 1;
            for(j = i+1; j < n; j++){
            if(args[i] == args[j] && args[i] != 0){
                frecTemp++; 
                
            }
            if(frecTemp > frecModa){
                    frecModa = frecTemp;
                    moda1 = args[i];
            }
            }
        }
        return moda1;
    }
    public static double[] burbuja(double[] args, int orden){
        int i,j,n =args.length; double aux = 0;
        for(i= 0; i <  n; i++){
            for(j= i+1; j < n; j++){
                if(orden == 0){
                    if(args[i] > args[j]){
                        aux = args[j];
                        args[j]= args[i];
                        args[i] = aux;
                    }
                }
                else if(orden == 1){
                    if(args[i] < args[j]){
                        aux = args[i];
                        args[i] = args[j];
                        args[j] = aux;
                    }
                }
            }
        }
        return args;
    }
}
