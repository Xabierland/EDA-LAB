package org.eda.lab2;

	public class Node<T extends Comparable<T>> {
		public T data; 			// dato del nodo
		public Node<T> next; 	// puntero al siguiente nodo de la lista.txt
		public Node<T> prev; 	// puntero al anterior nodo de la lista.txt
		// -------------------------------------------------------------

		public Node(T dd) 		// constructor
		{
			data = dd;
			next = null;
			prev = null;
		}
	}


