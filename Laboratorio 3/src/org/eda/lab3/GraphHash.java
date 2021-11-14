package org.eda.lab3;

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

    public boolean estanConectados(String a1, String a2)
    {
        if(a1==null&&a2==null)
        {
            System.out.println("Introduce el nombre del actor");
            Scanner sn=new Scanner(System.in);
            a1=sn.nextLine();
            a2=sn.nextLine();
        }
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
                    System.out.println(((endTime-statTime)/1000000000)+" segundos a tardado en ejecutarse");
                    return false;
                }
                else if(!g.get(a1).contains(a2))
                {
                    Queue<String> sinExplorar = new LinkedList<>(g.get(a1));
                    HashSet<String> Explorados = new HashSet<>();
                    boolean enc = false;
                    Explorados.add(a1);
                    while (!sinExplorar.isEmpty() && !enc) {
                        String unActor = sinExplorar.remove();
                        Explorados.add(unActor);
                        if (unActor.compareTo(a2) == 0) {
                            enc = true;
                        } else {
                            g.get(unActor).forEach(s ->
                            {
                                if (!Explorados.contains(s) && !sinExplorar.contains(s)) {
                                    sinExplorar.add(s);
                                }
                            });
                        }
                    }
                    long endTime=System.nanoTime();
                    System.out.println(((endTime-statTime)/1000000000)+" segundos a tardado en ejecutarse");
                    return enc;
                }
                else
                {
                    long endTime=System.nanoTime();
                    System.out.println(((endTime-statTime)/1000000000)+" segundos a tardado en ejecutarse");
                    return true;
                }
            }
        }
    }
}
