package com.bank.validation;

import com.demo.exceptions.DemoAppException;

public class ProductValidation {
	
    // Prevent instantiation
    private ProductValidation() {
        throw new UnsupportedOperationException("Utility class");
    }


	/**
	 * Validates a general item name string.
	 * 
	 * @param itemName The string to validate.
	 * @throws IllegalArgumentException if the item name is null or blank.
	 */
	public static void validateProductName(String productName) {
		if (productName == null || productName.isBlank()) {
			throw new DemoAppException("Product name cannot be empty or blank.");
		}
	}

	/**
	 * Validates if a string ID can be converted to a Long.
	 * 
	 * @param idString The string ID to validate.
	 * @return The Long representation of the ID.
	 * @throws IllegalArgumentException if the ID string is not a valid number.
	 */
	public static Long parseAndValidateLongId(String idString) {
		try {
			return Long.valueOf(idString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid ID format. ID must be a valid number.");
		}
	}
}