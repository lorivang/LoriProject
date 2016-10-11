package hackerrank;

import java.io.IOException;
import java.security.Permission;
import java.text.DecimalFormat;
import java.util.Scanner;

class Calculate{
	Scanner in;
	public CalcOutput output;
	static Shape shape;
	
	Calculate() {
		in = new Scanner(System.in);
		output = new CalcOutput();
		shape = new Shape();
	}
	
	public int get_int_val()  throws IOException {
        return validate(in.nextInt());
	}
	
	private int validate(int nextInt) {
		if (nextInt <= 0) {
			throw new NumberFormatException("All the values must be positive");
		}
		return nextInt;
	}

	@Override
	public void finalize() {
		in.close();
	}

	public double get_double_val() {
		return validate(in.nextDouble());
	}

	private double validate(double nextDouble) {
		if (nextDouble <= 0) {
			throw new NumberFormatException("All the values must be positive");
		}
		return nextDouble;
	}

	public static  Shape do_calc() {
		return shape;
	}
}

class CalcOutput {

	public void display(double volume) {
		System.out.printf("%.3f\n", volume);		
	}
}

class Shape {
	public  double get_volume(int a) {
		return round(Math.pow(a, 3));
	}	

	private double round(double d) {
		return d;
	}

	public  double get_volume(int l, int b, int h) {
		return round(l * b * h);
	}

	public double get_volume(double r) {
		// TODO Auto-generated method stub
		return round((Math.pow(r, 3) * Math.PI) * 2 /3);
	}

	public double get_volume(double r, double h) {
		// TODO Auto-generated method stub
		return round((Math.pow(r, 2) * Math.PI) * h);
	}	
}

	
public class Volumn {
	 public static void main(String[] args) {
		   DoNotTerminate.forbidExit();
		   try {
		    Calculate cal = new Calculate();
		    int T = cal.get_int_val();
		    while (T--> 0) {
		     double volume = 0.0;
		     int ch = cal.get_int_val();
		     if (ch == 1) {
		      int a = cal.get_int_val();
		      volume = Calculate.do_calc().get_volume(a);
		     } else if (ch == 2) {
		      int l = cal.get_int_val();
		      int b = cal.get_int_val();
		      int h = cal.get_int_val();
		      volume = Calculate.do_calc().get_volume(l, b, h);

		     } else if (ch == 3) {
		      double r = cal.get_double_val();
		      volume = Calculate.do_calc().get_volume(r);

		     } else if (ch == 4) {
		      double r = cal.get_double_val();
		      double h = cal.get_double_val();
		      volume = Calculate.do_calc().get_volume(r, h);

		     }
		     cal.output.display(volume);
		    }

		   } catch (NumberFormatException e) {
		    System.out.print(e);
		   } catch (IOException e) {
		    e.printStackTrace();
		   } catch (DoNotTerminate.ExitTrappedException e) {
		    System.out.println("Unsuccessful Termination!!");
		   }


		  } //end of main
		} //end of Solution

		/**
		 *This class prevents the user form using System.exit(0)
		 * from terminating the program abnormally.
		 *
		 */
		class DoNotTerminate {

		 public static class ExitTrappedException extends SecurityException {}

		 public static void forbidExit() {
		  final SecurityManager securityManager = new SecurityManager() {
		   @Override
		   public void checkPermission(Permission permission) {
		    if (permission.getName().contains("exitVM")) {
		     throw new ExitTrappedException();
		    }
		   }
		  };
		  System.setSecurityManager(securityManager);
		 }
		} //end of Do_Not_Terminate
