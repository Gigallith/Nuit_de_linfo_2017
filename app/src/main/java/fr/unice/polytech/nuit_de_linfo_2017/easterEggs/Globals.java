package fr.unice.polytech.nuit_de_linfo_2017.easterEggs;

/**
 * Created by Marion on 07/12/2017.
 */

public class Globals {
    private static  Globals instance;
    private int data;

    public Globals() {
        this.data =0;
    }

    public void setData(int d){
        this.data=d;
    }

    public int incremente(){
        return this.data++;
    }

    public int getData() {
        return data;
    }

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}
