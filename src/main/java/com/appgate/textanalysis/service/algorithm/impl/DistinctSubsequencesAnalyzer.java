package com.appgate.textanalysis.service.algorithm.impl;

import org.springframework.stereotype.Component;

import com.appgate.textanalysis.data.dto.TextCriteriaDTO;
import com.appgate.textanalysis.service.algorithm.TextAnalyzer;

/**
 * Implementation of Distinct Subsequences algorithm.
 * @author Fabio Berrio
 */
@Component(value = "distinctSubsequences")
public class DistinctSubsequencesAnalyzer implements TextAnalyzer {

	@Override
	public int analyze(TextCriteriaDTO textCriteriaDTO) {
		// Uses Dynamic Programming to optimize memory and traversal
		String source = textCriteriaDTO.getSource();
		String textToSearch = textCriteriaDTO.getTextToSearch();
		int sourceLength = source.length();
		int queryLength = textToSearch.length();
		
		int[] previous = new int[queryLength + 1];
		previous[0] = 1;
		for (int i = 1; i <= sourceLength; i++) {
			for (int j = queryLength; j >= 1; j--) {
				if (source.charAt(i - 1) == textToSearch.charAt(j - 1)) {
					previous[j] += previous[j - 1];
				}

			}
		}
		return previous[queryLength];
	}

}
