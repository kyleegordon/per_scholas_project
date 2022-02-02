package org.perscholas.validation;

import org.apache.commons.lang3.StringUtils;
import org.perscholas.database.dao.UserDAO;
import org.perscholas.database.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//this lets you create custom validation requirements
public class EmailUniqueImpl implements ConstraintValidator<EmailUnique, String> {

    @Autowired
    private UserDAO userDAO;

    public static final Logger LOG = LoggerFactory.getLogger(EmailUniqueImpl.class);

    @Override
    public void initialize(EmailUnique constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (StringUtils.isEmpty(value)){
            return true;
        }
        //if email = "a@b.com", it will trigger the error message to be displayed
        //in the future you can use this to check if username already exists in a database
//        return (!StringUtils.equals(value, "a@b.com"));

        User user = null; //finish this line of code to check if user already exists

        return (user == null);
    }
}
