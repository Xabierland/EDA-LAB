package org.eda.lab4;

public class Par {
    private String actor;
    private Double pageRank;

    public Par(String key, Double aDouble) {
        actor=key;
        pageRank=aDouble;
    }

    public String getName()
    {
        return actor;
    }

    public Double getPageRank()
    {
        return pageRank;
    }
}
