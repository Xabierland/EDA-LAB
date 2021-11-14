package org.eda.lab2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T extends Comparable<T>> implements ListADT<T> {

	// Atributos
	protected Node<T> last;  // apuntador al �ltimo
	protected String descr;  // descripci�n
	protected int count;

	// Constructor
	public DoubleLinkedList()
	{
		last = null;
		descr = "";
		count = 0;
	}
	
	public void setDescr(String nom)
	{
		descr = nom;
	}

	public String getDescr()
	{
		return descr;
	}

	public T removeFirst()
	{
	// Elimina el primer elemento de la lista.txt
        // Precondici�n: 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> actual=last.next;
		last.next.next.prev=last;
		last.next=actual.next;
		count--;
		return actual.data;
	}

	public T removeLast()
	{
		// Elimina el �ltimo elemento de la lista.txt
		// Precondici�n:
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		last.prev.next=last.next;
		last.next.prev=last.prev;
		last=last.prev;
		count--;
		return last.data;
	}

	public T remove(T elem)
	{
		//Elimina un elemento concreto de la lista.txt
		Node<T> actual=last.next;
		boolean enc=false;
		if(actual.data.equals(elem))
		{
			removeFirst();
			return actual.data;
		}
		else if(last.data.equals(elem))
		{
			removeLast();
			return last.data;
		}
		else
		{
			while (!actual.equals(last) && !enc)
			{
				if (actual.data.equals(elem))
				{
					enc = true;
				}
				else
				{
					actual = actual.next;
				}
			}
			if (!enc)
			{
				return null;
			}
			else
			{
				actual.prev.next = actual.next;
				actual.next.prev = actual.prev;
				count--;
				return actual.data;
			}
		}
	}

	public T first()
	{
		//Da acceso al primer elemento de la lista.txt
		if (isEmpty())
			return null;
		else return last.next.data;
	}

	public T last()
	{
		//Da acceso al �ltimo elemento de la lista.txt
		if (isEmpty())
			return null;
		else return last.data;
	}

	public boolean contains(T elem) {
		//Determina si la lista.txt contiene un elemento concreto
		if (isEmpty())
		{
			return false;
		}
		else if(last.data.equals(elem))
		{
			return true;
		}
		else
		{
			Node<T> actual=last.next;
			boolean enc=false;
			while(!actual.equals(last)&&!enc)
			{
				if(actual.data.equals(elem))
				{
					enc=true;
				}
				else
				{
					actual=actual.next;
				}
			}
			return enc;
		}
	}

	public T find(T elem)
	{
		//Determina si la lista.txt contiene un elemento concreto, y develve su referencia, null en caso de que no est�
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if (isEmpty())
		{
			return null;
		}
		else if(last.data.equals(elem))
		{
			return last.data;
		}
		else
		{
			Node<T> actual=last.next;
			boolean enc=false;
			while(!actual.equals(last)&&!enc)
			{
				if(actual.data.equals(elem))
				{
					enc=true;
				}
				else
				{
					actual=actual.next;
				}
			}
			if(!enc)
			{
				return null;
			}
			else
			{
				return actual.data;
			}
		}
	}

	public boolean isEmpty() 
	//Determina si la lista.txt est� vac�a
	{
		return last == null;
	}
	
	public int size() 
	//Determina el n�mero de elementos de la lista.txt
	{
		return count;
	}
	
	/** Return an iterator to the stack that iterates through the items . */ 
	public Iterator<T> iterator()
	{
		return new ListIterator();
	}

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator implements Iterator<T>
	{
		private Node<T>	actual=last.next;
		private Node<T> previo=last.next;

		@Override
		public boolean hasNext()
		{
			return previo != last;
		}

		@Override
		public T next() {
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			else
			{
				previo=actual;
				T data = previo.data;
				actual=actual.next;
				return data;
			}
		}
	} // private class

	public void visualizarNodos()
	{
		System.out.print(this.toString());
	}

	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder("");
		Iterator<T> it = iterator();
		while (it.hasNext())
		{
			T elem = it.next();
			result.append("[").append(elem.toString()).append("]");
		}
		return result + "\n";
	}

}
