package com.GelatoPro3.Form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserForm
{
	private String prenom;

	private String nom;

	private String email;

	private String pwd;

	private String pays;
}
