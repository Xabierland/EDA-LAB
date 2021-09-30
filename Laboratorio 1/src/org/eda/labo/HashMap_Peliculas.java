package org.eda.labo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class HashMap_Peliculas {
    //Attributes
    private HashMap<String,Pelicula> mapa;
    private static HashMap_Peliculas miMapa = null;

    //Constructor
    private HashMap_Peliculas()
    {
        mapa=new HashMap<String,Pelicula>();
    }

    //Methods
    public static HashMap_Peliculas getMiMapa()
    {
        if(miMapa==null)
        {
            miMapa=new HashMap_Peliculas();
        }
        return miMapa;
    }

    public void anadirEntrada(String key, Pelicula valor)
    {
        if(!mapa.containsKey(key))
            mapa.put(key, valor);
    }

    public Pelicula buscarPelicula(String key)
    {
        if(key==null) {
            System.out.println("\nIntroduce el nombre de la pelicula");
            Scanner sn = new Scanner(System.in);
            key = sn.nextLine();
        }
        return mapa.get(key);
    }


    public String escribirContenido()
    {
        String contenido="";
        String sub0;
        String sub1;
        for(Map.Entry<String, Pelicula> entry :mapa.entrySet())
        {
            boolean primero=true;           //Indica que es el primer actor de la lista de la pelicula
            String sub2="";                 //Aqui se guardan la lista de actores separada
            String Titulo = entry.getKey(); //El titulo de la pelicula
            sub1=Titulo.concat(" --->>> "); //Se pone el separador del titulo
            for(Actor a : entry.getValue().getLista())
            {
                if(primero)
                {
                    primero=false;
                }
                else
                {
                    sub2=sub2.concat(" ##### ");
                }
                sub2=sub2.concat(a.getNombre());
            }
            sub0=sub1.concat(sub2);
            sub0=sub0.concat("\n");
            contenido=contenido.concat(sub0);
        }
        return contenido;
    }

    public void reset()
    {
        mapa.clear();
    }
}

