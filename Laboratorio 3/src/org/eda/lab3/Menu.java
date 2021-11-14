package org.eda.lab3;

import java.util.Scanner;

public class Menu {
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
        GraphHash GH=GraphHash.getGraphHash();

        while(!exit)
        {
            System.out.println("\n################################################");
            System.out.println("\t\t Menu Principal \n");
            System.out.println("Seleccione una de las siguientes opciones:\n");
            System.out.println("0. Cargar los datos");
            System.out.println("1. Comprobar Conexion");
            System.out.println("8. Imprimir GraphHash");
            System.out.println("9. Finalizar Programa");
            System.out.print("---> ");
            opcion=sn.nextInt();

            switch (opcion) {
                case 0 :
                    GH.crearGrafo();
                    break;
                case 1 :
                    GH.estanConectados(null, null);
                    break;
                case 8 :
                    GH.print();
                    break;
                case 9 :
                    exit = true;
                    break;
                default :
                    System.out.println("Solo numeros del 0 al 2\n");
            }
        }
    }
}
