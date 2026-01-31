package com.javarevisao.exercicios.strings;

class Solution_744 {
    public static void main(String[] args) {
        char[] letters = {'b', 'b', 'x', 'd', 'c'};
        System.out.println(nextGreatestLetter(letters, 'l'));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        char smallestGreater = letters[0];
        int index = 0;
        boolean notFound = true;

        while (notFound && (index < letters.length)) {
            if ((int) letters[index] > (int) target) {
                smallestGreater = letters[index];
                notFound = false;
            }
            index++;
        }

        return smallestGreater;
    }
}
