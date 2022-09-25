package com.appgate.textanalysis.service.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Factory for retrieving a text analyzer based on an algorithm type. 
 * Each text analyzer must be a Component with a name specifying the 
 * algorithm type.
 * @author Fabio Berrio
 */
@Component
public class TextAnalyzerFactory {
	private final Logger logger = LoggerFactory.getLogger(TextAnalyzerFactory.class);
	
	@Autowired
    private ApplicationContext applicationContext;
	
	public TextAnalyzer getTextAnalyzer(String algorithmType) {
		if (algorithmType != null && !algorithmType.isEmpty()) {
			try {
				return applicationContext.getBean(algorithmType, TextAnalyzer.class);
			} catch (NoSuchBeanDefinitionException ex) {
				logger.error(ex.getMessage(), ex);
			}
		}
		return null;
	}
	
}
