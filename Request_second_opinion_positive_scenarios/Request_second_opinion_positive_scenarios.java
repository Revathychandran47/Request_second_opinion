package Request_second_opinion_positive_scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Request_second_opinion_positive_scenarios extends Generic_function {
	static boolean value;
	static String text,month,year,monthval,yearval,te;
	static WebElement fr,fr1,element,ele;

	/*Browser opens and user is on home page*/ 	
	@When("User is on home page")
	public static void user_on_homepage() throws Exception{
		try {
			Browser_Launch();
			click("welcome_login");
			driver.findElement(By.xpath(OR_reader("Object_Locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "login_password"))).sendKeys(td_reader("login_password",7));
			click("login");
			browser_wait(20);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/* TC_001 -Validate that user must be able to view 'Request for a second opinion' under Home page */
	@Then("User should redirect to Request a Second Opinion page when clicking on Request a Second Opinion button")
	public static void request_second_opinion_positive_tc_001() throws Exception {
		try {
			click("request_second_opinion_button");
			browser_wait(20);
			click("create_new_case");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "request_second_opinion"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_positive_tc_001");
		}	
	}

	/* TC_002 -Validate that user must be able to view the texts on the landing page */
	@Then("User should be able to view texts on the page")
	public static void request_second_opinion_positive_tc_002() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "your_price_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(2);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "who_is_this_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(2);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "you_are_about_to_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_positive_tc_002");
		}	
	}

	/* TC_003 -Validate that user can able to view  box  with  additional information at the bottom of page */
	@Then("User should be able to view the informations")
	public static void request_second_opinion_positive_tc_003() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "if_you_need_help_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(2);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "mail_id_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(2);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "phone_number_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(2);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "for_more_info_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_positive_tc_003");
		}	
	}

	/* TC_004 -Validate that the user should navigated to "Upload Scans " page when "Proceed" button is clicked */
	@Then("User should be navigated to Upload Scans page by clicking proceed button")
	public static void request_second_opinion_positive_tc_004() throws Exception {
		try {
			click("agree_to_docpanel_checkbox");
			browser_wait(10);
			click("proceed_button");
			Thread.sleep(8000);
			fr= driver.findElement(By.xpath(OR_reader("Object_Locator","outer_frame")));
			driver.switchTo().frame(fr);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "upload_scans_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(30);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_positive_tc_004");
		}	
	}

	/* TC_005 -Validate that user should be able to view the bar with Upload Scans as green color at the top of the page and links are working or not */
	@Then("User should be able to view the bar and links")
	public static void request_second_opinion_positive_tc_005() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "upload_scans_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click_javascript("how_do_upload_link");
			browser_wait(30);
			click_javascript("close_button");
			browser_wait(30);
			click_javascript("don’t_have_scans_link");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "don’t_have_scans_ok"))).isDisplayed();
			Assert.assertEquals(true,value);
			click_javascript("don’t_have_scans_ok");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_positive_tc_005");
		}	
	}

	/* TC_006 -Validate that the user should be able to upload scans by clicking on Upload my scans button*/
	@Then("User should be able to upload folder from the system")
	public static void request_second_opinion_positive_tc_006() throws Exception {
		try {
			click_javascript("upload_scans_button");
			Thread.sleep(4000);
			fr1= driver.findElement(By.xpath(OR_reader("Object_Locator","inner_frame")));
			driver.switchTo().frame(fr1);
			Thread.sleep(2000);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "choose_file_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(20);
			driver.findElement(By.xpath(OR_reader("Object_Locator", "choose_file_button"))).sendKeys(td_reader("scans"));
			browser_wait(20);
			driver.switchTo().defaultContent();
			fr= driver.findElement(By.xpath(OR_reader("Object_Locator","outer_frame")));
			driver.switchTo().frame(fr);
			click_javascript("upload_scan_close_button");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_positive_tc_006");
		}
	}

	/* TC_007 -Validate that the user should be able to upload reports by clicking on Upload my reports button*/
	@Then("User should be able to upload file from the system")
	public static void request_second_opinion_positive_tc_007() throws Exception {
		try {
			browser_wait(30);
			driver.findElement(By.xpath(OR_reader("Object_Locator", "upload_report_button"))).sendKeys(td_reader("report"));
			Thread.sleep(3000);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "uploaded_report"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(5);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_positive_tc_007");
		}
	}

	/* TC_008 -Validate that the user should be able to view the dialogue box when I do not have a doctor's report checkbox*/
	@Then("User should be able to view the Upload scans page")
	public static void request_second_opinion_positive_tc_008() throws Exception {
		try {
			browser_wait(20);
			click_javascript("don’t_have_doctors_checkbox");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "upload_report"))).isDisplayed();
			Assert.assertEquals(true,value);
			click_javascript("upload_report");
			click_javascript("don’t_have_doctors_checkbox");
			click_javascript("don’t_have_doctors_checkbox");
			click_javascript("i_dont_have_it");
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "don’t_have_doctors_checkbox"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_positive_tc_008");
		}
	}

	/* TC_009 -Validate that the user should navigated to "Upload Scans" page by checking "Other " check box and by entering details.*/
	@Then("User should be navigated to upload scans page")
	public static void request_second_opinion_positive_tc_009() throws Exception {
		try {
			browser_back();
			click("create_new_case");
			click("other_checkbox");
			browser_wait(2);
			driver.findElement(By.xpath(OR_reader("Object_Locator", "patient_first_name"))).sendKeys(td_reader("patient_first_name"));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "patient_last_name"))).sendKeys(td_reader("patient_last_name"));
			click("patient_dob");
			te= driver.findElement(By.xpath(OR_reader("Object_Locator", "dob_month_year"))).getText();
			month = te.split(" ")[0].trim();
			year = te.split(" ")[1].trim();
			monthval=td_reader("dob_month");
			yearval=td_reader("dob_year");
			while(!(month.equals(monthval)&& year.equals(yearval)))
			{
				click("left_arrow");
				te= driver.findElement(By.xpath(OR_reader("Object_Locator", "dob_month_year"))).getText();
				month = te.split(" ")[0].trim();
				year = te.split(" ")[1].trim();
			}
			click("dob_date");
			click("dob_year_ok");
			click("patient_relationship");
			text = td_reader("patient_relationship");
			drop_down(OR_reader("Object_Locator", "patient_relationship_list"),text);  
			driver.findElement(By.xpath(OR_reader("Object_Locator", "patient_state"))).sendKeys(td_reader("patient_state"));
			click("patient_gender");
			text = td_reader("patient_gender");
			drop_down(OR_reader("Object_Locator", "patient_relationship_list"),text); 
			browser_wait(5);
			click("other_agree_to_docpanel_checkbox");
			click("iam_legal_guardian_checkbox");
			click("proceed_button");
			Thread.sleep(8000);
			fr= driver.findElement(By.xpath(OR_reader("Object_Locator","outer_frame")));
			driver.switchTo().frame(fr);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "upload_scans_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_close();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_positive_tc_009");
		}
	}
}
