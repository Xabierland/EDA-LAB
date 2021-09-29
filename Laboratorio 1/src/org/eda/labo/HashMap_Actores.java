package org.eda.labo;

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
    @return Devuelve la unica instacia de HashMap de Actores
     */
    public static HashMap_Actores getMiMapa()
    {
        if(miMapa==null)
        {
            miMapa=new HashMap_Actores();
        }
        return miMapa;
    }

    public void anadirEntrada(String key, Actor valor)
    {
        mapa.putIfAbsent(key, valor);
    }

    public Actor buscarActor()
    {
        System.out.println("\nIntroduce el nombre del actor");
        Scanner sn=new Scanner(System.in);
        String nombre = sn.nextLine();
        return mapa.get(nombre);
    }

    public void reset()
    {
        mapa.clear();
    }
}
