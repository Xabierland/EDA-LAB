package org.eda.labo;

import java.util.HashMap;
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
        if(mapa.containsKey(key))
            mapa.put(key, valor);
    }

    public Pelicula buscarPelicula(String pNombre)
    {
        if(pNombre==null) {
            System.out.println("\nIntroduce el nombre de la pelicula");
            Scanner sn = new Scanner(System.in);
            pNombre = sn.nextLine();
        }
        return mapa.get(pNombre);
    }

    public void reset()
    {
        mapa.clear();
    }
}

