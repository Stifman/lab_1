/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.hostel.lab_2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
 *
 * @author Степан
 */

public class Recept extends Entity implements Show, Comparable<Recept>{
    private ArrayList<String> spisIngred;
    private String sposobGotovki;
    private int vremjaGotovki;
    
    public Recept(){}
    public Recept(String name, Iterator<String> Spis, String Spos, int time)
    {
        super(name);
        spisIngred = new ArrayList<String>();
        while(Spis.hasNext())
        {
            spisIngred.add(Spis.next());
        }
        sposobGotovki = Spos;
        vremjaGotovki = time;
    }
    public void show()
    {
        System.out.println("Название рецепта: "+ name + "\nСписок ингредиентов"+ spisIngred + "\nСпособ приготовления:  " + sposobGotovki + "\nВремя приготовления  " + vremjaGotovki+ " [мин.]");
    }
    public Iterator<String> getSpisIngred()
    {
	return spisIngred.iterator();
    }

    public void setSpisIngred(Iterator<String> s)
    {
        spisIngred = new ArrayList<String>();
        while(s.hasNext())
        {
            spisIngred.add(s.next());
        }
    }
    public String getSposobGotovki()
    {
        return sposobGotovki;
    }
    public void setSposobGotovki(String s)
    {
        this.sposobGotovki = s;
    }
    public int getVremajGotovki()
    {
        return vremjaGotovki;
    }
    public void setVremjaGotovki(int s)
    {
        this.vremjaGotovki = s;
    }
    public int compareTo(Recept obj)
    {
        return name.compareTo(obj.getName());
    }
}
