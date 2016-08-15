package myProj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProblem {

	int targetLine = -1;
	public String getLineReverse(String fileName, int x) throws IOException {
		targetLine = -1;  // global var
		FileReader fis =new FileReader(fileName);

		String out = null;
		BufferedReader br = null;

		try {
			br=new BufferedReader(fis);
			out = doGetLineReverse(br, x, 0);
			return out;
		} finally {
			if (br != null) {
				br.close();
				fis.close();
			}
		}
	}
	
	private String doGetLineReverse(BufferedReader br, int x, int count) throws IOException {
		String cur = br.readLine();
		if (cur == null) {
			// reached end, calculate target line
			targetLine = count - x;		
			if (targetLine < 0) { //file not big enough
				return "ERROR: File is only " + count + " lines long.  Can't get line that is " + x + " from the end.";
			}
		}
		
		String next = null;
		if (cur != null) {
			next = doGetLineReverse(br, x, count+1);
		}
		
		if (targetLine == count) {
			return cur;
		}

		return next;
	}

	public static void main(String[] args) {
		try {
			String fileName = "C:\\input.txt";
			FileProblem fp = new FileProblem();
			String out = fp.getLineReverse(fileName, 300);
			System.out.println(out);
			System.out.println(fp.getLineReverse(fileName, 1));
			System.out.println(fp.getLineReverse(fileName, 73));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
