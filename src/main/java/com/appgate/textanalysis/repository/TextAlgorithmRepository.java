package com.appgate.textanalysis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appgate.textanalysis.data.entity.TextAlgorithm;

/**
 * JPA repository for TextAlgorithm.
 * @author Fabio Berrio
 */
@Repository
public interface TextAlgorithmRepository extends JpaRepository<TextAlgorithm, Long> {
	TextAlgorithm findByCode(String code);
	List<TextAlgorithm> findByState(String state);
}
