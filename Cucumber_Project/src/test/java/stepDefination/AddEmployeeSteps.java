package stepDefination;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class AddEmployeeSteps {
	String ExepectedEid;
	String Actualeid;
	WebDriver driver;
	@Given("^user navigates url in a browser$")
	public void user_navigates_url_in_a_browser() throws Throwable {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://orangehrm.qedgetech.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	}

	@When("^user logs in username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_logs_in_username_as_and_password_as(String username, String password) throws Throwable {
	   driver.findElement(By.name("txtUsername")).sendKeys(username);
	   driver.findElement(By.name("txtPassword")).sendKeys(password);
	}

	@When("^user clicks login button$")
	public void user_clicks_login_button() throws Throwable {
	    driver.findElement(By.name("Submit")).click();
	}

	@When("^user click pim and clicks add button$")
	public void user_click_pim_and_clicks_add_button() throws Throwable {
		driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		}

	

	@When("^user enter firstname \"([^\"]*)\"$")
	public void user_enter_firstname(String FirstName) throws Throwable {
    driver.findElement(By.name("firstName")).sendKeys(FirstName);
	}

	@When("^user enter middlename \"([^\"]*)\"$")
	public void user_enter_middlename(String middlename) throws Throwable {
		driver.findElement(By.name("middleName")).sendKeys(middlename);
	}

	@When("^user enter lastname \"([^\"]*)\"$")
	public void user_enter_lastname(String lastName) throws Throwable {
		driver.findElement(By.name("lastName")).sendKeys(lastName);
	}
	

	@When("^user capture employee id before adding$")
	public void user_capture_employee_id_before_adding() throws Throwable {
	 ExepectedEid =driver.findElement(By.name("employeeId")).getAttribute("value");
	}
	@When("^user click save button$")
	public void user_click_save_button() throws Throwable {
	    driver.findElement(By.xpath("//input[@id='btnSave']")).click();
	}

	@When("^user capture employee id After adding$")
	public void user_capture_employee_id_After_adding() throws Throwable {
	   Actualeid = driver.findElement(By.name("personal[txtEmployeeId]")).getAttribute("value");
	}

	@Then("^user validates employee id$")
	public void user_validates_employee_id() throws Throwable {
	    if(ExepectedEid.equals(Actualeid)) {
	    	System.out.println("Add Emp Success:"+ExepectedEid+" "+Actualeid);
	    }else {
	    	System.out.println("Add Emp Failed:"+ExepectedEid+" "+Actualeid);
	    }
	}

	@Then("^user close browser$")
	public void user_close_browser() throws Throwable {
	driver.quit();
	}


}
