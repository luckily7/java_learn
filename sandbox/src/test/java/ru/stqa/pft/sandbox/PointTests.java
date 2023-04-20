package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance() {
    Point p1 = new Point(5, 6);
    Point p2 = new Point(15, 17);
    Assert.assertEquals (p1.distance(p2), 14.866068747318506);
  }
}

