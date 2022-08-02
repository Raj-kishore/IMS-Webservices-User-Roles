package com.naffal.ims.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.springframework.hateoas.Link;

@Entity
@Table(name = "Users", uniqueConstraints={@UniqueConstraint(columnNames={"user_name"})})
//@ApiModel(description="All details about the item") //visible in swagger http://localhost:9000/v2/api-docs  
public class User { // POJO class

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;

	@Column(name = "user_name")
	@Size(min = 2, message = "{validation.name.size.too_short}")
	@Size(max = 20, message = "{validation.name.size.too_long}")
	// @ApiModelProperty(notes="name should have 2 to 20 characters") //
	// http://localhost:9000/v2/api-docs
	private String userName;

	@Column(name = "user_role")
	private Integer userRole; // buyer, seller, admin : 0,1,2

	public User() { // no-arg constructor

	}

	public User(long userId,
			@Size(min = 2, message = "{validation.name.size.too_short}") @Size(max = 20, message = "{validation.name.size.too_long}") String userName,
			Integer userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userRole=" + userRole + "]";
	}

}
