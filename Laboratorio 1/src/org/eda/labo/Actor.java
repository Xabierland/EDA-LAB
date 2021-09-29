package org.eda.labo;

import java.util.ArrayList;

public class Actor
{
    //Attributes
    private String nombre;
    private ArrayList<Pelicula> lista= new ArrayList<Pelicula>();

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

    public void anadirPeliculaAMapa(Pelicula unaPelicula)
    {
        if(!lista.contains(unaPelicula))
        {
            lista.add(unaPelicula);
        }
    }

    public void imprimirLista()
    {
        for (Pelicula pelicula : lista)
        {
            System.out.println(pelicula.getNombre());
        }
    }
}
