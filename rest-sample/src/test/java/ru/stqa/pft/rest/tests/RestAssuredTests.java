package ru.stqa.pft.rest.tests;

import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import com.solidfire.gson.Gson;
import com.solidfire.gson.JsonElement;
import com.solidfire.gson.JsonParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestAssuredTests {


  @BeforeClass
  public void init(){
    RestAssured.authentication = RestAssured.basic("65c38fae4d0f34a3daccb854fc345a2d", "");
  }

  @Test
  public void testCreateIssue() throws IOException {
    Set<Issue> oldIssues = getIsues();
    Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
    int issueId = createIssue(newIssue);
    Set<Issue> newIssues = getIsues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }


  private Set<Issue> getIsues() throws IOException {
    String json = RestAssured.get("https://bugify.stqa.ru/api/issues.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
  }

  private int createIssue(Issue newIssue) throws IOException {
    String json = RestAssured.given()
            .parameter("subject", newIssue.getSubject())
            .parameter("description", newIssue.getDescription())
            .post("https://bugify.stqa.ru/api/issues.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();
  }
}
