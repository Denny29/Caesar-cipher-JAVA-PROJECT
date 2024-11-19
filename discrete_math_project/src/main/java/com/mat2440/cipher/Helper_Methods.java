package com.mat2440.cipher;

import java.util.HashMap;

public class Helper_Methods {

    /**
     * Helper Func to shift cipher {cipher} places to {direction}: left or right
     * 
     * @param cipher Cipher to be shifted
     * @param legend Key used to shift cipher
     * @return
     */
    public static String shiftCipher(String cipher, HashMap<Character, Character> legend) {
        char[] charArray = cipher.toCharArray();
        String encryptedCipher = "";
        // Iterate over the charArray using the legend to shift it
        for (Character c : charArray) {
            if (!Character.isLetter(c)) {
                encryptedCipher += c;
            } else {
                encryptedCipher += legend.get(c);
            }
        }
        return encryptedCipher;
    }

    /**
     * Fills the hashmap with the keys used for the ceaser cipher
     * 
     * @param legend  Hashmap containing the keys
     * @param key     Number of times each character should be shifted
     * @param encrypt True to shift words to left and encrypt, False to shift to the
     *                right and decrypt
     */
    public static HashMap<Character, Character> fillHashmap(HashMap<Character, Character> legend, int key,
            boolean encrypt) {
        // Fill the hashmap with the right keys.
        for (char upperCase = 'A', lowerCase = 'a'; upperCase != (char) 91; upperCase++, lowerCase++) {

            int upperShift;
            int lowerShift;

            if (encrypt) {
                // Shifts values to the right
                upperShift = (int) upperCase + key;
                lowerShift = (int) lowerCase + key;
                // If statements ensure the chars dont go over Z or z
                if ((int) upperShift > 90) {
                    upperShift -= 26;
                }

                if ((int) lowerShift > 122) {
                    lowerShift -= 26;
                }
            } else {
                // Shifts values to the left
                upperShift = (int) upperCase - key;
                lowerShift = (int) lowerCase - key;
                // If statements ensure the chars dont below A or a
                if ((int) upperShift < 65) {
                    upperShift += 26;
                }
                if ((int) lowerShift < 97) {
                    lowerShift += 26;
                }
            }

            legend.put(upperCase, (char) upperShift);
            legend.put(lowerCase, (char) lowerShift);
        }

        return legend;
    }

    /**
     * Returns a String with each character shifted {key} times to the right
     * EX: caesar("cat", 23) will return "Zxq"
     * 
     * @param cipher The cipher to be encrypted
     * @param key    The number of times each character is shifted
     * @return Returns the encrypted cipher
     */
    public static String caesar(String cipher, int key) {
        // Make a hashmap containing what each character should be
        HashMap<Character, Character> legend = new HashMap<Character, Character>();

        legend = fillHashmap(legend, key, true);
        return shiftCipher(cipher, legend);
    }

    /**
     * Decrypts the encrypted cipher using the same key but to the left
     * 
     * @param encryptedCipher The cipher encrypted using the caesar() method
     * @param shift           The number of times each character is shifted to the
     *                        right
     * @return Returns the decrypted cipher
     */
    public static String decryptCipher(String encryptedCipher, int key) {
        HashMap<Character, Character> legend = new HashMap<Character, Character>();
        legend = fillHashmap(legend, key, false);
        return shiftCipher(encryptedCipher, legend);
    }
}
