package trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	public static class TrieNode {

		public Map<Character, TrieNode> children;
		public boolean endOfWord;

		public TrieNode() {
			super();
			this.children = new HashMap<>();
			this.endOfWord = false;
		}
	}

	public final TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {

		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			if (curr.children.get(word.charAt(i)) != null) {
				curr = curr.children.get(word.charAt(i));
			} else {
				TrieNode temp = new TrieNode();
				curr.children.put(word.charAt(i), temp);
				curr = temp;
			}
		}
		curr.endOfWord = true;
	}

	public boolean wholeWordSearch(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);
			TrieNode node = curr.children.get(ch);
			if (node == null)
				return false;
			curr = node;
		}
		return curr.endOfWord;
	}

	public boolean prefixSearch(String word) {

		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			if (curr.children.containsKey(c)) {
				curr = curr.children.get(c);
			} else {
				return false;
			}
		}
		return true;
	}

	public void deleteWord(String word) {
		deleteRec(root, word, 0);
	}

	/**
	 * Returns true if parent should delete the mapping
	 */
	private boolean deleteRec(TrieNode current, String word, int index) {

		if (word.length() == index) {

			// return false if word dosen't exist
			if (!current.endOfWord)
				return false;

			current.endOfWord = false;

			// if current has no other mapping then return true
			return current.children.size() == 0;
		}

		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);

		if (node == null)
			return false;

		boolean shouldBeDeleted = deleteRec(node, word, index + 1);

		// if true is returned then delete the mapping of character and trienode
		// reference from map
		if (shouldBeDeleted) {
			current.children.remove(ch);
			return current.children.size() == 0;
		}
		return false;
	}

	public static void main(String[] args) {
		String test = "abcd";
		String test1 = "abgl";
		Trie trie = new Trie();
		trie.insert(test);
		trie.insert(test1);
		System.out.println(trie.prefixSearch("b"));
	}
}
