package com.appgate.textanalysis.service;

import com.appgate.textanalysis.data.dto.TextAlgorithmDTO;

/**
 * Service interface for caching text algorithm definitions.
 * @author Fabio Berrio
 */
public interface CacheTextAlgorithmService {
	
	/**
	 * Get a text algorithm by code.
	 * @param code
	 * @return
	 */
	TextAlgorithmDTO getTextAlgorithmByCode(String code);
	
	/**
	 * Reset the cache.
	 */
	void resetCache();
	
}
