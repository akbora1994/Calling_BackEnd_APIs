package com.masai.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;

	    @NotNull(message = "Username cannot be empty")
		@Pattern(regexp="[a-zA-Z]{3,12}", message = "Username should consist of 3 to 12 letters and must not include numbers or special characters")
	    private String username;
	    
	    @Email
	    private String email;
	    
	    @NotNull(message = "Password cannot be empty")
		@Pattern(regexp="[a-zA-Z0-9]{6,12}",message="Password must be 6 to 12 characters long and include both uppercase and lowercase alphanumeric characters.")
	    private String password;
}
