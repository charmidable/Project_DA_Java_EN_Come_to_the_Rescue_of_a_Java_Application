package com.hemebiotech.analytics.analyser;

import java.util.List;
import java.util.Map;

public interface ISymptomAnalyser
{
    Map<String, Long> sortAndCount(final List<String> symptomStream);
}
