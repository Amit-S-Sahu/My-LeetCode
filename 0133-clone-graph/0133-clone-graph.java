class Solution {
    private Map<Node, Node> cloned = new HashMap<>();

    private Node dfs(Node node) {
        if (cloned.containsKey(node)) return cloned.get(node);

        Node copy = new Node(node.val);
        cloned.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor));
        }

        return copy;
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node);
    }
}
