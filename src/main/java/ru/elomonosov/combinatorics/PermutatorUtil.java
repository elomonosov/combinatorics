package ru.elomonosov.combinatorics;

/**
 * Created by n dd on 10.05.2015.
 */
public class PermutatorUtil {

    public static void CheckSet(char[] set, int subsetSize) {

        if (subsetSize <= 0) {
            throw new IllegalArgumentException("Subset size must be more than 0");
        }

        int uniqueCheck = checkForUniqueElements(set);
        if (uniqueCheck != -1) {
            throw new IllegalArgumentException("Set must contains unique elements only. Element '" + set[uniqueCheck] + "' is not unique.");
        }
    }

    private static int checkForUniqueElements(char[] chars) {

        for(int i = 0; i < chars.length;i++) {
            char ch = chars[i];

            for (int k = i + 1; k < chars.length;k++) {
                char tch = chars[k];
                if (ch == tch) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static char[] excludeElement(char[] chars, char element) {
        char[] result = new char[chars.length-1];

        int k = 0;
        for (char ch : chars) {
            if (ch != element) {
                result[k] = ch;
                k++;
            }
        }
        return result;
    }
}
