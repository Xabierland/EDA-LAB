package org.eda.lab3;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
        Scanner sn=new Scanner(System.in);
        int opcion;
        String Dir="Laboratorio 3/src/files/lista.txt";
        System.out.println("\nSeleccione una lista sobre la que trabajar:");
        System.out.println("0. Lista de 10 elementos");
        System.out.println("1. Lista de 20.000 elementos");
        System.out.println("2. Lista de 50.000 elementos");
        System.out.println("3. Lista completa");
        System.out.println("4. Otra lista (Meter direccion a mano)");
        System.out.print("---> ");
        opcion=sn.nextInt();
        sn.nextLine();
        switch (opcion) {
            case 0:
                Dir="Laboratorio 3/src/files/lista.txt";
                break;
            case 1:
                Dir="Laboratorio 3/src/files/lista_20000.txt";
                break;
            case 2:
                Dir="Laboratorio 3/src/files/lista_50000.txt";
                break;
            case 3:
                Dir="Laboratorio 3/src/files/lista_completa.txt";
                break;
            case 4:
                System.out.println("Introducce una direccion valida");
                Dir=sn.nextLine();
                break;
            default:
                System.out.println("Solo numeros del 0 al 4\n");
        }
        g.clear();
        cargarFichero(Dir);
    }

    private void cargarFichero(String Dir)
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
        ArrayList<String> lDatos;
        if(g.containsKey(pClave))
        {
            lDatos = g.get(pClave);
        }
        else
        {
            lDatos = new ArrayList<>();
        }
        if(pDato.compareTo("")!=0)
            lDatos.add(pDato);
        g.put(pClave, lDatos);

    }

    public boolean estanConectados()
    {
        System.out.println("Introduce el nombre del primer actor");
        Scanner sn=new Scanner(System.in);
        String a1=sn.nextLine();
        System.out.println("Introduce el nombre del segundo actor");
        String a2=sn.nextLine();
        return estanConectados(a1,a2);
    }

    public boolean estanConectados(String a1, String a2)
    {
        if(!g.containsKey(a1))
        {
            System.out.println(a1+" no esta en la base de datos");
            return false;
        }
        else
        {
            if(!g.containsKey(a2))
            {
                System.out.println(a2+" no esta en la base de datos");
                return false;
            }
            else
            {
                long statTime=System.nanoTime();
                if(g.get(a1).isEmpty() || g.get(a2).isEmpty())
                {
                    long endTime=System.nanoTime();
                    System.out.println(((endTime-statTime)/1000000000)+" segundos a tardado en comprobar conexion");
                    return false;
                }
                else if(!g.get(a1).contains(a2))
                {
                    Queue<String> sinExplorar = new LinkedList<>(g.get(a1));
                    HashSet<String> HSsinExplorar = new HashSet<>(g.get(a1));
                    HashSet<String> Explorados = new HashSet<>();
                    boolean enc = false;
                    Explorados.add(a1);
                    while (!HSsinExplorar.isEmpty() && !enc) {
                        String unActor = sinExplorar.remove();
                        HSsinExplorar.remove(unActor);
                        Explorados.add(unActor);
                        if (unActor.compareTo(a2) == 0) {
                            enc = true;
                        } else {
                            g.get(unActor).forEach(s ->
                            {
                                if (!Explorados.contains(s) && !HSsinExplorar.contains(s)) {
                                    sinExplorar.add(s);
                                    HSsinExplorar.add(s);
                                }
                            });
                        }
                    }
                    long endTime=System.nanoTime();
                    System.out.println(((endTime-statTime)/1000000000)+" segundos a tardado en comprobar conexion");
                    return enc;
                }
                else
                {
                    long endTime=System.nanoTime();
                    System.out.println(((endTime-statTime)/1000000000)+" segundos a tardado en comprobar conexion");
                    return true;
                }
            }
        }
    }

    public ArrayList<String> listaConectados()
    {
        System.out.println("Introduce el nombre del primer actor");
        Scanner sn=new Scanner(System.in);
        String a1=sn.nextLine();
        System.out.println("Introduce el nombre del segundo actor");
        String a2=sn.nextLine();
        if(estanConectados(a1,a2))
            return listaConectados(a1,a2);
        else
            return new ArrayList<>();
    }

    public ArrayList<String> listaConectados(String a1, String a2)
    {
        return pathFinder(a1,a2);
    }

    private ArrayList<String> pathFinder(String a1, String a2)
    {
        long statTime=System.nanoTime();

        Queue<String> sinExplorar = new LinkedList<>(g.get(a1));
        HashSet<String> HSsinExplorar = new HashSet<>(g.get(a1));
        HashSet<String> Explorados = new HashSet<>();
        HashMap<String, String> backpointers=new HashMap<>();
        String unActor=null;
        boolean enc = false;

        Explorados.add(a1);
        backpointers.put(a1,null);
        while (!HSsinExplorar.isEmpty() && !enc)
        {
            unActor = sinExplorar.remove();
            HSsinExplorar.remove(unActor);
            Explorados.add(unActor);
            if (unActor.compareTo(a2) == 0)
            {
                enc = true;
            } else
            {
                String finalUnActor = unActor;
                g.get(unActor).forEach(s ->
                {
                    if (!Explorados.contains(s) && !HSsinExplorar.contains(s)) {
                        sinExplorar.add(s);
                        HSsinExplorar.add(s);
                        backpointers.put(s, finalUnActor);
                    }
                });
            }
        }
        if(enc)
        {
            ArrayList<String> lista = new ArrayList<>();

            while (unActor!=null)
            {
                lista.add(unActor);
                unActor=backpointers.get(unActor);
            }
            lista.add(a1);
            Collections.reverse(lista);
            long endTime=System.nanoTime();
            System.out.println(((endTime-statTime)/1000000000)+" segundos a tardado en encontrar el camino");
            return lista;
        }
        else
        {
            long endTime=System.nanoTime();
            System.out.println(((endTime-statTime)/1000000000)+" segundos a tardado en encontrar el camino");
            return new ArrayList<>();
        }
    }
}
