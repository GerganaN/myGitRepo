/*
 *
 * Gergana Nikolova Project
 */
package com.skrill.interns;

import java.util.ArrayList;
import java.util.List;

public class MyAccountParameters {

	public static List<String> unsupportedCountries = new ArrayList<String>();

	static {
		unsupportedCountries.add("Cuba");
		unsupportedCountries.add("Afghanistan");
		unsupportedCountries.add("Korea(North)");
		unsupportedCountries.add("Yemen");
		unsupportedCountries.add("Sudan");
		unsupportedCountries.add("Myamar");
	}

	public static final String URL_LOGIN = "https://my-integr.dev.moneybookers.net/signup";
	public static final String COUNTRY_DROPDOWN = "user_registration_address_country_id";
	public static final String CURRENCY_ID = "user_registration_account_currency_id";
	public static final String LANGUAGE = "user_registration_profile_language_id";
	public static final String BUSINESS_TYPE = "user_registration_type_business";
	public static final String EXPENSES_TYPE = "user_registration_purpose_expense";
	public static final String COMPANY_NAME = "user_registration_business_profile_data_company_name";
	public static final String LEGAL_FORM_DROPDOWN = "user_registration_business_profile_data_legal_form";
	public static final String REGISTRATION_ADDRESS1 = "user_registration_address_address_line_1";
	public static final String REGISTRATION_ADDRESS_CITY = "user_registration_address_city";
	public static final String REGISTRATION_POSTAL_CODE = "user_registration_address_postal_code";
	public static final String REGISTRATION_PROFILE_FIRST_NAME = "user_registration_profile_first_name";
	public static final String REGISTRATION_PROFILE_LAST_NAME = "user_registration_profile_last_name";
	public static final String COMPANY_POSITION_DROPDOWN = "user_registration_business_profile_data_representative_position_id";
	public static final String BIRTH_DATE_DROPDOWN = "user_registration_profile_birth_date_3i";
	public static final String BIRTH_MONTH_DROPDOWN = "user_registration_profile_birth_date_2i";
	public static final String BIRTH_YEAR_DROPDWON = "user_registration_profile_birth_date_1i";
	public static final String TELEPHONE_TYPE_DROPDOWN = "user_registration_address_phone_type";
	public static final String ADDRESS_PHONE_ID = "user_registration_address_phone_phone";
	public static final String BUTTON_NAME = "commit";
	public static final String EMAIL = "user_registration_email";
	public static final String PASSWORD = "user_registration_credentials_password";
	public static final String CONFIRM_PASSWORD = "user_registration_credentials_password_confirmation";
	public static final String RECAPTCHA_FIELD = "recaptcha_response_field";
	public static final String RECAPTCHA_FILL = "*(_)$skrill98712=";
	public static final String LOGIN_EMAIL_ID = "user_authentication_email";
	public static final String PASSWORD_AUTHECATION_ID = "user_authentication_password";

}
