package com.cucumber.stepdefinitions;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.cucumber.helper.UserActions;

public class Shambhu_StepDefs {

	private static Logger Log = Logger.getLogger(UserActions.class.getName());

	UserActions User;
	Hashtable<String,String> Data;

	public Shambhu_StepDefs(UserActions User) {
		this.User = User;
	}
}
