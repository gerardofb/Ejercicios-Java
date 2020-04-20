/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ultrasist.javaallench2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jerrymac
 */
public class LongitudCadenas {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Elija el tipo de colección:");
        System.out.println("1. Arreglo");
        System.out.println("2. ArrayList");
        int Eleccion = 0;
        String[] Arreglo = new String[]{"","","","","","","","","",""};
        ArrayList<String> Listado = new ArrayList<String>();
        if(in.hasNextInt()){
            Eleccion = in.nextInt();
        }
        else{
            System.out.println("No se eligió la opciòn correcta. Saliendo...");
        }
        int items = 0;
        Boolean Bandera = false;
        while(in.hasNextLine()){
            String linea = in.nextLine();
            if(linea.isEmpty() && Bandera)
                break;
            Bandera = true;
            if(Eleccion == 1){
                if(items == Arreglo.length)
                Arreglo = resize(Arreglo, Arreglo.length*2);
                Arreglo[items++]=linea;
            }
            else if(Eleccion == 2){
                Listado.add(linea);
            }
            else return;
        }
        if(Eleccion == 1){                    
            System.out.println("Longitud de la colección: "+ LongitudArreglo(Arreglo)  +". Longitud de todos los caracteres: "+ LongitudCadenas(Arreglo));
        }
        else if(Eleccion == 2){  
            Listado.remove(new String(""));
            System.out.println("Longitud de la colección: "+ Listado.size()  +". Longitud de todos los caracteres: "+ LongitudCadenas(Listado));
        }

    }
    public static String[] resize(String[] args, int newSize){
    String[] original = args;
    int numCopiar = Math.min (original.length, newSize);
    args = new String[newSize];
    for(int i = 0; i < numCopiar; i++){
        args[i] = original[i];
    }
    return args;
    }
    public static int LongitudCadenas(String[] Cadenas){
        int Total = 0;
        int ElementosValidos = 0;
        for(String cadena:Cadenas){
            char[] item = new char[0];
            if(cadena != null)
            item = cadena.toCharArray();
            
            if(item.length > 0)
            Total+= item.length;
        }
        return Total;
    }
    
    public static int LongitudArreglo(String[] Cadenas){
        int ElementosValidos = 0;
        for(String cadena:Cadenas){
            char[] item = new char[0];
            if(cadena != null)
            item = cadena.toCharArray();
            
            if(item.length > 0)
                ElementosValidos++;
        }
        return ElementosValidos;
    }
    public static int LongitudCadenas(ArrayList<String> Cadenas){
        int Total = 0;
        for(String cadena:Cadenas){
            char[] item = cadena.toCharArray();
            Total+= item.length;
        }
        return Total;
    }
}
