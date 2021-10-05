package org.eda.labo;

import java.io.FileWriter;
import java.io.IOException;
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


    public void escribirContenido(FileWriter fichero) throws IOException {
        long statTime=System.nanoTime();
        String linea;
        String titulo_pelicula;
        for(Map.Entry<String, Pelicula> entry :mapa.entrySet())
        {
            boolean primero=true;           //Indica que es el primer actor de la lista de la pelicula
            String lista_actores="";                 //Aqui se guardan la lista de actores separada
            String Titulo = entry.getKey(); //El titulo de la pelicula
            titulo_pelicula=Titulo.concat(" --->>> "); //Se pone el separador del titulo
            for(Actor a : entry.getValue().getLista())
            {
                if(primero)
                {
                    primero=false;
                }
                else
                {
                    lista_actores=lista_actores.concat(" ##### ");
                }
                lista_actores=lista_actores.concat(a.getNombre());
            }
            linea=titulo_pelicula.concat(lista_actores);
            linea=linea.concat("\n");       //SALTO DE LINEA
            fichero.write(linea);

        }
        long endTime=System.nanoTime();
        System.out.println(((endTime-statTime)/1000000000)+" segundos a tardado en ejecutarse");
    }

    public void reset()
    {
        mapa.clear();
    }
}

