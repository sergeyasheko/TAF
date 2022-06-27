package tests.api;

import configuration.Endpoints;
import models.Milestone;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MilestoneApiTest extends BaseApiTest {
    public Milestone milestone;
    private int project_ID = 57;


    @Test(priority = 1)
    public void addMilestoneTest() {

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name","first");
        milestone = milestoneHelper.addMilestone(jsonAsMap);

        Assert.assertEquals(milestone.getName(), jsonAsMap.get("name"));
    }

    @Test(dependsOnMethods = "addMilestoneTest")
    public void updateMilestoneTest() {

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", "first");
        jsonAsMap.put("description", "T42");

        given()
                .body(jsonAsMap)
                .when()
                .pathParams("milestone_id", milestone.getId())
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Milestone.class);
    }

    @Test(dependsOnMethods = "updateMilestoneTest")
    public void getMilestoneTest() {

        given()
                .when()
                .pathParams("milestone_id", milestone.getId())
                .get(Endpoints.GET_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "getMilestoneTest")
    public void deleteMilestoneTest() {

        given()
                .when()
                .pathParams("milestone_id", milestone.getId())
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test(dependsOnMethods = "deleteMilestoneTest")
    public void getMilestonesTest() {
        milestoneHelper.getMilestones();
    }
}
