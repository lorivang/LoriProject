package areaProblem;

public class Parallelogram extends Shape {

	Parallelogram() {
		throw new UnsupportedOperationException("Don't use default constructor, use Parallelogram(int height, int breadth)");
	}
	
	Parallelogram(int height, int breadth) {
		this.height = height;
		this.breadth = breadth;
	}
	
	private final int height;
	private final int breadth;
	
	@Override
	public double Perimeter() {
		System.out.println("perimeter: " + 2*(height + breadth));
		return 2*(height + breadth);
	}

	@Override
	public double Area() {
		System.out.println("area: " + (height * breadth));
		return height*breadth;
	}

}
