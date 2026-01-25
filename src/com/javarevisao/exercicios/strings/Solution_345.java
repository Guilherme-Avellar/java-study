package com.javarevisao.exercicios.strings;

//345. Reverse Vowels of a String

class Solution_345 {
    public static void main(String[] args) {
    }
    public String reverseVowels(String s) {
        StringBuilder sBuilder = new StringBuilder(s);
        int i = 0, j = s.length()-1 ;
        while (i < j) {
            if (isVowel(s.charAt(i)) && isVowel(s.charAt(j))) {
                sBuilder.setCharAt(i, s.charAt(j));
                sBuilder.setCharAt(j, s.charAt(i));
                i++; j--;
            }
            if (!isVowel(s.charAt(i))) i++;
            if (!isVowel(s.charAt(j))) j--;
        }
        return sBuilder.toString();
    }
    private boolean isVowel (char c) {
        if ((int) c >= 97)
            c = (char) (c - 32);
        return switch (c) {
            case 65, 69, 73, 79, 85 -> true;
            default -> false;
        };
    }
}
