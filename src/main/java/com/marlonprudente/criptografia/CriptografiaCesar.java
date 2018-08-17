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
public class CriptografiaCesar {

    public static char cifra[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static String Criptografar(String frase, int k) {

        String aux = "";
        /**
         * Utilizando o vetor cifra, desloca-se k casas para a direita.
         */
        int i = 0;
        for (int j = 0; j < 62; j++) {
            if (frase.charAt(i) == cifra[j]) {
                if ((j + k) < 62) {
                    aux += (cifra[j + k]);
                    i++;
                    j = 0;
                } else {
                    aux += (cifra[(j + k) - 62]);
                    i++;
                    j = 0;
                }
            }
            if (i == frase.length()) {
                break;
            }
        }

        return aux;
    }

    public static String Descriptografar(String frase, int k) {
        String aux = "";
        /**
         * Utilizando a tabela ASCII, desloca-se k casas para a esqurda.
         */
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            for (int j = 0; j < 62; j++) {

                if (c == cifra[j]) {
                    if ((j - k) > 0) {
                        aux += (cifra[j - k]);
                    } else {
                        aux += (cifra[(j - k) + 62]);
                    }
                }
            }
            if (c == ' ' || c == '\n') {
                aux += c;
            }
        }
//                if (c == cifra[j]) {
//                    if ((j - k) > 0) {
//                        aux += (cifra[j - k]);
//                        j = 0;
//                    } else {
//                        aux += (cifra[(j - k) + 62]);
//                        j = 0;
//                    }
//                }
//            }

        return aux;
    }

}
