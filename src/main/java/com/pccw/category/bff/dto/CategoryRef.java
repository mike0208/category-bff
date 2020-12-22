package com.pccw.category.bff.dto;

import java.io.Serializable;



import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class CategoryRef implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id = null;

	
	private String href = null;

	private String name = null;

	private String version = null;

	private String baseType = null;

	private String schemaLocation = null;

	private String type = null;

	private String referredType = null;
}
