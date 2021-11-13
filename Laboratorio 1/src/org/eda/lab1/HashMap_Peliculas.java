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

    public Pelicula add(String pTitulo)
    {
        if(pTitulo==null)
        {
            System.out.println("Introduce el nombre del pelicula a añadir");
            Scanner sn=new Scanner(System.in);
            pTitulo=sn.nextLine();
        }

        if(!mapa.containsKey(pTitulo)) {
            Pelicula unaPeli=new Pelicula(pTitulo);
            mapa.put(pTitulo, unaPeli);
        }

        return mapa.get(pTitulo);
    }

    public void remove(String pTitulo)
    {
        if(pTitulo==null)
        {
            System.out.println("Introduce el nombre del pelicula a borrar");
            Scanner sn=new Scanner(System.in);
            pTitulo=sn.nextLine();
        }
        mapa.remove(pTitulo);
    }

    public Pelicula get(String pTitulo)
    {
        if(pTitulo==null)
        {
            System.out.println("Introduce el nombre del pelicula a buscar");
            Scanner sn=new Scanner(System.in);
            pTitulo=sn.nextLine();
        }
        return mapa.getOrDefault(pTitulo, null);
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
        for(Map.Entry<String, Pelicula> entry :mapa.entrySet()) //OBTENGO CADA ENTRADA DEL HASHMAP
        {
            boolean primero=true;           //Indica que es el primer actor de la lista de la pelicula
            String lista_actores="";                 //Aqui se guardan la lista de actores separada
            String Titulo = entry.getKey(); //El titulo de la pelicula
            titulo_pelicula=Titulo.concat(" --->>> "); //Se pone el separador del titulo
            for(String s : entry.getValue().getListaActores())
            {
                Actor a=HashMap_Actores.getMiMapa().get(s);
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

