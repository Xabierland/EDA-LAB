package org.eda.lab1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

    /**
     * Contiene la unica instacia que existe de el Hash Maps de Actores
     * @return Devuelve un HashMap de Actores
     */
    public static HashMap_Actores getMiMapa()
    {
        if(miMapa==null)
        {
            miMapa=new HashMap_Actores();
        }
        return miMapa;
    }

    public Actor add(String pNombre)
    {
        if(pNombre==null)
        {
            System.out.println("Introduce el nombre del actor a añadir");
            Scanner sn=new Scanner(System.in);
            pNombre=sn.nextLine();
        }
        if(!mapa.containsKey(pNombre)) {
            Actor unActor = new Actor(pNombre);
            mapa.put(pNombre, unActor);
        }

        return mapa.get(pNombre);
    }

    public void remove(String pNombre)
    {
        if(pNombre==null)
        {
            System.out.println("Introduce el nombre del actor a borrar");
            Scanner sn=new Scanner(System.in);
            pNombre=sn.nextLine();
        }
        if(mapa.containsKey(pNombre))
        {
            Actor unActor=get(pNombre);
            String finalPNombre = pNombre;
            unActor.getListaPelicula().forEach((p)->
            {
                HashMap_Peliculas.getMiMapa().get(p).removeActor(finalPNombre);
            });
            mapa.remove(pNombre);
        }

    }

    public Actor get(String pNombre)
    {
        if(pNombre==null)
        {
            System.out.println("Introduce el nombre del actor a buscar");
            Scanner sn=new Scanner(System.in);
            pNombre=sn.nextLine();
        }
        return mapa.getOrDefault(pNombre, null);
    }

    /**
     * Obtiene todas las keys (nombres de actores) y los ordena usando QuickSort
     * @return devuelve un array con todos los nombres de los actores o keys.
     */
    private String [] getListaNombresActoresOrdenada()
    {
        String[] keys = mapa.keySet().toArray(new String[0]);
        if(keys.length>0)
            return StringQuickSort.getStringQuickSort().sort(keys);
        else
            return keys;
    }

    /**
     * Utilizando el metodo getListaNombresActoresOrdenados usa el array de keys ordenadas para obtener a sus
     * respectivos actores de forma ordenada
     * @return devuelve un ArrayList con los Actores de forma ordenada.
     */
    public ArrayList<Actor> getListaActoresOrdenada()
    {
        ArrayList<Actor> lista=new ArrayList<Actor>();
        for(String nombre_actor : getListaNombresActoresOrdenada())
        {
             lista.add(HashMap_Actores.getMiMapa().get(nombre_actor));
        }
        return lista;
    }

    /**
     * Borra todas las entradas del HashMap.
     */
    public void reset()
    {
        mapa.clear();
    }
}
