package tests.api;

import configuration.ReadProperties;
import helpers.MilestoneHelper;
import helpers.ProjectHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Milestone;
import models.Project;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    public Project expectedProject;
    public Milestone expectedMilestone;
    public ProjectHelper projectHelper;
    public MilestoneHelper milestoneHelper;

    @BeforeTest
    public void setupEnv() {
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());

        expectedProject =
                Project.builder()
                        .name("QA18")
                        .build();

        expectedMilestone =
                Milestone.builder()
                        .name("first")
                        .build();

        projectHelper = new ProjectHelper();
        milestoneHelper = new MilestoneHelper();
    }
}
