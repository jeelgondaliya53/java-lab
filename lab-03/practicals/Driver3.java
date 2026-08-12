public class Driver3{
    public static void main(String[] args) {

        Point[] points = {
                new Point(1, 2),
                new Point(3, 4),
                new Point(1, 2),
                new Point(5, 6),
                new Point(3, 4),
                new Point(7, 8),
                new Point(5, 6)
        };

        int count = 0;

        for (int i=0;i<points.length;i++) 
        {
            boolean found=false;

            for (int j=0; j<i;j++) 
            {
                if(points[i].equals(points[j])) 
                {
                    found=true;
                    break;
                }
            }

            if (!found) 
            {
                count++;
            }
        }
        for(Point p:points)
        {
        System.out.println("points: "+p);
        }
        System.out.println("Distinct: " + count);
    }
}