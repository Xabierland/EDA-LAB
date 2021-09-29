package org.eda.labo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HashMap_Actores
{
    //Attributes
    private HashMap<String,Actor> mapa;
    private static HashMap_Actores miMapa = null;

    //Constructor
    private HashMap_Actores()
    {
        mapa=new HashMap<String,Actor>();
    }

    //Methods

    /*
     * @return Devuelve la unica instacia de HashMap de Actores
     */
    public static HashMap_Actores getMiMapa()
    {
        if(miMapa==null)
        {
            miMapa=new HashMap_Actores();
        }
        return miMapa;
    }

    public void anadirActor(String key, Actor valor, Pelicula pPeli)
    {
        if(key==null)
        {
            System.out.println("Introduce el nombre del Actor a añadir");
            Scanner sn=new Scanner(System.in);
            key=sn.nextLine();
            valor=new Actor(key);
        }
        if (!mapa.containsKey(key))
        {
            mapa.put(key, valor);
        }
        else
        {
            Actor unActor=mapa.get(key);
            unActor.anadirPeliculaALista(pPeli);
            mapa.remove(key);
            mapa.put(key,unActor);
        }
    }

    public void eliminarActor(String key)
    {
        if(key==null)
        {
            System.out.println("Cual es el nombre del actor a eliminar");
            Scanner sn=new Scanner(System.in);
            key=sn.nextLine();
        }

        Actor unActor=buscarActor(key);
        if (unActor!=null)
        {
            ArrayList<Pelicula> lista=unActor.getListaPelicula();
            for(Pelicula peli : lista)
            {
                HashMap_Peliculas.getMiMapa().buscarPelicula(peli.getNombre()).eliminarActorDeLista(unActor);
            }
            mapa.remove(key);
        }
        else
        {
            System.out.println("No se ha encontrado actor con ese nombre");
        }
    }

    public Actor buscarActor(String key)
    {
        if(key==null)
        {
            System.out.println("\nIntroduce el nombre del actor");
            Scanner sn=new Scanner(System.in);
            key = sn.nextLine();
        }
        if (mapa.containsKey(key))
        {
            return mapa.get(key);
        }
        else {
            System.out.println("No se ha encontrado Actor con ese nombre");
            return null;
        }
    }

    public void reset()
    {
        mapa.clear();
    }
}
