package ttl.track.domain;

public record Point(int x, int y) {
}

class PointApp
{
   public static void main(String[] args) {
      Point p = new Point(10, 10);
      Point p2 = new Point(10, 10);

      Point p3 = new Point(20, p.y());

      System.out.println("p.x: " + p.x());

      System.out.println("p: " + p);

      if(p.equals(p2)) {
         System.out.println("Equals");
      } else {
         System.out.println("Not Equals");
      }
   }
}
