package org.eda.lab1;

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

    /**
     * En caso de no existir ninguna entrada con la misma Key la crea y guarda el valor junto a ella.
     * En caso de que ya existiera actualiza el valor añadiendo la nueva Pelicula en la que aparece y lo vuelve a guardar
     * @param key un string al que se ligara un valor. Si recibe el valor null se pedira por teclado la key
     * @param valor un objeto de la clase Actor. No puede ser null a menos que la Key tambien lo sea.
     * @param pPeli en caso de que el HashMap ya contuviese la key dada se usara este valor para actualizar el valor ligada a ella
     */
    public void anadirActor(String key, Actor valor, Pelicula pPeli)
    {
        if(key==null)
        {
            System.out.println("Introduce el nombre del Actor a añadir");
            Scanner sn=new Scanner(System.in);
            key=sn.nextLine();
            if(valor==null)
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

    /**
     * Elimina todas las instancias de un actor tanto en el HashMap de Peliculas como en el propio HashMap de Actores
     * @param key El nombre del actor. En caso de ser null se le pedira al usuario insertar uno por teclado.
     */
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

    /**
     *
     * @param key El nombre del Actor. En caso de ser null se le pedira al usuario introducir uno por teclado
     * @return En caso de encontrar al actor ligado a la key se le devolvera. Si no se devolvera el valor null.
     */
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
             lista.add(HashMap_Actores.getMiMapa().buscarActor(nombre_actor));
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
