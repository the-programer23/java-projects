package com.fabianpinzon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {
    private Utilities util;

   @org.junit.jupiter.api.BeforeEach
   void setup(){
       util = new Utilities();
   }

    @org.junit.jupiter.api.Test
    void everyNthChat() {
        assertArrayEquals("el".toCharArray(), util.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 2));
        assertArrayEquals("ball".toCharArray(), util.everyNthChar("ball".toCharArray(), 6));
    }

    @org.junit.jupiter.api.Test
    void removePairs() {
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        assertEquals("AB", util.removePairs("AB"));
        assertNull(null, util.removePairs(null));
    }

    @org.junit.jupiter.api.Test
    void converter() {
        assertEquals(300, util.converter(10, 5));

        assertThrows(
                ArithmeticException.class,
                () -> {
                    util.converter(10, 0);
                    fail("Should have thrown ArithmeticException");
                }
        );
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        assertEquals("moon", util.nullIfOddLength("moon"));
        assertNotNull(util.nullIfOddLength("even"));
        assertNull(util.nullIfOddLength("plate"));
    }

    @ParameterizedTest
    @MethodSource("testCollections")
    void removePairs2(String source, String expected){
        assertEquals(expected, util.removePairs(source));
    }

    public static Collection<Object[]> testCollections(){
        return Arrays.asList(new Object[][]{
                {"ABCDEFF", "ABCDEF"},
                {"AB88EFFG", "AB8EFG"},
                {"112233445566", "123456"},
                {"ZYZQQB", "ZYZQB"},
                {"A", "A"}
        });
    }
}