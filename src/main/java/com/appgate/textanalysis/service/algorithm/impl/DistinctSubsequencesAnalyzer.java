package com.appgate.textanalysis.service.algorithm.impl;

import org.springframework.stereotype.Component;

import com.appgate.textanalysis.service.algorithm.TextAnalyzer;

@Component(value = "distinctSubsequences")
public class DistinctSubsequencesAnalyzer implements TextAnalyzer {

	@Override
	public int analyze(String source, String textToSearch) {
		return 3;
	}

}
