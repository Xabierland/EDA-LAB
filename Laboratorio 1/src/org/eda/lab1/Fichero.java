package org.eda.lab1;

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
        Dir="Laboratorio 1/src/files/lista.txt.txt";
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
     * Despues, usando regex separa las peliculas de la lista.txt de actores para despues separar los
     * actores de uno en uno. Luego estos actores son añadidos a la lista.txt de actores asociada a la pelicula de la linea
     */
    public void cargarFichero()
    {
        long statTime=System.nanoTime();
        try
        {
            Scanner entrada = new Scanner(new FileReader(Dir));
            String linea;
            HashMap_Peliculas HM_Peli = HashMap_Peliculas.getMiMapa();
            HashMap_Actores HM_Actor = HashMap_Actores.getMiMapa();
            while (entrada.hasNext())
            {
                linea=entrada.nextLine();

                String [] sub1 = linea.split(" --->>>"+"\\s+");
                String [] sub2 = sub1[1].split(" #####"+"\\s+");

                String Title=sub1[0];
                Pelicula Peli=HM_Peli.add(Title);

                for (String s : sub2)
                {
                    Actor unActor=HM_Actor.add(s);
                    unActor.addPelicula(Title);
                    Peli.addActor(s);
                }
            }
            entrada.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        long endTime=System.nanoTime();
        System.out.println(((endTime-statTime)/1000000000)+" segundos a tardado en ejecutarse");
    }

    /**
     * Crea el fichero y escribe el contenido de la clase HashMap Peliculas en el.
     */
    public void crearFichero()
    {
        try
        {
            FileWriter fichero = new FileWriter("Laboratorio 1/src/files/lista_output.txt");
            HashMap_Peliculas.getMiMapa().escribirContenido(fichero);
            fichero.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
