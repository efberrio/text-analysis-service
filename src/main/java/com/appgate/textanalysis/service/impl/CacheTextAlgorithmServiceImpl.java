package com.appgate.textanalysis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.appgate.textanalysis.data.dto.TextAlgorithmDTO;
import com.appgate.textanalysis.data.factory.TextAlgorithmFactory;
import com.appgate.textanalysis.repository.TextAlgorithmRepository;
import com.appgate.textanalysis.service.CacheTextAlgorithmService;

/**
 * Service implementation for caching text algorithm definitions.
 * @author Fabio Berrio
 */
@Service
public class CacheTextAlgorithmServiceImpl implements CacheTextAlgorithmService {
	
	@Autowired
	TextAlgorithmRepository textAlgorithmRepository;
	
	@Override
	@Cacheable("textAlgorithmByCode")
	public TextAlgorithmDTO getTextAlgorithmByCode(String code) {
		return TextAlgorithmFactory.convertEntityToDTO(textAlgorithmRepository.findByCode(code));
	}

	@Override
	@CacheEvict(value = "textAlgorithmByCode", allEntries = true)
	public void resetCache() {
	}

}
