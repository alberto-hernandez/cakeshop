package com.jpmorgan.cakeshop.helper;

public class HexUtils
{
	public static final String HEX_PREFIX = "0x";

	/**
	 * 
	 * @param number
	 * @return
	 */
	public static String toHexString(int number)
	{
		return HEX_PREFIX + Integer.toHexString(number);
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	public static String toHexString(long number)
	{
		return HEX_PREFIX + Long.toHexString(number);
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	public static String toHexString(String str)
	{
		return HEX_PREFIX + str;
	}

}
