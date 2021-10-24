package org.eda.lab2;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem)
	{
		if(last==null)
		{
			last=new Node<>(elem);
			last.prev=last;
			last.next=last;
		}
		else
		{
			Node<T> actual=last.next;
			Node<T> previo=last.next;

			actual.data

		}

	}
	public void merge(DoubleLinkedList<T> lista)
	{


	}


}
