/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ultrasist.javaallench2;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *
 * @author jerrymac
 */
public class Minusculas {
    
    public static void main(String[] args){
        Scanner lector = new Scanner(System.in, StandardCharsets.UTF_8.name());
        System.out.println("Elija el tipo de lista:");
        System.out.print("1. Arreglo\n2. ArrayList\n");
        Boolean EsLista = false;
        if(lector.hasNextInt()){
        EsLista = lector.nextInt()==2;
        System.out.println("Escriba al menos cinco frases, después de cada una presione la tecla espacio, asterisco para terminar");
        if(!EsLista){        
        String[]arreglo = new String[]{"","","","",""};
        int cuenta = 0;
        while(lector.hasNextLine()){
            String linea = lector.nextLine();
            if(linea.trim().equals("*"))
               break;
            if(cuenta == arreglo.length)
                arreglo = resize(arreglo, arreglo.length*2);
            if(!linea.isEmpty()){
            arreglo[cuenta]=linea;
            cuenta++;
            }
        } 
        String[] ObtenerMinusculas = GetMinusculas(arreglo);
        for(int i = 0; i < arreglo.length; i++){
            if(arreglo[i]!= null && !arreglo[i].isEmpty()){
            System.out.println("Cadena número "+(i+1));
            System.out.println(arreglo[i]);
            System.out.println("Obteniendo cadena en minúsculas");
            System.out.println(ObtenerMinusculas[i]);
            }
        }
        System.out.println("Transformando arreglo a minúsculas");
        arreglo = SetMinusculas(arreglo);
        for(int j = 0; j < arreglo.length; j++){
            if(arreglo[j]!=null && !arreglo[j].isEmpty()){
            System.out.println("Leyendo valor del arreglo modificado");
            System.out.println(arreglo[j]);
            }
        }

        }
        }
        else{
           System.out.println("Opción incorrecta");
           return;
        }
        
    }
    public static String[] GetMinusculas(String[] entrada){
    String[] salida = new String[entrada.length];
    for(int i = 0; i < salida.length; i++)
        if(entrada[i] != null)salida[i]= entrada[i].toLowerCase();
    return salida;
    }
    public static String[] SetMinusculas(String[] entrada){
    for(int i = 0; i < entrada.length; i++)
        if(entrada[i] != null)entrada[i]= entrada[i].toLowerCase();
    return entrada;
    }
    
    public static String[]resize(String[]args, int newsize){
        String[] original = args;
        int numCopiar = Math.min(args.length, newsize);
        args=new String[newsize];
        for(int i = 0; i < numCopiar; i++){
            args[i]=original[i];
        }
        return args;
    }
}
