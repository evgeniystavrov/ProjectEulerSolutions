package ru.evgs.solutions.task15;

/*
	Начиная в левом верхнем углу сетки 2×2 и имея возможность двигаться только вниз или вправо, 
	существует ровно 6 маршрутов до правого нижнего угла сетки.

	Сколько существует таких маршрутов в сетке 20×20?
*/

import java.util.*;

public class Solution15 {
	// фиксируем количество рёбер образующих строну таблицы
	private static final int EDGE_COUNT = 2;

	public static void main(String[] args){
		System.out.println(new Solution15().run());
	}

	protected String run() {
		int count = 0;
		PathesGraph pathesGraph = new PathesGraph();
		// добавляем вершины в граф
		for (int i = 1; i < (EDGE_COUNT * EDGE_COUNT + 1); i++) {
			pathesGraph.addVertex(i);
		}
		// формируем шаблон графа
		int[][] graphPattern = new int[EDGE_COUNT + 1][EDGE_COUNT + 1];
		int k = 0;
		for (int i = 0; i <= EDGE_COUNT + 1; i++) {
			for (int j = 0; j <= EDGE_COUNT + 1; j++) {
				graphPattern[i][j] = k++;
			}
		}
		// связываем вершины
		for (int i = 0; i < EDGE_COUNT + 1; i++) {
			if (i == EDGE_COUNT) {
				for (int j = 0; j < EDGE_COUNT; j++) {
					pathesGraph.addEdge(graphPattern[i][j], graphPattern[i][j + 1]);
				}
			}
			for (int j = 0; j < EDGE_COUNT + 1; j++) {
				if (j == EDGE_COUNT) {
					pathesGraph.addEdge(graphPattern[i][j], graphPattern[i + 1][j]);
				}
				pathesGraph.addEdge(graphPattern[i][j], graphPattern[i][j + 1]);
				pathesGraph.addEdge(graphPattern[i][j], graphPattern[i + 1][j]);
			}
		}


		return Integer.toString(count);
	}
	// граф путей
	private class PathesGraph {
		// карта графа
		private HashMap<Integer, List<Integer>> vertexMap = new HashMap<>();
		// добавление вершины
		private void addVertex(Integer vertexName) {
			// если вершины нет
			if (!hasVertex(vertexName)) {
				// то добавлем её в карту со списком рёбер
				vertexMap.put(vertexName, new ArrayList<Integer>());
			}
		}
		// проверка на наличие вершины
		private boolean hasVertex(Integer vertexName) {
			return vertexMap.containsKey(vertexName);
		}
		// проверка на наличие общего ребра
		private boolean hasEdge(Integer vertexName1, Integer vertexName2) {
			// есть ли вообще такая вершина
			if (!hasVertex(vertexName1)) return false;
			// получаем список рёбер вершины
			List<Integer> edges = vertexMap.get(vertexName1);
			// ищем такой же список у второй вершины
			return Collections.binarySearch(edges, vertexName2) != -1;
		}
		// добавление ребра вершинам
		private void addEdge(Integer vertexName1, Integer vertexName2) {
			// если вершин нет то добавляем
			if (!hasVertex(vertexName1)) addVertex(vertexName1);
			if (!hasVertex(vertexName2)) addVertex(vertexName2);
			// получаем список рёбер первой вершины
			List<Integer> edges1 = vertexMap.get(vertexName1);
			// добавляем в этот список вторую вершину
			edges1.add(vertexName2);
			// сортируем список рёбер
			Collections.sort(edges1);
		}
		// построение маршрутов


		// просмотр карты графа
		private Map<Integer, List<Integer>> getVertexMap() {
			return vertexMap;
		}
	}
}