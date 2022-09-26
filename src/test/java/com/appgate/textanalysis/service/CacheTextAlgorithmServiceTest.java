package com.appgate.textanalysis.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.appgate.textanalysis.data.dto.TextAlgorithmDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("integrationtest")
class CacheTextAlgorithmServiceTest {

	@Autowired
	private CacheTextAlgorithmService cacheTextAlgorithmService;
	
	@Test
	public void givenValidAlgorithmCode_whenGetTextAlgorithm_thenReturnTextAlgorithm() throws Exception {
		String algorithmCode = "distinctSubsequences";
		TextAlgorithmDTO textAlgorithmDTO = cacheTextAlgorithmService.getTextAlgorithmByCode(algorithmCode);
		assertNotNull(textAlgorithmDTO);
		assertNotNull(textAlgorithmDTO.getCode());
		assertNotNull(textAlgorithmDTO.getName());
	}

	@Test
	public void givenInvalidAlgorithmCode_whenGetTextAlgorithm_thenReturnNoTextAlgorithm() throws Exception {
		String algorithmCode = "invalid";
		TextAlgorithmDTO textAlgorithmDTO = cacheTextAlgorithmService.getTextAlgorithmByCode(algorithmCode);
		assertNotNull(textAlgorithmDTO);
		assertNull(textAlgorithmDTO.getCode());
		assertNull(textAlgorithmDTO.getName());
	}

	@Test
	public void givenNoParameters_whenResetCache_thenReturnOK() throws Exception {
		cacheTextAlgorithmService.resetCache();
		assertTrue(true);
	}

}
