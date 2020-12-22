package com.pccw.category.bff.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;



import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String id = null;

	private String href = null;

	private String description = null;

	private Boolean isRoot = null;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime lastUpdate = null;

	private String lifecycleStatus = null;

	private String name = null;

	private String parentId = null;

	private String version = null;

	private List<ProductOfferingRef> productOffering = null;

	private List<CategoryRef> subCategory = null;

	private TimePeriod validFor = null;

	private String baseType = null;

	private String schemaLocation = null;

	private String type = null;
}
