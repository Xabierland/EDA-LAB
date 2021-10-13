package org.eda.lab1;

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

    /**
     * Comprueba si el actor recibido como parametro y el objeto en cuestion tienen el mismo nombre.
     * @param pActor un Actor al que se le comparara el nombre
     * @return True si tienen el mismo nombre, False si tiene distinto nombre
     */
    public boolean tienenMismoNombre(Actor pActor)
    {
        return Objects.equals(this.nombre, pActor.nombre);
    }

    /**
     * Comprueba si la pelicula esta en la lista del actor y si no la añade.
     * @param unaPelicula la instancia de la pelicula a añadir a la lista del actor
     */
    public void anadirPeliculaALista(Pelicula unaPelicula)
    {
        if(!lista.contains(unaPelicula))
        {
            lista.add(unaPelicula);
        }
    }

    /**
     * Devuelve la lista de peliculas en las que ha trabajado un actor
     * @return Devuelve la lista de peliculas en las que ha trabajado un actor
     */
    public ArrayList<Pelicula> getListaPelicula()
    {
        return lista;
    }

    /**
     * Recorre la lista de peliculas y la imprime por pantalla.
     */
    public void imprimirLista()
    {
        for (Pelicula pelicula : lista)
        {
            System.out.println(pelicula.getNombre());
        }
    }
}
