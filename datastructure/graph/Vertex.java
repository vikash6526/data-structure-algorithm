package datastructure.graph;

public class Vertex {

	public String name;
	public Node adjlist;

	public Vertex(String name, Node node) {
		this.name = name;
		adjlist = node;
	}

}
