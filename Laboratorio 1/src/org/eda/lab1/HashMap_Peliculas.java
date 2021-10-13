package org.eda.lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
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

    /**
     *
     * @return Devuelve la unica instancia del HashMap. Si no existe, la crea y la devuelve.
     */
    public static HashMap_Peliculas getMiMapa()
    {
        if(miMapa==null)
        {
            miMapa=new HashMap_Peliculas();
        }
        return miMapa;
    }

    /**
     * Añade una nueva pelicula al HashMap
     * @param key el nombre por el que se buscara la pelicula
     * @param valor el objeto pelicula que contendra su titulo, su recaudacion y una lista de actores que han trabajado en ella
     */
    public void anadirEntrada(String key, Pelicula valor)
    {
        if(!mapa.containsKey(key))
            mapa.put(key, valor);
    }

    /**
     * Recibiendo el nombre de la pelicula como parametro la busca y devuelve su instancia.
     * @param key el nombre de la pelicula
     * @return una instancia de pelicula al que le corresponde la key.
     */
    public Pelicula buscarPelicula(String key)
    {
        if(key==null) {
            System.out.println("\nIntroduce el nombre de la pelicula");
            Scanner sn = new Scanner(System.in);
            key = sn.nextLine();
        }
        return mapa.get(key);
    }

    /**
     * Escribe el contenido de todo el HashMap en un fichero.
     * @param fichero Recibe un fichero en el que se escriben los datos del HashMap
     * @throws IOException
     */
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

    /**
     * Resetea la unica instancia del HashMap.
     */
    public void reset()
    {
        mapa.clear();
    }
}

