package com.example;

import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import org.jgrapht.*;
import org.jgrapht.alg.*;
import org.jgrapht.graph.*;
import java.util.Scanner;

public class GraphShakespeare {
	private DirectedGraph<String, DefaultEdge> stringGraph;

	private String text;

	public GraphShakespeare(String text) {
		this.setText(text);
		this.setStringGraph(createGraph());
	}

	private DirectedGraph<String, DefaultEdge> createGraph() {
		try {
			Document doc = Jsoup.connect(this.getText()).get();
			String block = "";
			Elements quotes = doc.select("blockquote");
			for (Element quote : quotes) {
				Elements lines = quote.select("a");
				for (Element line : lines) {
					String text = line.text();
					String firstTwo = text.substring(0, 2);
					String temp = firstTwo.toUpperCase();
					if (!(firstTwo.equals(temp) && (Character) text.charAt(1) != ' '
							&& (Character) text.charAt(0) != '[')) {
						if ((Character) text.charAt(0) == '[') {
							text = (text.substring(text.indexOf("]") + 1)).trim();
						}
						if (!text.equals("")) {
							block += text + " ";
						}
					}
				}
			}
			String[] splitBlock = block.split("\\s+");
			ArrayList<String> words = new ArrayList<String>();

			for (int i = 0; i < splitBlock.length; i++) {
				String lastChar = splitBlock[i].substring(splitBlock[i].length() - 1);
				if (lastChar.equals(".") || lastChar.equals(":") || lastChar.equals("?") || lastChar.equals("!")
						|| lastChar.equals(",") || lastChar.equals(";")) {
					words.add(splitBlock[i].substring(0, splitBlock[i].length() - 1));
					words.add(lastChar);
				} else {
					words.add(splitBlock[i].toLowerCase());
				}
			}
			Random ran = new Random();
			int x = ran.nextInt(words.size());
			DirectedGraph<String, DefaultEdge> stringGraph = createStringGraph(words);
			return stringGraph;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String generateSentence(DirectedGraph<String, DefaultEdge> stringGraph, String root) {
		if (stringGraph.containsVertex(root)) {
			Set<DefaultEdge> edges = stringGraph.edgesOf(root);
			ArrayList<String> edgeList = new ArrayList<String>();
			for (DefaultEdge e : edges) {
				if (!stringGraph.getEdgeTarget(e).equals(root)) {
					edgeList.add(stringGraph.getEdgeTarget(e));
				}
			}
			Random ran = new Random();
			int x = ran.nextInt(edgeList.size());
			String next = edgeList.get(x);
			return next;
		} else {
		//	System.out.println("No word exists");
			return "";
		}
	}

	public static DirectedGraph<String, DefaultEdge> createStringGraph(ArrayList<String> words) {
		DirectedGraph<String, DefaultEdge> g = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);

		// String[] words = {"I", "am", "a", "human", ".", "I", "am", "always",
		// "a", "human", ".", "I", "love", "a", "dog", ".", "She", "will",
		// "always", "love", "me", "."};

		// add the vertices
		for (int i = 0; i < words.size() - 2; i++) {
			String word1 = words.get(i);
			String word2 = words.get(i + 1);
			if (word2.equals(".") || word2.equals(":") || word2.equals("?") || word2.equals("!")) {
				i++;
			}
			g.addVertex(word1);
			g.addVertex(word2);
			g.addEdge(word1, word2);
		}

		// add edges to create a circuit

		return g;
	}

	public DirectedGraph<String, DefaultEdge> getStringGraph() {
		return stringGraph;
	}

	public void setStringGraph(DirectedGraph<String, DefaultEdge> stringGraph) {
		this.stringGraph = stringGraph;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		switch(text) {
			case "merchantofvenice":
				this.text = "http://shakespeare.mit.edu/merchant/full.html";
				break;
			case "merrywives":
				this.text = "http://shakespeare.mit.edu/merry_wives/full.html";
				break;
			case "macbeth":
				this.text = "http://shakespeare.mit.edu/macbeth/full.html";
				break;
			default:
				this.text = text;
		}
	}
}