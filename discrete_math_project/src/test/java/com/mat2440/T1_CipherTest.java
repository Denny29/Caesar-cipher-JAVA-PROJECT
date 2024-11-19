package com.mat2440;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.mat2440.cipher.Helper_Methods;

public class T1_CipherTest {

    @Test
    public void t1() {
        String cipher = "cat";
        int key = 23;
        String expected = "zxq";
        String actual = Helper_Methods.caesar(cipher, key);
        assertEquals(expected, actual);
    }

    @Test
    public void t2() {
        String cipher = "Testing testing 1, 2, 3. I like running test.";
        int key = 15;
        String expected = "Ithixcv ithixcv 1, 2, 3. X axzt gjccxcv ithi.";
        String actual = Helper_Methods.caesar(cipher, key);
        assertEquals(expected, actual);
    }

    @Test
    public void t3() {
        String cipher = "If he had anything confidential to say, he wrote it in cipher, that is, by so changing the order of the letters of the alphabet, that not a word could be made out.";
        int key = 7;
        String expected = "Pm ol ohk hufaopun jvumpkluaphs av zhf, ol dyval pa pu jpwoly, aoha pz, if zv johunpun aol vykly vm aol slaalyz vm aol hswohila, aoha uva h dvyk jvbsk il thkl vba.";
        String actual = Helper_Methods.caesar(cipher, key);
        assertEquals(expected, actual);
    }

    @Test
    public void t4() {
        String cipher = "I'm running out of ciphers to test. Uh random junk.";
        int key = 21;
        String expected = "D'h mpiidib jpo ja xdkczmn oj ozno. Pc mviyjh epif.";
        String actual = Helper_Methods.caesar(cipher, key);
        assertEquals(expected, actual);
    }
}
