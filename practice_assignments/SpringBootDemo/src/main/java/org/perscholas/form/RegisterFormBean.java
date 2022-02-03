package org.perscholas.form;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.perscholas.database.entity.User;
import org.perscholas.validation.EmailUnique;
import org.perscholas.validation.TwoFieldsAreEqual;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@TwoFieldsAreEqual(fieldOneName = "confirmPassword", fieldTwoName = "password", message = "Password and Conform Password must be the same.")
public class RegisterFormBean {

    private Integer id;

    @NotEmpty
    private String username;

    //@NotEmpty requires the value to be not null and also not empty ("")
    @NotEmpty(message = "Email is required")
    @Pattern(regexp = "^.+@.+$", message = "Email must match pattern")
//    @EmailUnique(message = "Email must be unique")
    private String email;

    @Length(min=1, max=25,
            message="First Name must be between 1 and 5 characters in length")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Length(min=1, max=25,
            message="Last Name must be between 1 and 5 characters in length")
    private String lastName;

//    @NotNull(message = "Age is required")
//    @Min(value = 18)
//    @Max(value = 100)
//    private Integer age;
    private String password;
    private String confirmPassword;

    private List<String> errorMessages = new ArrayList<>();

    private List<User> userList = new ArrayList<>();

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
