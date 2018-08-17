/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static com.marlonprudente.criptografia.AnaliseFrequencia.*;
import static com.marlonprudente.criptografia.CriptografiaCesar.*;
import static com.marlonprudente.criptografia.CifraVernam.*;
/**
 *
 * @author Marlon
 */
public class Main {
    public static void main(String[] args) {
        String teste = Criptografar("teste",5);
        System.out.println("Criptografar: " + teste);        
        System.out.println("Descriptografar: " + Descriptografar(teste,5));
        //=============================================================================
        String frase = "g5Bt5 t54yvtz3v4A5 wrG t53 7Bv r9 6v995r9 9v 9z4Ar3\n" +
                        "58xB2y59r9. dBzA5 t54yvtz3v4A5, 7Bv 9v 9z4Ar3\n" +
                        "yB3z2uv9. Vy r99z3 7Bv r9 v96zxr9 9v3 x8r59 v8xBv3\n" +
                        "uv9uv4y59r3v4Av r trsvtr 6r8r 5 tvB, v47Br4A5 r9\n" +
                        "tyvzr9 r9 srzEr3 6r8r r Av88r, 9Br 3rv.\n" +
                        "cv54r8u5 Ur mz4tz.";
        
        System.out.println("Caractere correspondente a A: " + analisarFrequencia(frase));
        
        System.out.println("Descriptografar: " + Descriptografar(frase,17));
        
        System.out.println("Vernam: " + Criptografar("teste", "abcde"));
        
    }
}
