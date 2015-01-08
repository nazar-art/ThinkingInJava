package courses.procedural.util;

import java.util.ArrayList;

public class PermutationGenerator {
    private String word;

    public PermutationGenerator(String aWord) {
        word = aWord;
    }

    public ArrayList<String> getPermutations() {
        ArrayList<String> permutations = new ArrayList<>();

        // The empty string has a single permutation: itself
        if (word.length() == 0) {
            permutations.add(word);
            return permutations;
        }

        for (int i = 0; i < word.length(); i++) {
            // Form a simpler word by removing the ith character
            String shorterWord = word.substring(0, i) + word.substring(i + 1);

            // Generate all permutations of the simpler word
            PermutationGenerator shorterPermutationGenerator = new PermutationGenerator(shorterWord);
            ArrayList<String> shorterWordPermutations = shorterPermutationGenerator.getPermutations();

            // Add the removed character to the front of
            // each permutation of the simpler word,
            for (String s : shorterWordPermutations) {
                permutations.add(word.charAt(i) + s);
            }
        }
        // Return all permutations
        return permutations;
    }

    public static ArrayList<String> permute(String string) {
        ArrayList<String> permutations = new ArrayList<>();

        if (string.length() == 0) {
            permutations.add(string);
            return permutations;
        }

        for (int i = 0; i < string.length(); i++) {
            String shorterWord = string.substring(0, i) + string.substring(i + 1);

            ArrayList<String> shorterWordPermutations = permute(shorterWord);

            for (String s : shorterWordPermutations) {
                permutations.add(string.charAt(i) + s);
            }
        }
        return permutations;
    }
}