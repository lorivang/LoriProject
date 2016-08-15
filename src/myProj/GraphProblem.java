package myProj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

public class GraphProblem {

	public enum State {
		VISITED, NOTVISITED, VISITING;
	}
	public static class Node<T> {
		T data;
		List<Node<T>> neighbors = new ArrayList<>();
		State state = State.NOTVISITED;
		// Constructor
		public Node() {
		}

		Node(T data) {
			this.data = data;
		}
		
		public void addNeighbor(Node<T> t) {
			neighbors.add(t);
		}
		
		public List<Node<T>> getNeighbors() {
			return neighbors;
		}
		
		public void setNeighbors(List<Node<T>> neighbors) {
			this.neighbors = neighbors;
		}

		public T getData() {
			return data;
		}

		public boolean isVisited() {
			// TODO Auto-generated method stub
			return state == State.VISITED;
		}

		public void setVisited() {
			state = State.VISITED;
			
		}
	}

	public static <T> List<T> BFS(Node<T> s, T target) {
		// keep track of parents so we can return the correct path.
		Map<Node<T>, Node<T>> trackParent = new HashMap<>();

		List<T> ret = new LinkedList<>();
		// BFS, store nodes we still need to visit in a queue.
		Queue<Node<T>> toVisit = new LinkedList<>();

		// seed the queue with the root.
		toVisit.add(s);
		while (!toVisit.isEmpty()) {
			Node<T> node = toVisit.remove();
				node.setVisited();
				if (node.getData() == target) {
					// found it!  Now compute the path
					ret.add(node.getData());
					Node<T> parent = trackParent.get(node);
					while (parent != null) {
						ret.add(parent.getData());
						parent = trackParent.get(parent);
					}
					Collections.reverse(ret);
					return ret; 
				}
				for (Node<T> neighbor : node.getNeighbors()) {
					if (!neighbor.isVisited()) {
						toVisit.add(neighbor);
						trackParent.put(neighbor,node);
					}
				}
		}
		return ret;
	}

	private static <T> List<T> reverse(List<T> ret) {
		if (ret.isEmpty()) {
			return ret;
		}
		T t = ret.remove(0);
		reverse(ret).add(t);
		return(ret);
	}

	public static <T> List<T> DFS(Node<T> s, T target) {
		// Use recursion.
		List<T> ret = new ArrayList<>();
		if (doDFS(s, target, ret)) {
			return ret;
		} else {
			return new ArrayList<>();
		}
	}
	
	// returns true if path found.
	private static <T> boolean doDFS(Node<T> s, T target, List<T> ret) {
		if (s.isVisited()) {
			// already been here
			return false;
		}
		s.setVisited();
		ret.add(s.getData());

		if (s.getData() == target) {
			return true; //done.
		}
		for (Node<T> node : s.getNeighbors()) {
			if (doDFS(node, target, ret)) {
				return true;
			}
		}
		return false;
	}

	public static Node<String> getSampleGraph() {
		Node<String> S = new Node<String>("S");
		Node<String> A = new Node<String>("A");
		Node<String> B = new Node<String>("B");
		Node<String> C = new Node<String>("C");
		Node<String> D = new Node<String>("D");
		Node<String> E = new Node<String>("E");
		Node<String> F = new Node<String>("F");
		Node<String> T = new Node<String>("T");
		
		S.addNeighbor(A);
		S.addNeighbor(B);
		A.addNeighbor(C);
		A.addNeighbor(D);
		B.addNeighbor(E);
		B.addNeighbor(F);
		C.addNeighbor(A);
		C.addNeighbor(S);
		D.addNeighbor(F);
		D.addNeighbor(T);
		F.addNeighbor(T);

		return S;
	}
	
	public static <T> HashSet<T> treeSetToHashSet(TreeSet<T> t) {
		HashSet<T> result = new HashSet<>(t.size());
		for (T element : t) {
			result.add(element);
		}
		// even better
		result = new HashSet<>(t);
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Arrays.toString(DFS(getSampleGraph(), "F").toArray()));
		System.out.println(Arrays.toString(BFS(getSampleGraph(), "F").toArray()));
		System.out.println(Arrays.toString(DFS(getSampleGraph(), "C").toArray()));
		System.out.println(Arrays.toString(BFS(getSampleGraph(), "C").toArray()));

	}

}
