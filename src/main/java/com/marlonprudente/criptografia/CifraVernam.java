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

    public static char caracteres[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static String chave = "";

    public static String Criptografar(String texto) {
        texto = texto.replace(" ", "");
        chave = generateVerificationCode(texto.length());        
        String aux = chave + "::";
        int index ;
        int indexTexto = 0;
        int valueTexto = 0;
        int indexChave = 0;
        int valueChave = 0;
        

            for (int j = 0; j < texto.length(); j++) {
                
                char t = texto.charAt(indexTexto); //Pega a Letra
                indexTexto++;
                for (int i = 0; i < 62; i++) { //percorre as letras
                    if (t == caracteres[i]) { //Ao encontrar, poe na variavel o valor do caractere na variavel
                        valueTexto = i;
                    }
                }
                
                char c = chave.charAt(indexChave);
                indexChave++;
                for (int i = 0; i < 62; i++) {
                    if (c == caracteres[i]) {
                        valueChave = i;
                    }
                }
                index = (valueTexto + valueChave) % 62;
                aux += caracteres[index];
            }            
        return aux;
    }
    public static String getChave(){
        return chave;
    }
    public static String Descriptografar(String texto){
        String descriptoVernam[] = texto.split("::");
        chave = descriptoVernam[0];
        texto = descriptoVernam[1];
        
        System.out.println("Chave: " + chave);        
        System.out.println("Frase Encrypted: " + texto);        
        String aux = "";
        int index;
        int indexTexto = 0;
        int valueTexto = 0;
        int indexChave = 0;
        int valueChave = 0;       

            for (int j = 0; j < texto.length(); j++) {
                
                char t = texto.charAt(indexTexto); //Pega a Letra
                indexTexto++;
                for (int i = 0; i < 62; i++) { //percorre as letras
                    if (t == caracteres[i]) { //Ao encontrar, poe na variavel o valor do caractere na variavel
                        valueTexto = i;
                    }
                }                
                char c = chave.charAt(indexChave);
                indexChave++;
                for (int i = 0; i < 62; i++) {
                    if (c == caracteres[i]) {
                        valueChave = i;
                    }
                }
                index = (valueTexto - valueChave) % 62;                
                if(index < 0)
                    index = 62 + index;
                
                aux += caracteres[index];
            }
            
        return aux;
    }

    public static String generateVerificationCode(int tamanho) {
        String tmp = "";
        for (int i = 0; i < tamanho; i++) {
            int c = (int) Math.floor(Math.random() * getAllowedCharacters().length);
            tmp += getAllowedCharacters()[c];
        }
        return tmp;
    }

    public static char[] getAllowedCharacters() {
        return caracteres;
    }
}
