/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.hostel.lab_2;

/**
 *
 * @author Степан
 */
import java.io.Serializable;

abstract public class Entity implements Serializable {
	protected String name;
	public Entity(String name)
	{
		this.name = name;
	}

	public Entity()
	{}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}