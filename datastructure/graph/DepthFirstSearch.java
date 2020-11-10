package datastructure.graph;

import java.util.Stack;

public class DepthFirstSearch {

	private BetterGraph bg;
	boolean visited[];

	public DepthFirstSearch(BetterGraph bg) {
		this.bg = bg;
		visited = new boolean[bg.arrayOfList.length];
	}

	public void depthFirstSearch(String word) {

		visited[bg.indexForName(word)] = true;
		System.out.print(word + " ");
		Stack<String> stack = new Stack<String>();
		stack.push(word);
		int i = bg.indexForName(word);

		while (bg.arrayOfList[i].adjlist != null) {
			Node node = bg.arrayOfList[i].adjlist;
			if (!visited[node.vertexIdx]) {
				System.out.print(bg.arrayOfList[node.vertexIdx].name + " ");
				stack.push(bg.arrayOfList[node.vertexIdx].name);
				visited[node.vertexIdx] = true;
				i = bg.indexForName(bg.arrayOfList[node.vertexIdx].name);
			} else {
				if (node.next != null)
					i = bg.indexForName(bg.arrayOfList[node.next.vertexIdx].name);
				else
					break;
			}
		}

		while (!stack.isEmpty()) {
			word = stack.peek();
			i = bg.indexForName(word);
			for (Node node = bg.arrayOfList[i].adjlist; node != null; node = node.next) {
				if (!visited[node.vertexIdx]) {
					visited[node.vertexIdx] = true;
					stack.push(bg.arrayOfList[node.vertexIdx].name);
					word = bg.arrayOfList[node.vertexIdx].name;
					System.out.print(word + " ");
					i = bg.indexForName(word);
					break;
				}
				else if(node.next==null)
					stack.pop();
			}
		}
	}
}
