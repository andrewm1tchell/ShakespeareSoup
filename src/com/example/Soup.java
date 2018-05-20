package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Speak
 */
@WebServlet(description = "Generate sentences like you are The Bard", urlPatterns = { "/Soupify" })
public class Soup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Soup() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GraphShakespeare stringGraph = new GraphShakespeare(request.getParameter("text"));
		String root = request.getParameter("root");
		String newWord = stringGraph.generateSentence(stringGraph.getStringGraph(), root);
		String sentence = root + " ";
		PrintWriter writer = response.getWriter();
		int count = 1;
		while (!newWord.equals(".") && !newWord.equals("!") && !newWord.equals(":") && !newWord.equals("?")) {
			if (newWord.equals("")) {
				if(count == 1) {
					sentence = "my apologies but I would never begin a sentence with that word!";
				}
				break;
			}
			sentence += newWord + " ";
			newWord = stringGraph.generateSentence(stringGraph.getStringGraph(), newWord);
			count++;
		}
		sentence = sentence.trim() + newWord;
		writer.println(sentence.substring(0, 1).toUpperCase() + sentence.substring(1));
	}

}
