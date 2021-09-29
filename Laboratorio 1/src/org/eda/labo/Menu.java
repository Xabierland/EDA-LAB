package org.eda.labo;

import java.util.Scanner;

public class Menu
{
    //Attributes
    private static Menu miMenu=null;

    //Constructor
    private Menu(){}

    //Methods
    public static Menu getMenu()
    {
        if(miMenu==null)
        {
            miMenu=new Menu();
        }
        return miMenu;
    }

    public void showMenu()
    {
        Scanner sn=new Scanner(System.in);
        boolean exit=false;
        int opcion;
        Fichero datos = Fichero.getFichero();
        HashMap_Peliculas HM_Peli = HashMap_Peliculas.getMiMapa();
        HashMap_Actores HM_Actor = HashMap_Actores.getMiMapa();
        Pelicula unaPelicula;
        Actor unActor;

        while(!exit)
        {
            System.out.println("\t\t Menu Principal \n");
            System.out.println("Seleccione una de las siguientes opciones:\n");
            System.out.println("0. Cargar los datos");
            System.out.println("1. Buscar actor/actriz");
            System.out.println("2. Añadir actor/actriz");
            System.out.println("3. Obtener las peliculas de un actor/actriz");
            System.out.println("4. Obtener los actores/actrices de una pelicula");
            System.out.println("5. Incrementar la recaudacion de una pelicula");
            System.out.println("6. Eliminar un actor/actriz");
            System.out.println("7. Guardar los datos en un fichero");
            System.out.println("8. Obtener lista ordenada de actores");
            System.out.println("9. Finalizar Programa");
            System.out.print("---> ");
            opcion=sn.nextInt();

            switch (opcion)
            {
                case 0:
                    datos.cargarLista();
                    break;
                case 1:
                    System.out.println(ListaActores.getMiListaActores().buscarActor().getNombre());
                    break;
                case 2:
                    break;
                case 3:
                    unActor= HM_Actor.buscarActor();
                    unActor.imprimirLista();        //COMPROBACION
                    break;
                case 4:
                    unaPelicula=HM_Peli.buscarPelicula();
                    unaPelicula.imprimirLista();   //COMPROBACION
                    break;
                case 5:
                    unaPelicula=HM_Peli.buscarPelicula();
                    unaPelicula.incrementarRecaudacion();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    exit=true;
                    break;
                default:
                    System.out.println("Solo numeros del 0 al 9\n");
            }
        }
    }
}
