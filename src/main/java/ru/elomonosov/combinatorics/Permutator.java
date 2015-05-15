package ru.elomonosov.combinatorics;

import java.util.List;

/**
 * Created by n dd on 10.05.2015.
 */
public interface Permutator {

    List<String> permutate(int subsetSize, boolean withRepetitions);
}
