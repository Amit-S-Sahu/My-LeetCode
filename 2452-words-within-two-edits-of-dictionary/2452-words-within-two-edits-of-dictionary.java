class Solution {
    private static class Node {
		private char data;
		private boolean isEnd;
		private Node[] children;

		public Node(char data) {
			this.data = data;
			this.isEnd = false;
			this.children = new Node[26];
		}
	}

	private Node root = new Node('/');

	private void insert(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			int childIdx = word.charAt(i) - 'a';
			if (curr.children[childIdx] == null) {
				curr.children[childIdx] = new Node(word.charAt(i));
			}
			curr = curr.children[childIdx];
		}
		curr.isEnd = true;
	}

	private boolean find(Node root, String word, int count, int index) {
		if (index == word.length()) {
			return count <= 2;
		}
		boolean ans = false;
		for (int i = 0; i < root.children.length; i++) {
			if (root.children[i] != null) {
				ans |= find(root.children[i], word, count + (((word.charAt(index) - 'a') == i) ? 0 : 1), index + 1);
			}
		}
		return ans;
	}

	public List<String> twoEditWords(String[] queries, String[] dictionary) {
		List<String> ans = new ArrayList<>();
		for (String word : dictionary) {
			insert(word);
		}
		for (String query : queries) {
			Node curr = root;
			if (find(curr, query, 0, 0)) ans.add(query);
		}
		return ans;
	}
}