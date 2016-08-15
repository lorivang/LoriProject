package myProj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import myProj.MyTestClass.SingleLinkedNode;

public class MyTestClass {

	public class SingleLinkedNode<T> {
		public SingleLinkedNode(T s) {
			value = s;
		}
		private T value;
		private SingleLinkedNode<T> next;
		
		public T getValue() {
			return value;
		}
		public void setValue(T value) {
			this.value = value;
		}
		public SingleLinkedNode<T> getNext() {
			return next;
		}
		public void setNext(SingleLinkedNode<T> next) {
			this.next = next;
		}
	}
	
	public class SinglyLinkedList<T> {
		private SingleLinkedNode<T> head;

		public SingleLinkedNode<T> getHead() {
			return head;
		}

		public void setHead(SingleLinkedNode<T> head) {
			this.head = head;
		}

		public void add(SingleLinkedNode<T> node) {
			if (head == null) {
				head = node;
			} else {
				SingleLinkedNode<T> tail = head;
				while (tail.next != null) {
					tail = tail.next;
				}
				tail.next = node;
			}
		}
		
		public void addAll(T[] values) {
			for (T s : values) {
				SingleLinkedNode<T> sln = new SingleLinkedNode<T>(s);
				add(sln);
			}
		}
		
		public void reverse() {
			doReverse(head);
		}

		private SingleLinkedNode<T> doReverse(SingleLinkedNode<T> head) {
			if (head.next == null) {
				this.head = head;
			} else {
				doReverse(head.next).next = head;
				head.next = null;
			}
			return head;
		}
	}
	
	public static String reverseString(String input) {
	    if (input.length() > 1) {
	    	return(reverseString(input.substring(1)) + input.substring(0, 1));
	    } else {
	    	return(input);
	    }
	}
	
	public static void xorTrick(int a, int b) {
		System.out.println("Before : a = " + a + " b = " + b);
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;
		System.out.println("After : a = " + a + " b = " + b);

	}
	
	public static boolean isPrime(int in) {
		for (int i = 2; i < Math.sqrt(in); i++) {
			if (in % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static List<Integer> factor(int in) {
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i < Math.sqrt(in); i++) {
			if (in % i == 0) {
				res.add(i);
				res.add(in/i);
			}
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Hello!");
		System.out.println(factor(12));
		xorTrick(6, 7);
		Scanner scan = new Scanner(System.in);
        FileReader fileReader = new FileReader("resources/test.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
		try {
	        List<String> lines = new ArrayList<String>();
	        String line = null;
	        while ((line = bufferedReader.readLine()) != null) {
	            lines.add(line);
	        }
	        bufferedReader.close();

	        System.out.println(lines);

	        int i = scan.nextInt();

	        double d = scan.nextDouble();
	        String s = scan.next();

	        System.out.println("String: " + s);
	        System.out.println("Double: " + d);
	        System.out.println("Int: " + i);
//			String s = scan.nextLine();
//			while (!s.equalsIgnoreCase("end")) {
//				System.out.println(MyTestClass.reverseString(s));
//				s = scan.nextLine();
//			}
			// String[] testData = {"1", "2", "3", "4", "5"};
			// prettyPrint(testData);
			// SinglyLinkedList Sll = mtc.new SinglyLinkedList();
			// Sll.addAll(testData);
			// Sll.reverse();
			// prettyPrint(Sll);

		} finally {
			scan.close();
			bufferedReader.close();
		}
	}

	public static void prettyPrint(SinglyLinkedList Sll) {
		SingleLinkedNode<String> Sln = Sll.head;
		String s = "";
		while (Sln != null) {
			s += Sln.value + " ";
			Sln = Sln.next;
		}
		System.out.println(s);		
	}

	public static <E> void prettyPrint(E[] testData) {
		String s = "";
		for (E t : testData) {
			s += t + " ";
		}
		System.out.println(s);
	}


}
