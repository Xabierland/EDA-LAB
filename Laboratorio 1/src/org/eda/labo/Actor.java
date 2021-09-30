package org.eda.labo;

import java.util.ArrayList;
import java.util.Objects;

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

    public boolean tienenMismoNombre(Actor pActor)
    {
        return Objects.equals(this.nombre, pActor.nombre);
    }

    public void anadirPeliculaALista(Pelicula unaPelicula)
    {
        if(!lista.contains(unaPelicula))
        {
            lista.add(unaPelicula);
        }
    }

    public ArrayList<Pelicula> getListaPelicula()
    {
        return lista;
    }

    public void imprimirLista()
    {
        for (Pelicula pelicula : lista)
        {
            System.out.println(pelicula.getNombre());
        }
    }
}
