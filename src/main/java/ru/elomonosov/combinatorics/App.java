package ru.elomonosov.combinatorics;


import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import java.util.ArrayList;
import java.util.List;

public class App
{

    private static final ICombinatoricsVector<String> originalVector = Factory.createVector(new String[]{"A", "B", "C"});


    public static void main( String[] args )
    {
        char[] set = {'A','B','C','D','E'};
        int subsetSize = 12;

        Permutator permutatorIter = new PermutatorIter(set);
        long iterTime1 = System.nanoTime();
        List<String> permutationsListIter = permutatorIter.permutate(subsetSize, true);
        long iterTime2 = System.nanoTime();
        long resIterTime = iterTime2 - iterTime1;

        /*Permutator permutatorRec = new PermutatorRec(set);
        long RecTime1 = System.nanoTime();
        List<String> permutationsListRec = permutatorRec.permutate(subsetSize, true);
        long RecTime2 = System.nanoTime();
        long resRecTime = RecTime2 - RecTime1;*/

        /*for (String str : permutationsList) {
            System.out.println(str);
        }*/

        /*if (resIterTime > resRecTime) {
            long diff = resIterTime-resRecTime;
            System.out.println("Recursion is better by " + diff / (resIterTime / 100d)  + "%");
        } else {
            long diff = resRecTime-resIterTime;
            System.out.println("Ieration is better by " + diff / (resRecTime / 100d)  + "%");
        }*/

        /*long time1 = System.nanoTime();
        generateWords(5);
        long time2 = System.nanoTime();

        long time3 = time2-time1;

        System.out.println("iter: " + resIterTime);
        System.out.println("rec: "+ resRecTime);
        System.out.println("google: " + time3);*/

        System.out.println("Size: " + permutationsListIter.size());
        System.out.println(resIterTime / 1_000_000_000d + " sec");


    }

    private static List<String> generateWords (int length) {
        Generator<String> gen = Factory.createPermutationWithRepetitionGenerator(originalVector, length);

        List<String> result = new ArrayList<>(length*3);
        for (ICombinatoricsVector<String> perm : gen) {
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < length; i++) {
                word.append(perm.getValue(i));
            }
            result.add(word.toString());
        }
        return result;
    }
}
