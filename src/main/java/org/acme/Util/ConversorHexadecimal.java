package org.acme.Util;

import java.math.BigInteger;

public class ConversorHexadecimal {
    
    public static String stringParaHexadecimal(String minhaString) {
        // Convertendo a string para um array de bytes
        byte[] bytes = minhaString.getBytes();
        
        // Convertendo o array de bytes para um número hexadecimal (BigInteger)
        BigInteger bigInteger = new BigInteger(1, bytes);
        
        // Convertendo o número hexadecimal para uma string hexadecimal
        String hexString = bigInteger.toString(16);
        
        return hexString;
    }
}

