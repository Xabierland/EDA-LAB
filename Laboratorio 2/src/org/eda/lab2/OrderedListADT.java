package org.eda.lab2;

public interface OrderedListADT<T extends Comparable<T>>  extends ListADT<T> {
	
	public void add(T elem);
	// A�ade un elemento a la lista.txt (en el lugar de orden que le corresponde)

	public void merge(DoubleLinkedList<T> zerrenda);

}
