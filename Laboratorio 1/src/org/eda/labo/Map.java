package org.eda.labo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Map {
    //Attributes
    private HashMap<String,Pelicula> mapa;
    private static Map miMapa = null;

    //Constructor
    private Map()
    {
        mapa=new HashMap<String,Pelicula>();
    }

    //Methods
    public static Map getMiMapa()
    {
        if(miMapa==null)
        {
            miMapa=new Map();
        }
        return miMapa;
    }

    public void anadirEntrada(String key, Pelicula valor)
    {
        mapa.put(key, valor);
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

