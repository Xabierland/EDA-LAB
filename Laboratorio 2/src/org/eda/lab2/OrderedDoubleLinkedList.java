package org.eda.lab2;

public class OrderedDoubleLinkedList<T extends Comparable<T>> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem)
	{
		if(last==null)
		{
			last=new Node<>(elem);
			last.prev=last;
			last.next=last;
			count++;
		}
		else
		{
			Node<T> actual=last.next;
			Node<T> previo=last;
			if(previo.data.compareTo(elem)<0)
			{
				previo.next=new Node<>(elem);
				previo.next.prev=previo;
				previo.next.next=actual;
				actual.prev=previo.next;
				last=previo.next;
				count++;
			}
			else
			{
				boolean enc=false;
				while (!enc)
				{
					if(actual.data.compareTo(elem)>0)
					{
						enc=true;
					}
					else
					{
						previo=actual;
						actual=actual.next;
					}
				}
				previo.next=new Node<>(elem);
				previo.next.next=actual;
				previo.next.prev=previo;
				actual.prev=previo.next;
				count++;
			}
		}

	}
	public void merge(DoubleLinkedList<T> lista)
	{
		Node<T> actual=lista.last.next;
		Node<T> previo=lista.last.next;

		while(previo!=lista.last)
		{
			previo=actual;
			actual=actual.next;

			add(previo.data);
		}

	}


}
