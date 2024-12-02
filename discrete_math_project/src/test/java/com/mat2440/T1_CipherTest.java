package com.mat2440;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.mat2440.cipher.Helper_Methods;

public class T1_CipherTest {

    @ParameterizedTest
    @CsvSource(value = {
            "cat:zxq:23",
            "Testing testing 1, 2, 3. I like running tests.:Ithixcv ithixcv 1, 2, 3. X axzt gjccxcv ithih.:15",
            "If he had anything confidential to say, he wrote it in cipher, that is, by so changing the order of the letters of the alphabet, that not a word could be made out.:Pm ol ohk hufaopun jvumpkluaphs av zhf, ol dyval pa pu jpwoly, aoha pz, if zv johunpun aol vykly vm aol slaalyz vm aol hswohila, aoha uva h dvyk jvbsk il thkl vba.:7",
            "I'm running out of ciphers to test. Uh random junk.:D'h mpiidib jpo ja xdkczmn oj ozno. Pc mviyjh epif.:21"
    }, delimiter = ':')

    @Test
    @DisplayName("Ceaser Cipher Testing")
    public void t1(String phrase, String expectedString, int key) {
        String actual = Helper_Methods.caesar(phrase, key);
        assertEquals(expectedString, actual);
    }

    @Test
    @DisplayName("Decrypt Cipher")
    public void t5() {
        String cipher = "I almost forgot to show the decrypt method. I promise I'm not just comparing the cipher variable to itself...";
        int key = 21;

        // To decrypt just run the decrypt method with the same key
        String encryptedCipher = Helper_Methods.caesar(cipher, key);
        String decryptedCipher = Helper_Methods.decryptCipher(encryptedCipher, key);
        assertEquals(cipher, decryptedCipher);
    }
}
