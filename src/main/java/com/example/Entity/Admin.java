package com.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="Admin_Data")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminId;
	
	
	@NotBlank(message = "Name Should not be Blank")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name should contain only letters")
	private String firstName;
	
	@NotBlank(message = "Name Should not be Blank")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name should contain only letters")
	private String lastName;
	
	@Email(message = "Please enter a valid email address")
	private String email;
	
	
//	@NotBlank(message = "Name Should not be Blank")
//	@NotNull(message ="Username Should not be NUll")
	@Size(min=6, message="Length Should be 6 or Above")
	@Pattern(regexp ="^Admin(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{7,}$", message = "Type Correct pattern")
	private String adminname;
	
	@NotBlank(message = "Name Should not be Blank")
	@NotNull(message ="Password Should not be NUll")
	@Pattern(regexp ="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,}$",
	message = " InCorrect pattern")
	private String password;
	
	public Admin() {}

	public Admin(int adminId,
			@NotBlank(message = "Name Should not be Blank") @Pattern(regexp = "^[a-zA-Z]+$", message = "Name should contain only letters") String firstName,
			@NotBlank(message = "Name Should not be Blank") @Pattern(regexp = "^[a-zA-Z]+$", message = "Name should contain only letters") String lastName,
			@Email(message = "Please enter a valid email address") String email,
			@Size(min = 6, message = "Length Should be 6 or Above") @Pattern(regexp = "^Admin(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{7,}$", message = "Type Correct pattern") String adminname,
			@NotBlank(message = "Name Should not be Blank") @NotNull(message = "Password Should not be NUll") @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,}$", message = " InCorrect pattern") String password) {
		
		this.adminId = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.adminname = adminname;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", adminname=" + adminname + ", password=" + password + "]";
	}

}
	
