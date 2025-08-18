package com.finance.tax;

public class FinanceTaxCalculation 
{
	public double CalculateGST(double amount)
	{
		return amount*0.18;
	}
	
	public double CalculateIncomeTax(double salary)
	{
		if(salary<=300000)
		{
			return 0;
		}
		else
		{
			return (salary-300000)*0.05;
		}
	}
}
