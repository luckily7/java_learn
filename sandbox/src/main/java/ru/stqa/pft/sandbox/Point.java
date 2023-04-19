package ru.stqa.pft.sandbox;

public class Point {

  public static void main(String[] args) {
    Point1 p1 = new Point1(5, 6);

    Point2 p2 = new Point2(15, 17);


    System.out.println("Расстояние между точками (" + p1.x+";"+p1.y + ") и (" + p2.x+";"+p1.y + ")" + " = " + distance(p1,p2));
  }

  public static double distance(Point1 p1, Point2 p2) {
    return Math.sqrt((p2.y - p1.y) * (p2.y - p1.y) + (p2.x - p1.x) * (p2.x - p1.x));
  }
}

