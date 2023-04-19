package ru.stqa.pft.sandbox;

public class Point {

  public static void main(String[] args) {
    Point1 p1 = new Point1(5, 6);

    Point2 p2 = new Point2(15, 17);


    System.out.println("Расстояние между точками (" + p1.x+";"+p1.y + ") и (" + p2.x+";"+p2.y + ")" + " = " + p1.distance(p2));
  }

}

