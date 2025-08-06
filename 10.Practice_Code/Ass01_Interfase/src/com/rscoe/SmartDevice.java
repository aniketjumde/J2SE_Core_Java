package com.rscoe;


interface ControllabeDevice
{
	void powerOn();
	void powerOf();
	void statusReport();	
}

interface InternateEnabled
{
	void connectWifi();
}


class SmartTV implements ControllabeDevice, InternateEnabled
{
	
	public void powerOn()
	{
		System.out.println("Smart Tv power is On.");
	}
	
	public void powerOf()
	{
		System.out.println("Smart Tv power is Off.");

	}
	
	public void statusReport()
	{
		System.out.println("Smart Tv Working Status is fine.");
	}
	
	public void connectWifi()
	{
		System.out.println("Smart Tv wifi is Connected");
	}
}


class SmartFridege implements ControllabeDevice, InternateEnabled
{
	
	public void powerOn()
	{
		System.out.println("Smart Fridge power is On.");
	}
	
	public void powerOf()
	{
		System.out.println("Smart Fridge power is Off.");

	}
	
	public void statusReport()
	{
		System.out.println("Smart Fridge Working Status is fine.");
	}
	
	public void connectWifi()
	{
		System.out.println("Smart Fridge wifi is Connected");
	}
}


class SmartAC implements ControllabeDevice, InternateEnabled
{
	
	public void powerOn()
	{
		System.out.println("Smart Ac power is On.");
	}
	
	public void powerOf()
	{
		System.out.println("Smart Ac power is Off.");

	}
	
	public void statusReport()
	{
		System.out.println("Smart Ac Working Status is fine.");
	}
	
	public void connectWifi()
	{
		System.out.println("Smart Ac wifi is Connected");
	}
}


public class SmartDevice 
{
	public static void main(String args[])
	{
		ControllabeDevice tv=new SmartTV();
		ControllabeDevice fridge=new SmartFridege();
		ControllabeDevice ac=new SmartAC();
		
		
		tv.powerOn();
		fridge.	powerOn();
		ac.powerOn();
		
		System.out.println();
		
		tv.statusReport();
		fridge.statusReport();
		ac.statusReport();
		
		System.out.println();
		
		tv.powerOf();
		fridge.powerOf();
		ac.powerOf();
		
		
	}
}
