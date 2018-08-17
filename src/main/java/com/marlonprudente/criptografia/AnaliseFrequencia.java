/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marlonprudente.criptografia;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marlon
 */
public class AnaliseFrequencia {
    
    /**
     *
     * @return
     */
        public static char caracteres[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                                           'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                                           '0','1','2','3','4','5','6','7','8','9'};
        
    public static char analisarFrequencia(String texto){
        
        int frequencia[] = new int[62];
        
        for(int n = 0; n < frequencia.length;n++){
            frequencia[n] = 0;
        }

        for(int i = 0; i< texto.length();i++){
            char c = texto.charAt(i);            
            for(int j = 0; j< 62;j++){
                if(c == caracteres[j]){
                    frequencia[j]++;                  
                }                    
            }            
        }
        int index = 0;
        int maior = 0;
        for(int i = 0;i<62;i++){
            if(frequencia[i]> maior){
                maior = frequencia[i];
                index = i;
            }
        }
        
        return caracteres[index] ;
    }
    
}
