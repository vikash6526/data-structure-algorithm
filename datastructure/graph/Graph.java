package datastructure.graph;

import java.util.ArrayList;

public class Graph {

	private int vCount; // no of vertices
	private int eCount; // no of edges

	private ArrayList[] adjacents; // array of integer list

	public Graph(int vCount) {
		this.vCount = vCount;
		this.eCount = 0;
		adjacents = new ArrayList[vCount];

		for (int i = 0; i < vCount; i++) {
			adjacents[i] = new ArrayList();
		}

	}

	public int getvCount() {
		return vCount;
	}

	public void setvCount(int vCount) {
		this.vCount = vCount;
	}

	public int geteCount() {
		return eCount;
	}

	public void seteCount(int eCount) {
		this.eCount = eCount;
	}

	public ArrayList[] getAdjacents() {
		return adjacents;
	}

	public void setAdjacents(ArrayList[] adjacents) {
		this.adjacents = adjacents;
	}

	public void addEdges(int src, int des) {
		adjacents[src].add(des);
		eCount++;
	}
	
	public Object[] adj(int src) {
		return adjacents[src].toArray();
	}

}
