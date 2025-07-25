package com.bank.validation;

import com.demo.exceptions.DemoAppException;

public class BranchValidation {
	
    // Prevent instantiation
    private BranchValidation() {
        throw new UnsupportedOperationException("Utility class");
    }

	/**
	 * Validates a general item name string.
	 * 
	 * @param itemName The string to validate.
	 * @throws IllegalArgumentException if the item name is null or blank.
	 */
	public static void validateBranchName(String branchName) {
		if (branchName == null || branchName.isBlank()) {
			throw new DemoAppException("Branch name cannot be empty or blank.");
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