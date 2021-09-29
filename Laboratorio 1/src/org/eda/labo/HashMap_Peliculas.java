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
        mapa.putIfAbsent(key, valor);
    }

    public Pelicula buscarPelicula()
    {
        System.out.println("\nIntroduce el nombre de la pelicula");
        Scanner sn=new Scanner(System.in);
        String Title = sn.nextLine();
        return mapa.get(Title);
    }

    public void reset()
    {
        mapa.clear();
    }
}

