package myProj;

import java.util.List;

public class ParkingLotProblem {

	class ParkingLot {
		List<Space> filled;
		List<Space> empty;
		int size;
		int numFilled;
		
		ParkingLot(int size) {
			this.size = size;
			for (int i = 0; i < size; i++) {
				empty.add(new Space());
			}
			numFilled = 0;
		}
		
		boolean isFull() {
			return numFilled == size;
		}
		
		boolean park() {
			if (isFull()) {
				return false;
			}
			filled.add(empty.remove(0));
			numFilled++;
			return true;
		}
		
		void leave() {
			if (numFilled == 0) {
				throw new IllegalStateException("No cars in parking lot");
			}
			empty.add(filled.remove(0));
			numFilled--;
		}
		
	}
	enum SpaceSize {MOTORCYCLE, COMPACT, FULL};
	
	class Space {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
