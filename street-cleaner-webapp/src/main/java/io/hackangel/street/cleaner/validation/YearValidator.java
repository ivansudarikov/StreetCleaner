package io.hackangel.street.cleaner.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by amylniko on 26.07.2016.
 */
@Component (value = "yearValidator")
public class YearValidator implements Validator {

    private final String INVALID_YEAR_FORMAT = "Invalid year format";

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(!(o instanceof String)) {
            errors.reject(INVALID_YEAR_FORMAT);
        }
    }
}
