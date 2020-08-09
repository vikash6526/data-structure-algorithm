package datastructure.graph;

import java.util.LinkedList;

public class BreadthFirstSearch {

	private BetterGraph bg;
	
	public BreadthFirstSearch(BetterGraph bg) {
		this.bg=bg;
	}


	public void breadthFirstSearch(String word) {
		
		boolean visited[] = new boolean[bg.arrayOfList.length];

		LinkedList<String> queue = new LinkedList<String>();

		visited[bg.indexForName(word)] = true;

		queue.add(word);
		
		while(queue.size()!=0) {
			word=queue.poll();
			System.out.print(word+" ");
			int i=bg.indexForName(word);
			for(Node node=bg.arrayOfList[i].adjlist; node!=null; node=node.next) {
				if(!visited[node.vertexIdx]) {
					visited[node.vertexIdx]=true;
					queue.add(bg.arrayOfList[node.vertexIdx].name);
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
