package com.tony.bo;

public interface Validations {

	String secondCheck(String errorMessage, String regex1, String fNameString, String lNameString, String mNameString);

	String firstCheck(String errorMessage, String fNameString, String lNameString);

	boolean contentCheck(String mNameString, String regex);

	boolean firstCharacterCheck(String fNameString);

	boolean nameLength(String fNameString);

	boolean isBlank(String fNameString);

	String fifthCheck(String errorString, String regex, String stateString, String countryString, String phoneString);

	String fourthCheck(String errorString, String addressString, String cityString);

	boolean phoneLength(String phoneString);

}