package ru.stqa.pft.sandbox;

public class Point {

  public static void main(String[] args) {
    Point1 p1 = new Point1();
    p1.x = 5;
    p1.y = 6;

    Point2 p2 = new Point2();
    p2.x = 15;
    p2.y = 17;

    System.out.println("Расстояние между точками  " + " = " + distance(p1,p2));
  }

  public static double distance(Point1 p1, Point2 p2) {
    return Math.sqrt((p2.y - p1.y) * (p2.y - p1.y) + (p2.x - p1.x) * (p2.x - p1.x));
  }
}

