package org.eda.lab1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Actor
{
    //Attributes
    private String nombre;
    private HashSet<String> listaPeliculas = new HashSet<>();

    //Constructor
    public Actor(String pNombre)
    {
        nombre=pNombre;
    }

    //Methods
    public String getNombre()
    {
        return nombre;
    }

    public void addPelicula(String pTitulo)
    {
        listaPeliculas.add(pTitulo);
    }

    public void removePelicula(String pTitulo)
    {
        listaPeliculas.remove(pTitulo);
    }

    public Pelicula getPelicula(String pTitulo)
    {
        return HashMap_Peliculas.getMiMapa().get(pTitulo);
    }


    /**
     * Devuelve la lista de peliculas en las que ha trabajado un actor
     * @return Devuelve la lista de peliculas en las que ha trabajado un actor
     */
    public HashSet<String> getListaPelicula()
    {
        return listaPeliculas;
    }

    /**
     * Recorre la lista de peliculas y la imprime por pantalla.
     */
    public void imprimirLista()
    {
        listaPeliculas.forEach(System.out::println);
    }
}
