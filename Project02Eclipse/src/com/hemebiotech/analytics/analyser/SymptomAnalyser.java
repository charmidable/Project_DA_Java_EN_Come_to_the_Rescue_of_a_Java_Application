package com.hemebiotech.analytics.analyser;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Le programme traite une liste de symptome.
 * Le programme decompte et trie par ordre alphabetique le Stream de symptome dans une SortedMap.
 */
public class SymptomAnalyser implements ISymptomAnalyser
{
    /**
     * @param symptomList le Stream de symptom (String) trier a traiter.
     * @return contenant le nom des symptomes et le nombre de leurs occurences
     */
    public Map<String, Long> sortAndCount(final List<String> symptomList)
    {
        return symptomList.stream().collect(
                groupingBy
                        (
                                identity(),
                                TreeMap::new,
                                counting()
                        )
        );
    }
}