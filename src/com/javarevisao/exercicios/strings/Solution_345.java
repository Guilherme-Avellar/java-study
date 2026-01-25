package com.javarevisao.exercicios.strings;

// 345. Reverse Vowels of a String

class Solution_345 {
    public static void main(String[] args) {
        System.out.println(reverseVowels("ai"));
    }

    private static String reverseVowels(String s) {
        char[] sChar = s.toCharArray();
        char aux;
        int i = 0, j = sChar.length-1 ;

        while (i < j) {
            if (isVowel(sChar[i]) && isVowel(sChar[j])) {
                aux = sChar[i];
                sChar[i] = sChar[j];
                sChar[j] = aux;
                i++; j--;
            }
            if (!isVowel(sChar[i])) i++;
            if (!isVowel(sChar[j])) j--;
        }

        return new String(sChar);
    }

    private static boolean isVowel (char c) {
        if (c >= 97) c = (char) (c - 32);

        return switch (c) {
            case 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }
}
