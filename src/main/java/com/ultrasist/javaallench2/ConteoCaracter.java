/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ultrasist.javaallench2;

/**
 *
 * @author jerrymac
 */
public class ConteoCaracter{
   private char _Caracter;
   private int _Cuenta;
   public void SetCaracter(char _car){
       _Caracter = _car;
   }
   public char GetCaracter(){
       return _Caracter;
   }
   public void SetCuenta(int _cuenta){
       _Cuenta = _cuenta;
   }
   public int GetCuenta(){
       return _Cuenta;
   }
}

