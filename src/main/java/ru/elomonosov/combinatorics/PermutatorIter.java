package ru.elomonosov.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by n dd on 10.05.2015.
 */
public class PermutatorIter implements Permutator{

    private final char[] originalSet;

    public PermutatorIter(char[] set) {

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
        int setLength = set.length;

        if (size == 1) {
            result = new ArrayList<String>(set.length);

            for (char ch : set) {
                result.add(String.valueOf(ch));
            }
        }
        else {
            int resultSize = (int) Math.pow(setLength,size);
            result = new ArrayList<String>(resultSize);

            int[] counters = new int[size];

            for (int i = 0; i < resultSize;i++) {
                char[] string = new char[size];
                for (int k = 0; k < size; k++) {
                    string[k] = set[counters[k]];
                }
                result.add(new String(string));
                counters = incCounters(counters, setLength-1);
            }
        }
        return result;
    }

    private List<String> getPermutationWithoutRep(char[] set, int size) {
        return null;
    }

    private int[] incCounters (int[] counters, int maxValue) {

        int[] result = counters.clone();

        int cLength = result.length;
        if (result[cLength-1] < maxValue) {
            result[cLength-1]++;
            return result;
        }

        for (int i = cLength - 1; i >= 0;i--) {
            if (result[i] != maxValue) {
                result[i]++;
                break;
            } else {
                result[i]=0;
            }
        }
        return result;
    }
}
