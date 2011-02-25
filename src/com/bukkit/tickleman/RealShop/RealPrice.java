package com.bukkit.tickleman.RealShop;

//########################################################################################### Price
public class RealPrice
{

	public double buy = 0;
	public double sell = 0;

	//--------------------------------------------------------------------------------------- Price
	public RealPrice()
	{
	}

	//--------------------------------------------------------------------------------------- Price
	public RealPrice(double buy, double sell)
	{
		this.buy = buy;
		this.sell = sell;
	}

	//-------------------------------------------------------------------------------------- getBuy
	public double getBuy()
	{
		return getBuy(1);
	}

	//-------------------------------------------------------------------------------------- getBuy
	public double getBuy(int quantity)
	{
		return Math.round(buy * 100 * quantity) / 100;
	}

	//------------------------------------------------------------------------------------- getSell
	public double getSell()
	{
		return getSell(1);
	}

	//------------------------------------------------------------------------------------- getSell
	public double getSell(int quantity)
	{
		return Math.round(sell * 100 * quantity) / 100;
	}

}
