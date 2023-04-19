package ru.stqa.pft.sandbox;

public class Point1 {

  public double x;
  public double y;

  public Point1(double x, double y) {
   this.x = x;
   this.y = y;
  }

  public double distance(Point2 p2) {
    return Math.sqrt((p2.y - this.y) * (p2.y - this.y) + (p2.x - this.x) * (p2.x - this.x));
}
}
