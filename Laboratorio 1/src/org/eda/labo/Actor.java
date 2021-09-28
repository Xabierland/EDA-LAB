package org.eda.labo;

import java.util.ArrayList;
import java.util.Objects;

public class Actor
{
    //Atributos
    private String nombre;
    private ArrayList<Pelicula> lista= new ArrayList<Pelicula>();

    //Contructora
    public Actor(String pNombre)
    {
        nombre=pNombre;
    }

    public String getNombre()
    {
        return nombre;
    }
}
