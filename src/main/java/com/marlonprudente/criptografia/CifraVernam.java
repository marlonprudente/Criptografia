/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marlonprudente.criptografia;

/**
 *
 * @author Marlon
 */
public class CifraVernam {
    
public static char caracteres[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                                   'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                                   '0','1','2','3','4','5','6','7','8','9'};
    
    public static String Criptografar(String texto, String chave){
        texto = texto.replace(" ", "");
        chave = chave.replace(" ", "");
        String aux = "";
        int index = 0;
        int indexTexto = 0;
        int valueTexto = 0;
        int indexChave = 0;
        int valueChave = 0;
        if(texto.length() == chave.length()){
            for(int j = 0; j< texto.length();j++){
            char t = texto.charAt(indexTexto);            
            for(int i = 0; i< 62;i++){
                if(t == caracteres[i])
                    valueTexto = i;
            }
           char c = chave.charAt(indexChave);            
            for(int i = 0; i< 62;i++){
                if(c == caracteres[i])
                    valueChave = i;
            }
            index = (valueTexto + valueChave) % 62;
            aux += caracteres[index];
            }
        }
        
        return aux;
    }
    
}
