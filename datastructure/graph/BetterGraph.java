package datastructure.graph;

public class BetterGraph {

	Vertex[] arrayOfList;
	int indexCounter = 0;
	boolean undirected = true;

	public BetterGraph(int vCount, String graphType) {
		if (graphType.equals("directed"))
			undirected = false;
		arrayOfList = new Vertex[vCount];
	}

	public void addVertex(String name) {
		arrayOfList[indexCounter] = new Vertex(name, null);
		indexCounter++;
	}

	public void addEdge(String srcName, String desName) {
		int srcIndex = indexForName(srcName);
		int desIndex = indexForName(desName);

		arrayOfList[srcIndex].adjlist = new Node(desIndex, arrayOfList[srcIndex].adjlist);
		if(undirected)
			arrayOfList[desIndex].adjlist = new Node(srcIndex, arrayOfList[desIndex].adjlist);
	}

	public int indexForName(String name) {
		for (int i = 0; i < arrayOfList.length; i++) {
			if (arrayOfList[i].name.equals(name))
				return i;
		}
		return -1;
	}
	
	public void print() {
		System.out.println();
		for(int i=0; i<arrayOfList.length; i++) {
			System.out.print(arrayOfList[i].name);
			for(Node node=arrayOfList[i].adjlist; node!=null; node=node.next) {
				System.out.print("--> "+arrayOfList[node.vertexIdx].name);
			}
			System.out.println("\n");
		}
	}

}
