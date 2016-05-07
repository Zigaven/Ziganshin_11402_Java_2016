package ru.kpfu.itis.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.form.ProfileForm;

import java.util.regex.Pattern;

/**
 * Created by ruslanzigansin on 07.05.16.
 */
public class PersonnelProfileFormValid implements Validator {
    static Pattern patternPhone = Pattern.compile("^(8|\\+7)?((\\d){7,10})$");


    @Override
    public boolean supports(Class<?> aClass) {
        return ProfileForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProfileForm form = (ProfileForm) o;

        if (!patternPhone.matcher(form.getPhone()).matches()){
            errors.rejectValue("phone", "", "Incorrect phone number");
        }

    }
}
