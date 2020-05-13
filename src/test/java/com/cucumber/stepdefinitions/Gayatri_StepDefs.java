package com.cucumber.stepdefinitions;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.cucumber.helper.UserActions;

public class Gayatri_StepDefs {

	private static Logger Log = Logger.getLogger(UserActions.class.getName());

	UserActions User;
	Hashtable<String,String> Data;

	public Gayatri_StepDefs(UserActions User) {
		this.User = User;
	}
}
