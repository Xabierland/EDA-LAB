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
     * @param unActor
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
     * @param unActor
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
        if (!esta)
        {
            unActor=null;
        }
        return unActor;
    }

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

    public ArrayList<Actor> getLista()
    {
        return lista;
    }

    public void imprimirLista()
    {
        for (Actor actor : lista) {
            System.out.println(actor.getNombre());
        }
    }
}