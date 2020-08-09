package datastructure.graph;

public class App {

	public static void main(String[] args) {
		BetterGraph graph = new BetterGraph(5, "directed");
		graph.addVertex("State");
		graph.addVertex("Avenel");
		graph.addVertex("Elm");
		graph.addVertex("Pocono");
		graph.addVertex("William");
		
		
		graph.addEdge("State", "Avenel");
		graph.addEdge("State", "Elm");
		graph.addEdge("Elm", "Avenel");
		graph.addEdge("Elm", "William");
		graph.addEdge("William", "State");
		graph.addEdge("William", "Pocono");
		graph.addEdge("Pocono", "Elm");
		graph.addEdge("Avenel", "Pocono");
		
		
		//graph.print();
		
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
		bfs.breadthFirstSearch("State");
		
		DepthFirstSearch dfs = new DepthFirstSearch(graph);
		dfs.depthFirstSearch("State");
	}

}
