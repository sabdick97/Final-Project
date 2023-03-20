package com.ems.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO extends UserDTO{
	private String adminName;
	private String adminEmail;
}
