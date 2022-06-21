package in.co.gorest.stepdef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import in.co.gorest.userinfo.UserSteps;
import in.co.gorest.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasValue;

public class UserStepdefs {

    static String name = "Ramesh Patel" + TestUtils.getRandomValue();
    static String email = TestUtils.getRandomValue() + "ramesh123@gmail.com";
    static String gender = "male";
    static String status = "active";
    static int userId;
    static ValidatableResponse response;

    @Steps
    UserSteps userSteps;

    @When("^I create a new user by providing the information name email gender and status$")
    public void iCreateANewUserByProvidingTheInformationNameEmailGenderAndStatus() {
        response= userSteps.createUser(name,email,gender,status);

    }

    @Then("^I verify that the new user is created$")
    public void iVerifyThatTheNewUserIsCreated() {
        response.statusCode(201).log().all();
        name = "Mahesh Patel";
        HashMap<String, Object> userMap = userSteps.getUserInfoByFirstName(name);
        Assert.assertThat(userMap, hasValue(name));
        userId = (int) userMap.get("id");
        System.out.println(userId);
    }

    @When("^I update the store with name email gender and status$")
    public void iUpdateTheStoreWithNameEmailGenderAndStatus() {
        name = "Mahesh";
        gender="ale";
        email="mahesh@gmail.com";
        status="active";
        userId = 3259;
        response=userSteps.updateUser(userId,name,email,gender,status);
    }

    @Then("^I verify that the user information is updated$")
    public void iVerifyThatTheUserInformationIsUpdated() {
        response.statusCode(200).log().body().body("name", equalTo(name), "email", equalTo(email));
    }

    @When("^I delete the user created with id$")
    public void iDeleteTheUserCreatedWithId() {
        userId = 3256;
        response=userSteps.deleteUser(userId);

    }

    @Then("^I verify that the user is deleted and get the status (\\d+)$")
    public void iVerifyThatTheUserIsDeletedAndGetTheStatus(int exp) {
        response.statusCode(exp).log().status();
    }
}
