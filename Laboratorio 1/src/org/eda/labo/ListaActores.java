package org.eda.labo;

import java.util.*;

public class ListaActores
{
    //Atributos
    private static ListaActores miListaActores=null;
    private ArrayList<Actor> lista;

    //Constructor
    private ListaActores()
    {
        lista=new ArrayList<Actor>();
    }

    //Metodos
    public static ListaActores getMiListaActores()
    {
        if(miListaActores==null) {
            miListaActores = new ListaActores();
        }
        return miListaActores;
    }

    private Iterator<Actor> getIterator()
    {
        return lista.iterator();
    }

    public void anadirActorALista(Actor unActor)
    {
        if(!lista.contains(unActor))
            lista.add(unActor);
    }

    public Actor buscarActor()
    {
        System.out.println("Introduce el nombre del actor a buscar");
        Scanner sn=new Scanner(System.in);
        String pNombre=sn.nextLine();
        Iterator<Actor> itr= getIterator();
        Actor unActor=null;
        boolean enc=false;
        while(itr.hasNext()&&!enc)
        {
            unActor=itr.next();
            if(Objects.equals(unActor.getNombre(), pNombre))
            {
                enc=true;
            }
        }
        if(!enc)
        {
            unActor=null;
        }
        return unActor;
    }
}
