package org.acme.Util;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import java.security.MessageDigest;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class URLCrypto {
    // Step 1: Choose the encryption algorithm and mode
    private static final String algorithm = "AES";
    private static final String transformation = "AES/ECB/PKCS5Padding";

    public static String encryptURL(String url, String password) throws NoSuchAlgorithmException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        // Step 2: Derive a fixed-size key from the password
        byte[] keyBytes = generateKeyFromPassword(password);
        SecretKey secretKey = new SecretKeySpec(keyBytes, algorithm);

        // Step 3: Initialize a cipher object with the key and encryption mode
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Step 4: Encrypt the data using the cipher object
        byte[] encryptedBytes = cipher.doFinal(url.getBytes(StandardCharsets.UTF_8));
        String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);
        return encryptedBase64;
    }

    public static String decryptURL(String encryptedURL, String password) throws NoSuchAlgorithmException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        // Step 2: Derive a fixed-size key from the password
        byte[] keyBytes = generateKeyFromPassword(password);
        SecretKey secretKey = new SecretKeySpec(keyBytes, algorithm);

        // Step 3: Initialize a cipher object with the key and decryption mode
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Step 4: Decrypt the data using the cipher object
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedURL);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);
        return decryptedText;
    }

    private static byte[] generateKeyFromPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] keyBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return keyBytes;
    }
}
