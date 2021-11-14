package org.eda.lab3;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Fichero
{
    private final String Dir;
    private static Fichero miFichero=null;

    //Constructor
    private Fichero()
    {
        Dir="Laboratorio 3/src/files/lista.txt";
    }

    //Methods
    public static Fichero getFichero()
    {
        if(miFichero==null)
        {
            miFichero= new Fichero();
        }
        return miFichero;
    }

    public void cargarFichero()
    {
        long statTime=System.nanoTime();
        try
        {
            Scanner entrada = new Scanner(new FileReader(Dir));
            String linea;
            while (entrada.hasNext())
            {
                linea=entrada.nextLine();

                String [] sub1 = linea.split(" --->>>"+"\\s+");
                String [] sub2 = sub1[1].split(" #####"+"\\s+");

                for (String s : sub2) {
                    for (String value : sub2) {
                        if (s.compareTo(value) != 0)
                            GraphHash.getGraphHash().add(s, value);
                        else
                            GraphHash.getGraphHash().add(s,"");
                    }
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
}
