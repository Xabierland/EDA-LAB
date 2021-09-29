package org.eda.labo;

import java.util.ArrayList;
import java.util.Scanner;

public class Pelicula
{
    //Attributes
    private String Titulo;
    private float Recaudacion;
    private ArrayList<Actor> lista = new ArrayList<Actor>();

    //Constructor
    public Pelicula(String pTitulo)
    {
        this.Titulo=pTitulo;
        this.Recaudacion=0;
    }

    //Methods
    public String getNombre ()
    {
        return this.Titulo;
    }

    public void incrementarRecaudacion()
    {
        System.out.println("\nIntroduce el valor de la recaudacion a aumentar");
        Scanner sn=new Scanner(System.in);
        Float valor=sn.nextFloat();
        Recaudacion+=valor;
        System.out.println("Esta pelicula a recudado "+Recaudacion+"$");
    }

    public void anadirActorALista(Actor unActor)
    {
        if(!lista.contains(unActor))
        {
            lista.add(unActor);
        }
        else
        {
            System.out.println("El actor ya esta en la lista");
        }
    }

    public void imprimirLista()
    {
        for (Actor actor : lista) {
            System.out.println(actor.getNombre());
        }
    }
}