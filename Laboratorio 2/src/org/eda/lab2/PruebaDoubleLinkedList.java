package org.eda.lab2;

import java.util.Iterator;


public class PruebaDoubleLinkedList {
	public static void main(String[] args)
	{
		UnorderedDoubleLinkedList<Integer> l = new UnorderedDoubleLinkedList<>();

		System.out.println("\nPrueba addToRear");
		l.addToRear(4);
		l.addToRear(5);
		l.addToRear(6);

		if(l.size()==3)
		{
			System.out.print("La lista creada es: ");l.visualizarNodos();
			System.out.println("La lista deveria ser: [4][5][6]");
		}
		else
		{
			System.out.println("Error en addToRear | Lista resultado: ");l.visualizarNodos();
		}

		System.out.println("\nPrueba addToFront");
		l.addToFront(3);
		l.addToFront(2);
		l.addToFront(1);

		if(l.size()==6)
		{
			System.out.print("La lista creada es: ");l.visualizarNodos();
			System.out.println("La lista deveria ser: [1][2][3][4][5][6]");
		}
		else
		{
			System.out.print ("Error en addToFront | Lista resultado: ");l.visualizarNodos();
		}

		System.out.println("\nPrueba addAfter");
		l.addAfter(7,6);
		l.addAfter(5,5);
		l.addAfter(9,10);

		if(l.size()==9)
		{
			System.out.print("La lista creada es: ");l.visualizarNodos();
			System.out.println("La lista deveria ser: [1][2][3][4][5][5][6][7][9]");
		}
		else
		{
			System.out.print("Error en addAfter | Nodo resultado: ");l.visualizarNodos();
		}

		System.out.println("\nPrueba remove");
		l.remove(9);
		l.remove(5);

		if(l.size()==7)
		{
			System.out.print("La lista creada es: ");l.visualizarNodos();
			System.out.println("La lista deveria ser: [1][2][3][4][5][6][7]");
		}
		else
		{
			System.out.print("Error en remove | Nodo resultado: ");l.visualizarNodos();
		}

		System.out.println("\nPrueba removeLast");
		l.removeLast();
		l.removeLast();

		if(l.size()==5)
		{
			System.out.print("La lista creada es: ");l.visualizarNodos();
			System.out.println("La lista deveria ser: [1][2][3][4][5]");
		}
		else
		{
			System.out.print("Error en removeLast | Nodo resultado: ");l.visualizarNodos();
		}

		System.out.println("\nPrueba removeFirst");
		l.removeFirst();
		l.removeFirst();

		if(l.size()==3)
		{
			System.out.print("La lista creada es: ");l.visualizarNodos();
			System.out.println("La lista deveria ser: [3][4][5]");
		}
		else
		{
			System.out.print("Error en removeFirst | Nodo resultado: ");l.visualizarNodos();
		}

		System.out.println("\n Set & Get description");
		l.setDescr("Lista de numeros");
		System.out.println("La descripcion es: "+l.getDescr());
		System.out.println("La descripcion deveria ser: Lista de numeros");

		System.out.println("\nPrueba contains");

		if(l.size()==3)
		{
			l.visualizarNodos();
			if(l.contains(1))
			{
				System.out.println("Error");
			}
			else
			{
				System.out.println("No encontrado [1]");
			}
			if(l.contains(3))
			{
				System.out.println("Encontrado [3]");
			}
			else
			{
				System.out.println("Error");
			}
			if(l.contains(5))
			{
				System.out.println("Encontrado [5]");
			}
			else
			{
				System.out.println("Error");
			}
			if(l.contains(6))
			{
				System.out.println("Error");
			}
			else
			{
				System.out.println("No encontrado [6]");
			}

		}
		else
		{
			System.out.print("Error en find | Nodo resultado: ");l.visualizarNodos();
		}

		System.out.println("\nPrueba contains");

		if(l.size()==3)
		{
			l.visualizarNodos();
			if(l.find(1)!=null)
			{
				System.out.println("Error");
			}
			else
			{
				System.out.println("No encontrado [1]");
			}
			if(l.find(3)!=null)
			{
				System.out.println("Encontrado [3]");
			}
			else
			{
				System.out.println("Error");
			}
			if(l.find(5)!=null)
			{
				System.out.println("Encontrado [5]");
			}
			else
			{
				System.out.println("Error");
			}
			if(l.find(6)!=null)
			{
				System.out.println("Error");
			}
			else
			{
				System.out.println("No encontrado [6]");
			}

		}
		else
		{
			System.out.print("Error en find | Nodo resultado: ");l.visualizarNodos();
		}

		System.out.println("\nPrueba first & last");
		if(l.size()==3)
		{
			System.out.println("El primer elemento es: "+l.first());
			System.out.println("Y deberia de ser: [3]");
			System.out.println("El ultimo elemento es: "+l.last());
			System.out.println("Y deberia de ser: [5]");
		}
		else
		{
			System.out.print("Error en removeFirst | Nodo resultado: ");l.visualizarNodos();
		}

	}
}
