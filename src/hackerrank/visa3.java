package hackerrank;
class FoodFactory {
    public Food getFood(String foodType) {
        if (foodType.equalsIgnoreCase("FastFood")) {
            return new FastFood();
        } else if (foodType.equalsIgnoreCase("Fruit")) {
            return new Fruits();
        } else {
            return null;
        }
    }
}
class Food {
    String type;
    void serveFood() {
        System.out.println("I'm serving " + type);
    }
}
class Fruits extends Food {
        
    Fruits() {
        this.type = "Fruits";
    }
}
class FastFood extends Food {
    String type;
    
    FastFood() {
        this.type = "FastFood";
    }
}
public class visa3 {

	
	public static void main(String[] argh) {
		FoodFactory myFoods = new FoodFactory();
		Food food1 = myFoods.getFood("FastFood");
		Food food2 = myFoods.getFood("Fruits");	
		System.out.println("My name is: " + food1.getClass().getName());
		System.out.println("My name is: " + food2.getClass().getName());
		System.out.println("Our superclass is: " + food1.getClass().getSuperclass().getName());
		food1.serveFood();
		food2.serveFood();
	}

}
