/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ultrasist.javaallench2;

import java.util.Scanner;

/**
 *
 * @author jerrymac
 */
public class Maximo {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Escriba al menos diez números que desee comparar, escriba asterisco para salir:");
        int maximo, minimo = 0;
        int[] ArregloEnteros = new int[10];
        String[] ArregloCadenas = new String[]{"","","","","","","","","",""};
        int itemsEnteros = 0; int itemsCadenas = 0;
        while(in.hasNextInt()){
           if(itemsEnteros == ArregloEnteros.length)
            ArregloEnteros = resize(ArregloEnteros, ArregloEnteros.length *2);
            ArregloEnteros[itemsEnteros++]=in.nextInt();
        }

        System.out.println("Escriba las cadenas que desee comparar");
        Boolean Bandera = false;
        while(in.hasNextLine()){
            String line = in.nextLine();
            if(line.isEmpty() && Bandera)
                break;
            Bandera = true;
            if(itemsCadenas == ArregloCadenas.length)
               ArregloCadenas = resize(ArregloCadenas, ArregloCadenas.length*2);
            if(!line.equals("*") && !line.isEmpty())
            ArregloCadenas[itemsCadenas++] = line;
        }
        System.out.println("El máximo de los enteros es: "+Maximo(ArregloEnteros)+" y el mínimo de ellos es: "+Minimo(ArregloEnteros));
        System.out.println("La máxima de las cadenas alfabéticamente es:");
        System.out.println(Maximo(ArregloCadenas));
        System.out.println("La mínima de las cadenas alfabéticamente es:");
        System.out.println(Minimo(ArregloCadenas));
    }
    public static int[] resize(int[] args, int newSize){
    int[] original = args;
    int numCopiar = Math.min(original.length, newSize);
    args = new int[newSize];
    for(int i = 0; i < numCopiar; i++){
        args[i] = original[i];
    }
    return args;
    }
    public static String[] resize(String[] args, int newSize){
    String[] original = args;
    int numCopiar = Math.min(original.length, newSize);
    args = new String[newSize];
    for(int i = 0; i < numCopiar; i++){
        args[i] = original[i];
    }
    return args;
    }
    public static String Maximo(String[] Arreglo){
        String Maximo = Arreglo[0];
        int Comparador = 0;
        for(int i =0; i < Arreglo.length; i++){
            if(!Arreglo[i].isEmpty()){
            int Comparacion =  Maximo.compareTo(Arreglo[i]);
            if( Comparacion < 0 && Comparacion < Comparador){
                Comparador = Comparacion;
                Maximo = Arreglo[i];
            }
            }
        }
        return Maximo;
    }
    public static String Minimo(String[] Arreglo){
        String Minimo = Arreglo[0];
        int Comparador = 0;
        for(int i = 0; i < Arreglo.length; i++){
            if(!Arreglo[i].isEmpty())
            {
            int Comparacion = Minimo.compareTo(Arreglo[i]);
            if(Comparacion >0 && Comparacion > Comparador){
                Comparador = Comparacion;
                Minimo = Arreglo[i];
            }
            }
        }
        return Minimo;
    }
    
    public static int Maximo(int[] Arreglo){
        int Maximo = Arreglo[0];
        for(int i = 0; i < Arreglo.length; i++){
            if(Arreglo[i] > Maximo && Arreglo[i]!= 0)
                Maximo = Arreglo[i];
        }
        return Maximo;
    }
        public static int Minimo(int[] Arreglo){
        int Minimo = Arreglo[0];
        for(int i = 0; i < Arreglo.length; i++){
            if(Arreglo[i] < Minimo && Arreglo[i]!= 0)
                Minimo = Arreglo[i];
        }
        return Minimo;
    }
}
