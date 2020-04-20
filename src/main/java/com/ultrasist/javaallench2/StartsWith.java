/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ultrasist.javaallench2;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *
 * @author jerrymac
 */
public class StartsWith {
    
    public static void main(String[] args){
        System.out.println(Charset.defaultCharset());
        Scanner in = new Scanner(System.in, "Windows-1250");
        System.out.println("Elija el tipo de lista:");
        System.out.print("1. Arreglo\n2. ArrayList\n");
        Boolean EsLista = false;
        if(in.hasNextInt()){
        EsLista = in.nextInt()==2;
        System.out.println("Escriba frases, después de cada una presione la tecla espacio, para finalizar, escriba un sólo caracter por el cual se filtrarán sus frases");
        if(!EsLista){        
            String[] arreglo = new String[1];
            int count = 0;
            char Buscado = ' ';
            while(in.hasNextLine()){
                String linea = in.nextLine();
                if(linea.trim().length() == 1){
                    Buscado = linea.charAt(0);
                    break;
                }
                if(count == arreglo.length){
                    arreglo = resize(arreglo, arreglo.length *2);
                }
                if(!linea.isEmpty()){
                arreglo[count] = linea;
                }
                count++;
            }
            String[] _result = StartsWith(arreglo, Buscado);
            System.out.println("Frases que comienzan con el carácter buscado:");
            for(int i = 0; i < _result.length; i++){
                System.out.println(_result[i]);
            }
        }
        }
        else
            System.out.println("Opción incorrecta");
    }
    
    public static String[] StartsWith(String[] args, char C){
        String[] _salida = new String[args.length];
        int Cuenta = 0;
        for(int i = 0, j= 0; i < _salida.length; i++){
            if(args[i] != null && args[i].charAt(0) == C){
                int Codigo = args[i].codePointAt(0);
                _salida[Cuenta] = args[i];
                Cuenta++;
            }
        }
        String[] _resultado = new String[Cuenta];
        for(int i = 0; i < Cuenta; i++){
            _resultado[i] = _salida[i];
        }
        return _resultado;
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
}
