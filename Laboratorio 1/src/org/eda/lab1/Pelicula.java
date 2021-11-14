package org.eda.lab1;

import java.util.*;

public class Pelicula
{
    //Attributes
    private String Titulo;
    private float Recaudacion;
    private HashSet<String> listaActores = new HashSet<>();

    //Constructor
    public Pelicula(String pTitulo)
    {
        this.Titulo=pTitulo;
        this.Recaudacion=0;
    }

    //Methods

    /**
     *
     * @return Devuelve el nombre de la pelicula
     */
    public String getNombre()
    {
        return this.Titulo;
    }

    /**
     * Incrementa la recaudacion ligada a una pelicula
     * @param pValor no puede ser negativo
     */
    public void incrRecaudacion(float pValor)
    {
        if(pValor<0)
        {
        System.out.println("\nIntroduce el valor de la recaudacion a aumentar");
        Scanner sn=new Scanner(System.in);
        pValor=sn.nextFloat();
        }

        Recaudacion+=pValor;
        System.out.println("Esta pelicula a recudado "+Recaudacion+"$");
    }

    public void addActor(String pNombre)
    {
        listaActores.add(pNombre);
    }

    public void removeActor(String pNombre)
    {
        listaActores.remove(pNombre);
    }

    public Actor getActor(String pNombre)
    {
        return HashMap_Actores.getMiMapa().get(pNombre);
    }

    public HashSet<String> getListaActores()
    {
        return listaActores;
    }
    
    /**
     * Imprime la lista.txt de actores de la pelicula por consola
     */
    public void imprimirLista()
    {
        listaActores.forEach(System.out::println);
    }
}