package helpers;

import configuration.Endpoints;
import models.Milestone;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class MilestoneHelper {

    private int project_ID = 57;

    public Milestone addMilestone(Map<String, Object> jsonAsMap) {
        return given()
                .body(jsonAsMap)
                .when()
                .pathParams("project_id", project_ID)
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(Milestone.class);
    }

    public void getMilestones() {
        given()
                .when()
                .pathParams("project_id", project_ID)
                .get(Endpoints.GET_MILESTONES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
