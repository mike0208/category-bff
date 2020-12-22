package com.pccw.category.bff.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pccw.category.bff.dto.Category;
import com.pccw.category.bff.exception.CustomException;
import com.pccw.category.bff.service.CategoryService;

import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Validated
public class CategoryBffController {

	@Autowired
	private CategoryService categoryService;

	/* Controller method for creating productCategory object */
	@PostMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> createCategory(
			@ApiParam(value = "The ProductCategory to be created", required = true) @Valid @RequestBody Category category) {
		try {
			log.info("ProductOffering createProductCategory - bff ");
			Category categoryObject = categoryService.createCategory(category);
			return new ResponseEntity<>(categoryObject, HttpStatus.CREATED);
		} catch (CustomException e) {
			log.error(e.getDetails());
			throw e;
		}
	}

	/* Controller method for retrieving list of productCategory */
	@GetMapping(value = "/category")
	public ResponseEntity<String> listProductOffering(@RequestParam(required = false) Map<String, Object> reqParams) {
		try {
			String result = categoryService.listCategory(reqParams);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (CustomException e) {
			log.error(e.getDetails());
			throw e;
		}
	}

	/* Controller method for updating list of productCategory */
	@PatchMapping(value = "/category/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> patchCategory(
			@ApiParam(value = "Identifier of the ProductCategory", required = true) @PathVariable("id") String id,
			@ApiParam(value = "The ProductCategory to be updated", required = true) @Valid @RequestBody Category category) {
		try {
			Map<String, Object> pathParams = new HashMap<>();
			if (null != id) {
				log.info("ID is: " + id);
				pathParams.put("id", id);
			}
			log.info("Updating a product offering object for the given ID");
			Category categoryObject = categoryService.patchCategory(pathParams, category);
			return new ResponseEntity<>(categoryObject, HttpStatus.OK);
		} catch (CustomException e) {
			log.error(e.getDetails());
			throw e;
		}
	}

	/* Controller method for retrieving productOffering object by ID */
	@GetMapping(value = "/category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> retrieveProductOffering(
			@ApiParam(value = "Identifier of the ProductCategory", required = true) @PathVariable("id") String id,
			@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
		try {
			Map<String, Object> pathParams = new HashMap<>();
			if (null != id) {
				log.info("ID is: " + id);
				pathParams.put("id", id);
			}
			Map<String, Object> queryParams = new HashMap<>();
			if (null != fields) {
				log.info("Fields parameter is: " + fields);
				queryParams.put("fields", fields);
			}
			log.info("Retrieving a product Category object for the given ID");

			Category categoryObject = categoryService.retrieveCategorybyId(pathParams,
					queryParams);
			return new ResponseEntity<>(categoryObject, HttpStatus.OK);
		} catch (CustomException e) {
			log.error(e.getDetails());
			throw e;
		}
	}
	
}
