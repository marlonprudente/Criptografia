package com.marlonprudente.criptografia;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import javax.crypto.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marlon
 */
public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException {
        String teste = CriptografiaCesar.Criptografar("teste", 5);
        System.out.println("Criptografar: " + teste);
        System.out.println("Descriptografar: " + CriptografiaCesar.Descriptografar(teste, 5));
        //=============================================================================
        String frase = "g5Bt5 t54yvtz3v4A5 wrG t53 7Bv r9 6v995r9 9v 9z4Ar3\n"
                + "58xB2y59r9. dBzA5 t54yvtz3v4A5, 7Bv 9v 9z4Ar3\n"
                + "yB3z2uv9. Vy r99z3 7Bv r9 v96zxr9 9v3 x8r59 v8xBv3\n"
                + "uv9uv4y59r3v4Av r trsvtr 6r8r 5 tvB, v47Br4A5 r9\n"
                + "tyvzr9 r9 srzEr3 6r8r r Av88r, 9Br 3rv.\n"
                + "cv54r8u5 Ur mz4tz.";
        System.out.println("Caractere correspondente a A (Cesar): " + AnaliseFrequencia.analisarFrequencia(frase));
        String fraseDescripto = CriptografiaCesar.Descriptografar(frase, 17);
        System.out.println("Descriptografar: " + fraseDescripto);

        String fraseVernam = CifraVernam.Criptografar(fraseDescripto);
        System.out.println("Vernam: " + fraseVernam);        
        System.out.println("Caractere correspondente a A (Vernam): " + AnaliseFrequencia.analisarFrequencia(fraseVernam));
        System.out.println("Vernam Descripto: " + CifraVernam.Descriptografar(fraseVernam));

        String plaintext = "Howdy!";
        String ENCRYPTION_ALGORITHM = "ARCFOUR";

        KeyGenerator rc4KeyGenerator = KeyGenerator.getInstance(ENCRYPTION_ALGORITHM);
        SecretKey secretKey = rc4KeyGenerator.generateKey();
        Cipher rc4 = Cipher.getInstance(ENCRYPTION_ALGORITHM);

        byte[] ciphertextBytes = null;
        try {
            ciphertextBytes = encrypt(fraseDescripto, secretKey, rc4);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            decrypt(secretKey, rc4, ciphertextBytes);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static byte[] encrypt(String plaintext, SecretKey secretKey, Cipher rc4) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        rc4.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] plaintextBytes = plaintext.getBytes();
        byte[] ciphertextBytes = rc4.doFinal(plaintextBytes);
        System.out.println("RC4 ciphertext base64 encoded: " + Base64.encodeBase64String(ciphertextBytes));
        return ciphertextBytes;
    }

    private static void decrypt(SecretKey secretKey, Cipher rc4, byte[] ciphertextBytes) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        rc4.init(Cipher.DECRYPT_MODE, secretKey, rc4.getParameters());
        byte[] byteDecryptedText = rc4.doFinal(ciphertextBytes);
        String plaintextBack = new String(byteDecryptedText);
        System.out.println("Decrypted back to: " + plaintextBack);
    }

}
