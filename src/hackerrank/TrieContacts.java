package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TrieContacts {

	static Map<String, List<String>> prefixTrie = new HashMap<String, List<String>>();
	static TrieNode head = new TrieNode();
	static class TrieNode {
		TrieNode[] chars;
		int count; // the count of words below this point
		boolean end; // is this the end of a word?
		
		public TrieNode() {
			count = 0;
			end = false;
			chars = new TrieNode[26];
		}
		
		public TrieNode nextNode(char c) {
			return chars[c-'a'];
		}
		
		public TrieNode addNode(char c) {
			TrieNode ret = nextNode(c);
			if (ret == null) {
				ret = new TrieNode();
				chars[c-'a'] = ret;
			}
			ret.count++;
			return ret;
		}

	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        String bad = "";
        for (int i = 1; i <=k; i++){
            String cmd = in.next();
            if (cmd.equalsIgnoreCase("add")) {
                String name = in.next();

            	addContact(name);
            } else if (cmd.equalsIgnoreCase("find")) {
                String name = in.next();

            	System.out.println(findNumberOfMatches(name));
            	System.out.println(returnMatches(name));
            } else {
            	String tempBad = addContactReportDupPrefix(cmd);
            	if (bad.isEmpty()) {
            		bad = tempBad;
            	}
            }
        }
        if (!bad.isEmpty()) {
            System.out.println("BAD SET");
            System.out.println(bad);
        } else {
            System.out.println("GOOD SET");
        }
        in.close();
	}


	private static List<String> returnMatches(String pre) {
		// Navigate down the whole prefix.
		char[] s = pre.toCharArray();
		TrieNode node = head;
		for (char c : s) {
			node = node.nextNode(c);
			if (node == null) {
				return null;
			}
		}
		// At end of prefix, now we actually need to return all the words.
		List<String> ret = new ArrayList<>(node.count); // at least we know how many there are!
		if (node.end) { // the prefix is a word
			ret.add(pre);
		}
		addAllWords(node, pre, ret);
		return ret;
	}

	private static void addAllWords(TrieNode node, String pre, List<String> ret) {
		for (int i = 0; i < node.chars.length; i++) {
			String tempPre = pre + (char) ('a' + i);
			TrieNode next = node.chars[i];
			if (next != null) {
				boolean moreWords = true;

				if (next.end) {
					ret.add(tempPre);
					if (next.count == 1) {
						moreWords = false;
					}
				}
				if (moreWords) {
					addAllWords(next, tempPre, ret);
				}
			}
		}

	}

	private static int findNumberOfMatches(String pre) {

		// Navigate down the whole prefix.
		char[] s = pre.toCharArray();
		TrieNode node = head;
		for (char c : s) {
			node = node.nextNode(c);
			if (node == null) {
				return 0;
			}
		}
		// At the end of prefix, node should contain the correct count.
		return node.count;
	}

	private static String addContactReportDupPrefix(String name) {
		char[] s = name.toCharArray();
		String ret = "";
		TrieNode node = head;
		for (char c : s) {
			node = node.addNode(c);
			if (node.end) { // if this is the end of another name, this is a bad set.
				ret = name;
			}
		}
		node.end = true;
		if (node.count > 1) { // this name is the prefix of some other word already.
			ret = name;
		}
		return ret;
	}



	private static TrieNode addContact(String name) {
		char[] s = name.toCharArray();
		TrieNode node = head;
		for (char c : s) {
			node = node.addNode(c);
		}
		node.end = true;
		return node;
	}


	private static int findNumberOfMatchesMap(String pre) {
		if (!prefixTrie.containsKey(pre)) {
			return 0;
		}
		return (prefixTrie.get(pre).size());

	}


	private static void addContactMap(String name) {
		// Add info to the trie for subsequent lookups.
		for (int i = 1; i <= name.length(); i++) {
			String pre = name.substring(0, i);
			if (prefixTrie.containsKey(pre)) {
				prefixTrie.get(pre).add(name);
			} else {
				List<String> l = new ArrayList<String>(); 
				l.add(name);
				prefixTrie.put(pre, l);
			}
		}
		
	}

}
