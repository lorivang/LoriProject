package hackerrank;

import java.io.IOException;

public class CovariantReturnTypes {

	static class Flower {
		String ret;
		Flower() {
			ret  = "I have many names and types";
		}
		
		String whats_Your_Name() {
			return ret;
		}
	}
	
	static class Jasmine extends Flower {
		Jasmine() {
			ret = getClass().getSimpleName();
			// TODO Auto-generated constructor stub
		}
	}
	
	static class Lily extends Flower {
		Lily() {
			ret = getClass().getSimpleName();
		}
	}
	
	static class Lotus extends Flower {
		Lotus() {
			ret = getClass().getSimpleName();
			// TODO Auto-generated constructor stub
		}
	}
	
	static class State {
		Flower flower;
		
		State() {
			flower = new Flower();
		}
		
		Flower your_National_Flower() {
			return flower;
		}
	}
	
	static class WestBengal extends State {
		WestBengal() {
			flower = new Jasmine();
		}
		
	}
	static class Karnataka extends State {
		Karnataka() {
			flower = new Lotus();
		}
	}
	static class AndhraPradesh extends State {
		AndhraPradesh() {
			flower = new Lily();
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		System.out.println(new Lily().whats_Your_Name());
	}
}
