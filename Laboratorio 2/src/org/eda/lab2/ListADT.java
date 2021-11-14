package org.eda.lab2;

import java.util.Iterator;

public interface ListADT<T> {

public void setDescr(String nom);
// Actualiza el nombre de la lista.txt

public String getDescr();
// Devuelve el nombre de la lista.txt

public T removeFirst();
//Elimina el primer elemento de la lista.txt

public T removeLast();
//Elimina el �ltimo elemento de la lista.txt

public T remove(T elem);
//Elimina un elemento concreto de la lista.txt

public T first();
//Da acceso al primer elemento de la lista.txt

public T last();
//Da acceso al �ltimo elemento de la lista.txt

public boolean contains(T elem);
//Determina si la lista.txt contiene un elemento concreto

public T find(T elem);
//Determina si la lista.txt contiene un elemento concreto, y develve su referencia, null en caso de que no est�

public boolean isEmpty();
//Determina si la lista.txt est� vac�a

public int size();
//Determina el n�mero de elementos de la lista.txt

public Iterator<T> iterator();

}
