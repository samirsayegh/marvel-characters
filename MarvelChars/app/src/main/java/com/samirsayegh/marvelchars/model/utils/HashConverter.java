package com.samirsayegh.marvelchars.model.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class HashConverter {

    private static final String MD5 = "MD5";

    /**
     * Convert a string to MD5
     * @param text the text to be converted
     * @return an MD5 string
     */
    public static String toMD5(String text) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MD5);
            messageDigest.update(text.getBytes());
            byte[] messageDigestBytes = messageDigest.digest();
            StringBuilder hexadecimalString = new StringBuilder();
            for (byte messageDigestByte : messageDigestBytes) {
                String toConcat = Integer.toHexString(0xFF & messageDigestByte);
                while (toConcat.length() < 2) {
                    toConcat = "0" + toConcat;
                }
                hexadecimalString.append(toConcat);
            }

            return hexadecimalString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
