package hackerrank;

import java.util.Scanner;

public class vmware4 {
	
	class Point2D {
		int x;
		int y;
				
		Point2D(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public double dist2D(Point2D p) {
			double dist = Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
			return dist;		
		}
		
		public void printDistance(double d) {
			int i = (int) Math.ceil(d);
			System.out.println("2D distance = " + i);
		}
	}
	
	class Point3D extends Point2D {
		int z;
		
		Point3D(int x, int y, int z) {
			super(x, y);
			this.z = z;
		}
		
		public double dist3D(Point3D p) {
			double dist = Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2) + Math.pow(p.z - this.z, 2));
			return dist;		
		}
		
		@Override
		public void printDistance(double d) {
			int i = (int) Math.ceil(d);
			System.out.println("3D distance = " + i);
		}
	}

    public static void main(String[] args) {
    	vmware4 v = new vmware4();
    	Point3D p = v.new Point3D(1,2,3);
    	Point3D p2 = v.new Point3D(4,5,6);
    	p.printDistance(p.dist2D(p2));
    	p.printDistance(p.dist3D(p2));
    }
}
