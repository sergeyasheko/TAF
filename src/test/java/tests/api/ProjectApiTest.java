package tests.api;

import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectApiTest extends BaseApiTest {

    @Test
    public void positiveTest() {
        Project expectedProject = Project.builder()
                .typeOfProject(1)
                .name("QA18")
                .build();

        Assert.assertTrue(projectHelper.getProject(57).equals(expectedProject));
    }

    @Test
    public void negativeInvalidProjectTest() {
        Assert.assertEquals(projectHelper.getProjectResponse(500).getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void positiveCountProjectsTest() {
        Assert.assertEquals(projectHelper.getAllProjects().size(), 78);
        Assert.assertEquals(projectHelper.getProject(57).getName(), "QA18");
    }
}
