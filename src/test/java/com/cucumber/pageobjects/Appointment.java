package com.cucumber.pageobjects;

import org.openqa.selenium.By;

import com.cucumber.helper.ObjectHelper;

public class Appointment  extends ObjectHelper{
	//Appointment
			public static final By appointmentButton=Button_By_Text("Appointment ");
			public static final By scheduleAppointLink=Select_Link_By_LinkText("/appointment/create");
			public static final By clickOnCalendar=Click_By_Class("fa fa-calendar");//(//*[.='Today'])[6]
			public static final By selectdate=Select_Date_Below_Label_Xpath("Today");
			public static final By selectLocation =InputBox_Below_Label_Xpath("Pick a location:");
			public static final By notes =InputBox_Below_Label_Xpath("Notes:");
			public static final By submitShedulintButton=Button_By_Text("Submit Scheduling");
			public static final By confirmBtn = Button_By_Text("Confirm");
			public static final By signUpButton = Button_By_Text("Sign up!");
}
