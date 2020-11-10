package datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionInDirectedGraph {

	public static boolean cycleFound(int v, int[][] graph) {

		int[] visited = new int[v];
		List<Integer>[] adjList = new ArrayList[v];
		for (int i = 0; i < v; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int[] data : graph) {
			adjList[data[0]].add(data[1]);
		}
		if (!dfs(adjList, visited, 0))
			return false;
		return true;
	}

	private static boolean dfs(List<Integer>[] adjList, int[] visited, int i) {
		if (visited[i] == 1)
			return true;
		visited[i] = 1;
		for (int data : adjList[i])
			dfs(adjList, visited, data);
		visited[i] = 2;
		return false;
	}

	public static void main(String[] args) {
		int[][] graph = new int[][] { { 0, 1 }, { 0, 2 }, { 3, 0 }, { 2, 3 } };
		System.out.println(cycleFound(4, graph));
	}

}
