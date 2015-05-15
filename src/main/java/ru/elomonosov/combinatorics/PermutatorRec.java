package ru.elomonosov.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by n dd on 10.05.2015.
 */
public class PermutatorRec implements Permutator {

    private final char[] originalSet;

    public PermutatorRec(char[] set) {

        this.originalSet = set.clone();
    }


    @Override
    public List<String> permutate(int subsetSize, boolean withRepetitions) {

        PermutatorUtil.CheckSet(originalSet, subsetSize);

        if ((originalSet == null) || (originalSet.length == 0)) {
            return null;
        }

        if (withRepetitions) {
            return getPermutationWithRep(originalSet, subsetSize);
        } else {
            return getPermutationWithoutRep(originalSet, subsetSize);
        }
    }

    private List<String> getPermutationWithRep(char[] set, int size) {

        List<String> result;

        if (size == 1) {
            result = new ArrayList<String>(set.length);

            for (char ch : set) {
                result.add(String.valueOf(ch));
            }
        }
        else {
            int resultSize = (int) Math.pow(set.length,size);
            result = new ArrayList<String>(resultSize);

            List<String> strings = getPermutationWithRep(set, size - 1);

            for (char ch : set) {
                for (String str : strings) {
                    String string = String.valueOf(ch) + str;
                    result.add(string);
                }
            }
        }
        return result;
    }

    private List<String> getPermutationWithoutRep(char[] set, int size) {

        if (size > set.length) {
            throw new IllegalArgumentException("Set size must be more or equal to subset size");
        }

        List<String> result;

        if (size == 1) {
            result = new ArrayList<String>(set.length);
            for (char ch : set) {
                result.add(String.valueOf(ch));
            }
        }
        else {
            result = new ArrayList<String>(); // TODO add length
                for (char ch : set) {
                    char[] shortSet = PermutatorUtil.excludeElement(set, ch);
                    List<String> strings = getPermutationWithoutRep(shortSet, size - 1);
                    for (String str : strings) {
                        String string = String.valueOf(ch) + str;
                        result.add(string);
                    }
                }
        }
        return result;
    }
}
