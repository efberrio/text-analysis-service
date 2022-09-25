package com.appgate.textanalysis.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JPA entity for TextAlgorithm.
 * @author Fabio Berrio
 */
@Entity
@Data
@NoArgsConstructor
public class TextAlgorithm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 20)
	private String code;
	@Column(nullable = false, length = 30)
	private String name;
	@Column(nullable = false, length = 1)
	private String state;
}
