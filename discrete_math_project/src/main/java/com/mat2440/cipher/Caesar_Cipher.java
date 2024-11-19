package com.mat2440.cipher;

import java.util.Scanner;

public class Caesar_Cipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Input the String you want encrypted: ");
        String cipher = scan.nextLine();
        int key = 23;
        String encryptedCipher = Helper_Methods.caesar(cipher, key);
        System.out.println(encryptedCipher);

        System.out.println("Would you like to decrypt the cipher? (Y or N)");
        String input = scan.nextLine();

        if (input != "") {
            System.out.println(Helper_Methods.decryptCipher(encryptedCipher, key));
        }

        scan.close();
        // A = 65
        // Z = 90
        // a = 97
        // z = 122
    }
}
