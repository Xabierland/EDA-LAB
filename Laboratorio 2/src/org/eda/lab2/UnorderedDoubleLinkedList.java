package org.eda.lab2;

public class UnorderedDoubleLinkedList<T extends Comparable<T>> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem)
	{
		// a�ade un elemento al comienzo
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> nuevo = new Node<>(elem);
		if(last==null)
		{
			last=nuevo;
			last.next=last;
			last.prev=last;
		}
		else
		{
			nuevo.prev = last;
			nuevo.next = last.next;
			last.next.prev = nuevo;
			last.next = nuevo;
		}
		count++;

	}

	public void addToRear(T elem)
	{
		// a�ade un elemento al final
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		addToFront(elem);
		last=last.next;
	}
	
	public void addAfter(T elem, T target)
	{
		// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
		// �COMPLETAR OPCIONAL!
		count++;
		if(last==null)
		{
			last=new Node<>(elem);
			last.next=last;
			last.prev=last;
		}
		else if(!contains(target))
		{
			Node<T> primero=last.next;
			last.next=new Node<>(elem);
			last.next.next=primero;
			last.next.prev=last;
			primero.prev=last.next;
			last=last.next;
		}
		else
		{
			Node<T> actual=last.next;
			Node<T> previo=last.next;
			while(!previo.data.equals(target))
			{
				previo=actual;
				actual=actual.next;
			}
			previo.next=new Node<>(elem);
			previo.next.next=actual;
			previo.next.prev=previo;
			actual.prev=previo.next;
			if(previo.equals(last))
			{
				last=last.next;
			}
		}
	}

}
