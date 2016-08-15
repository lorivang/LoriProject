package areaProblem;

public class Circle extends Shape {

	private final int radius;
	
	Circle() {
		throw new UnsupportedOperationException("Don't use default constructor, use Circle(int radius)");
	}
	
	Circle(int r){
		this.radius = r;
	}
	
	@Override
	public double Perimeter() {
		System.out.println(2*Math.PI*radius);
		return (2*Math.PI*radius);
	}

	@Override
	public double Area() {
		System.out.println(Math.PI*(radius * radius));
		return (Math.PI*(radius * radius));
	}

}
