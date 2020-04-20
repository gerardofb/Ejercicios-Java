/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ultrasist.javaallench2;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


/**
 *
 * @author jerrymac
 */
public class InvertirCadena {
    public static void main(String[] args){
        try{
            ArrayList<String> Listado = new ArrayList<String>();
            String[] Arreglo = new String []{"","","","","","","","",""};
            Scanner in = new Scanner(System.in, StandardCharsets.UTF_8.name());
            System.out.println("Elija el tipo de lista:");
            System.out.print("1. Arreglo\n2. ArrayList\n");
            Boolean esArreglo = false, Bandera = true;
            if(in.hasNextInt()){
                esArreglo = in.nextInt() == 1;
            }
            else{
                System.out.println("No se eligió la opción correcta");
                return;
            }
            int itemsArreglo = 0;
            while(in.hasNextLine()){
                String line = in.nextLine();
                if(line.isEmpty() && !Bandera)
                    break;
                Bandera = false;
                if(!esArreglo)
                Listado.add(line);
                else{
                if(itemsArreglo == Arreglo.length)
                Arreglo = resize(Arreglo, Arreglo.length*2);
                Arreglo[itemsArreglo++] = line;
                }
            }
            if(!esArreglo){
            Listado = InvertirLista(Listado);
            System.out.println("************************* Cadenas invertidas: *************************");
            for(String elem:Listado){
                System.out.println(elem);
            }
            }
            else{
            Arreglo = InvertirArreglo(Arreglo);
            System.out.println("************************* Cadenas invertidas: *************************");
            for(String elem:Arreglo){
                if(elem != null && !elem.isEmpty())
                System.out.println(elem);
            }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
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
    public static String[] InvertirArreglo(String[] Arreglo){
        int n;
        int i = 0;
        String[] Resultado = new String[Arreglo.length];
        for(n = Arreglo.length -1; n >= i; n--){
            Resultado[n] = Arreglo[n];
        }
        for(int b= 0; b < Resultado.length; b++){
            if(Resultado[b]!= null){
            char[] arreglo = Resultado[b].toCharArray();
            char[] invertido = new char[arreglo.length];
            for(int j = arreglo.length -1, a = 0; j >= 0; j--,a++){
                invertido[a]=arreglo[j];
            }
            Resultado[b]=new String(invertido);
            }
        }
        return Resultado;
    }
    public static ArrayList<String> InvertirLista(ArrayList<String> Lista){
        int n;
        int i = 0;
        ArrayList<String> Resultado = new ArrayList<String>();
        for(n = Lista.size() -1; n >= i; n--){
            Resultado.add(Lista.get(n));
        }
        for(int b= 0; b < Resultado.size(); b++){
            char[] arreglo = Resultado.get(b).toCharArray();
            char[] invertido = new char[arreglo.length];
            for(int j = arreglo.length -1, a = 0; j >= 0; j--,a++){
                invertido[a]=arreglo[j];
            }
            Resultado.set(b, new String(invertido));
        }
        return Resultado;
    }
}
