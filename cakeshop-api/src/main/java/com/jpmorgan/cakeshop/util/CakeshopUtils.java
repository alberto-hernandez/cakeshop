package com.jpmorgan.cakeshop.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CakeshopUtils
{
	private static final Logger LOG = LoggerFactory.getLogger(CakeshopUtils.class);

	/**
	 * Get the location of the shared configuration file, if available
	 * 
	 * @return File
	 */
	public static File findSharedNetworkConfigFile()
	{

		String sharedConfig = System.getenv("CAKESHOP_SHARED_CONFIG");
		if (StringUtils.isBlank(sharedConfig))
		{
			LOG.info("CAKESHOP_SHARED_CONFIG not set, Skipping loading shared configuration");
			return null;
		}

		File fSharedConfig;
		if (sharedConfig.endsWith(".properties"))
		{
			fSharedConfig = new File(FileUtils.expandPath(sharedConfig));
		}
		else
		{
			fSharedConfig = new File(FileUtils.expandPath(sharedConfig, "shared.properties"));
		}

		if (!fSharedConfig.exists())
		{
			LOG.error("CAKESHOP_SHARED_CONFIG file not found: " + fSharedConfig.toString());
			return null;
		}

		return fSharedConfig;
	}

}
