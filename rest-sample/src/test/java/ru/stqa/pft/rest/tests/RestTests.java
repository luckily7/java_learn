package ru.stqa.pft.rest.tests;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Set;
import static org.testng.Assert.assertEquals;

public class RestTests extends TestBase{

  @Test
  public void testCreateIssue () throws IOException {
    skipIfNotFixed(28);
    Set<Issue> oldIssues = app.json().getIssue();
    Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
    int issueId = app.json().createIssue (newIssue);
    Set<Issue> newIssues = app.json().getIssue();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }
}