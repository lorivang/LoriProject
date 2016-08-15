package areaProblem;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ParallelogramTest {

	private static Parallelogram p = new Parallelogram(3,4);
	private Map<Shape, double[]> data = new HashMap<Shape, double[]>();

	@Before
	public void setup() {
		data.put(p, new double[]{14, 12});
		data.put(new Parallelogram(5,6), new double[]{22,30});
		data.put(new Parallelogram(10,10), new double[]{40,100});
		data.put(new Circle(5), new double[]{(2*5*Math.PI), Math.PI*5*5});
	}
	
	@Test
	public void testPerimeter() {
		System.out.println("hi");
		for (Shape s : data.keySet()) {
			assertEquals("ERROR: incorrect perimeter value", s.Perimeter(), data.get(s)[0], .01);
		}
	}

	@Test
	public void testArea() {
		for (Shape s : data.keySet()) {
			assertEquals("ERROR: incorrect area value", s.Area(), data.get(s)[1], .01);
		}
	}

}
