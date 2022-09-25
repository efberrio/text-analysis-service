package com.appgate.textanalysis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.appgate.textanalysis.data.dto.TextAlgorithmDTO;
import com.appgate.textanalysis.data.enumeration.StateEnum;
import com.appgate.textanalysis.service.TextAnalysisService;

@SpringBootApplication
public class TextAnalysisServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TextAnalysisServiceApplication.class, args);
	}

	/**
	 * Add text analysis algorithms for dev and integrationtest profiles.
	 * @param service
	 * @return
	 */
	@Bean
	@Profile(value = {"dev", "integrationtest"})
    public CommandLineRunner sampleData(TextAnalysisService service) {
        return (args) -> {
        	service.addTextAlgorithm(new TextAlgorithmDTO("distinctSubsequences", "Distinct Subsequences", StateEnum.ACTIVE));
        };
    }
}
