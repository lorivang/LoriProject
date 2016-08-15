package myProj;

public class Patterns {

	// Singleton Pattern
	public static class MySingleton {
		final static MySingleton instance = new MySingleton();
		
		MySingleton() {
		}
		
		public static MySingleton getInstance() {
			return instance;
		}
		
	}
	
	// Factory Pattern
	public class MyFactory {
		public Object get() {
			return new Object();
		}
	}
	
	public static void main(String[] args) {
		MySingleton ms1 = MySingleton.getInstance();
		MySingleton ms2 = MySingleton.getInstance();
		assert (ms1 == ms2);
		
		Patterns p = new Patterns();
		MyFactory mf = p.new MyFactory();
		Object o1 = mf.get();
		Object o2 = mf.get();
		assert(o1 != o2);
		System.out.println("It works");
	}

}
