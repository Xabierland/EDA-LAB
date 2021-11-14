package org.eda.lab3;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphHash
{
    private HashMap<String, ArrayList<String>> g;
    private static GraphHash miGH=null;

    private GraphHash() {g=new HashMap<>();}

    public static GraphHash getGraphHash()
    {
        if(miGH==null)
        {
            miGH= new GraphHash();
        }
        return miGH;
    }

    public void crearGrafo()
    {
        Fichero.getFichero().cargarFichero();
    }

    public void print()
    {
        int i=1;
        for(String s:g.keySet())
        {
            System.out.print("Element:"+ i++ + "\t" + s + " --> ");
            for(String k: g.get(s))
            {
                System.out.print(k+ " ### ");
            }
            System.out.println();
        }
    }

    public void add(String pClave, String pDato)
    {
        if(g.containsKey(pClave))
        {
            ArrayList<String> lDatos = g.get(pClave);
            lDatos.add(pDato);
            g.put(pClave, lDatos);
        }
        else
        {
            ArrayList<String> lDatos = new ArrayList<>();
            lDatos.add(pDato);
            g.put(pClave,lDatos);
        }

    }

    public boolean estanConectados(String a1, String a2)
    {
        return true;
    }
}
