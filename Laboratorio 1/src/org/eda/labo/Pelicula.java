package org.eda.labo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class Pelicula
{
    //Attributes
    private String Titulo;
    private float Recaudacion;
    private ArrayList<Actor> lista = new ArrayList<Actor>();

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
    public String getNombre ()
    {
        return this.Titulo;
    }

    /**
     * Incrementa la recaudacion ligada a una pelicula
     * @param pValor no puede ser negativo
     */
    public void incrementarRecaudacion(float pValor)
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

    /**
     * Si el actor no es encuentra en la lista lo añade
     * @param unActor la instancia de un actor a añadir a la lista de la pelicula
     */
    public void anadirActorALista(Actor unActor)
    {
        if(!actorEstaEnLista(unActor))
        {
            lista.add(unActor);
        }
        else
        {
            System.out.println("El actor ya esta en la lista");
        }
    }

    /**
     * Busca en la lista de actores de la pelicula al actor recibido como parametro y lo elimina de la lista.
     * @param unActor la instancia de un Actor a eliminar de la lista de peliculas
     */
    public void eliminarActorDeLista(Actor unActor)
    {
        if(actorEstaEnLista(unActor))
        {
            System.out.println("Actor "+unActor.getNombre()+" eliminado de "+getNombre());
            lista.remove(actorBuscarEnLista(unActor));
        }
        else
        {
            System.out.println("El actor no estaba en la lista");
        }
    }

    /**
     * Busca un actor en el ArrayList de la pelicula
     * @param pActor recibe la instancia del actor a buscar en la lista y compara su nombre.
     * @return Devuelve el actor con el mismo nombre de la lista.
     */
    public Actor actorBuscarEnLista(Actor pActor)
    {
        Iterator<Actor> itr=lista.iterator();
        boolean esta=false;
        Actor unActor=null;
        while(itr.hasNext()&&!esta)
        {
            unActor=itr.next();
            if(unActor.tienenMismoNombre(pActor))
            {
                esta=true;
            }
        }
        if(!esta)
        {
            unActor=null;
        }
        return unActor;
    }

    /**
     * Devuelve un booleano indicando si el actor esta en lista
     * @param pActor la instancia de Actor a buscar
     * @return un booleando que indica si el actor esta en lista (True) o no lo esta (False)
     */
    public boolean actorEstaEnLista(Actor pActor)
    {
        Iterator<Actor> itr=lista.iterator();
        boolean esta=false;
        Actor unActor=null;
        while(itr.hasNext()&&!esta)
        {
            unActor=itr.next();
            if(unActor.tienenMismoNombre(pActor))
            {
                esta=true;
            }
        }
        return esta;
    }

    /**
     * Devuelve la lista de Actores ligada a una pelicula
     * @return La lista de actores ligada a la pelicula
     */
    public ArrayList<Actor> getLista()
    {
        return lista;
    }

    /**
     * Imprime la lista de actores de la pelicula por consola
     */
    public void imprimirLista()
    {
        for (Actor actor : lista) {
            System.out.println(actor.getNombre());
        }
    }
}