package org.eda.lab2;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem)
	{
		// a�ade un elemento al comienzo
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> nuevo=new Node<>(elem);
		nuevo.prev=last;
		nuevo.next=last.next;
		last.next.prev=nuevo;
		last.next=nuevo;

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
		if(isEmpty() || !contains(target))
		{

		}
		else
		{

		}
	}

}
