package ch.tagcloud.www.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.tagcloud.www.model.User;
import ch.tagcloud.www.service.UserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "validate.notempty");
        if (user.getMail().length() < 6 || user.getMail().length() > 160) {
            errors.rejectValue("mail", "validation.userform.mail.lenght");
        } 
        if (userService.findByMail(user.getMail()) != null) {
            errors.rejectValue("mail", "validation.userform.mail.duplicate");
        } 

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validate.notempty");
        if (user.getPassword().length() < 4 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "validation.userform.password.length");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "validation.userForm.password.confirm");
        } 
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salutation", "validate.notempty");
        if (user.getSalutation().length() < 4 || user.getSalutation().length() > 4) {
            errors.rejectValue("salutation", "validation.userform.salutation.length");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "validate.notempty");
        if (user.getFirstName().length() > 80) {
            errors.rejectValue("firstName", "validation.userform.firstName.length");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "validate.notempty");
        if (user.getLastName().length() > 80) {
            errors.rejectValue("lastName", "validation.userform.LastName.length");
        }
    }
}