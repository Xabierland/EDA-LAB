package org.eda.labo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Fichero
{
    private final String Dir;
    private static Fichero miFichero=null;

    //Constructor
    private Fichero()
    {
        Dir="src/files/lista2.txt";
    }

    //Methods

    /**
     *
     * @return Devuelve la unica instancia de la clase Fichero
     */
    public static Fichero getFichero()
    {
        if(miFichero==null)
        {
            miFichero=new Fichero();
        }
        return miFichero;
    }

    /*
     * Lee el documento que se encuentra en la direccion Dir y lo separa por lineas.
     * Despues, usando regex separa las peliculas de la lista de actores para despues separar los
     * actores de uno en uno. Luego estos actores son añadidos a la lista de actores asociada a la pelicula de la linea
     */
    public void cargarFichero()
    {
        try
        {
            Scanner entrada = new Scanner(new FileReader(Dir));
            String linea;
            while (entrada.hasNext())
            {
                linea=entrada.nextLine();

                String [] sub1 = linea.split(" --->>>"+"\\s+");
                String [] sub2 = sub1[1].split(" #####"+"\\s+");

                String Title=sub1[0];
                Pelicula Peli=new Pelicula(Title);

                for (String s : sub2) {
                    Actor unActor = new Actor(s);
                    unActor.anadirPeliculaALista(Peli);
                    Peli.anadirActorALista(unActor);

                    HashMap_Actores.getMiMapa().anadirActor(s,unActor,Peli);
                }

                HashMap_Peliculas.getMiMapa().anadirEntrada(Title,Peli);
            }
            entrada.close();
        }
        catch (IOException e) {e.printStackTrace();}
    }

    public void crearFichero()
    {
        try
        {
            FileWriter fichero = new FileWriter("src/files/lista_output");
            

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
