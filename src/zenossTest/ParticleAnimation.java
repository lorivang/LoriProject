package zenossTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Lori Van Gulick
 *
 */
public class ParticleAnimation {
	
	class Particle {
		private int dir; // TODO make an enum
		private char c;
		
		Particle(char c){
			if (c == 'L') {
				dir = 1;
			} else if (c == 'R') {
				dir = 2;
			} else {
				dir = 0;
			}
			this.c = c;
		}
		public char getC() {
			return c;
		}
		public boolean isEmptySpace() {
			return (c == '.');
		}
		public boolean isRight() {
			return (dir == 2);
		}
		public boolean isLeft() {
			return (dir == 1);
		}

	}
	class Field {
		private Particle[][] state;

		Field(String init) {
			this.state = new Particle[init.length()][2];
			char[] asChars = init.toCharArray();
			for (int i = 0; i < init.length(); i++) {
				if (asChars[i] != '.') {
					state[i][0] = new Particle(asChars[i]);					
				}
			}
		}
		
		public void advance(int speed) {
			// Take state and calculate new state based on speed.
			Particle[][] next = new Particle[state.length][2];

			int i = 0;
			for (Particle[] p : state) {
				for (int j = 0; j < p.length; j++) {
				if (p[j] != null) {
					int newPos;
					if (p[j].isRight()) {
						newPos = speed + i;
					} else {
						newPos = i - speed;
					}
					// Make sure in range.
					if (newPos >= 0 && newPos < state.length) {
						if (next[newPos][0] == null) {
						    next[newPos][0] = new Particle(p[j].getC());
						} else {
							next[newPos][1] = new Particle(p[j].getC());
						}
					}
				}
				}
				i++;
			}
			state = next;
		}
		
		public String format() {
			String retVal = "";
			for (Particle[] p : state) {
				retVal += (p[0] == null ? "." : "X");
			}
			return retVal;
		}
		
		public boolean isEmpty() {
			String temp = format().replaceAll("\\.", "");	
			return temp.isEmpty();
		}
	}
	
	public String[] animate(int speed, String init) {
		List<String> animation = new ArrayList<>();
		Field f = new Field(init);
		animation.add(f.format());
		// repeat until done. 
		while (!f.isEmpty()) {
			f.advance(speed);
			animation.add(f.format());
		}
		
		return animation.toArray(new String[animation.size()]);
		}
	
	
	public static void main(String[] args) {

		String[] tests = { "..R....", "RR..LR", "LRLR.LRLR", "LRRL.LR.LRR.R.LRRL." };
		for (String t : tests) {
			ParticleAnimation pa = new ParticleAnimation();

			String[] output = pa.animate(1, t);
			System.out.println("Test : " + t);
			for (String s : output) {
				System.out.println(s);
			}
		}
	}

}
