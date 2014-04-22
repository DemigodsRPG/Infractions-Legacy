package com.censoredsoftware.infractions.bukkit.legacy.util;

import com.censoredsoftware.infractions.bukkit.legacy.InfractionsPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

public class LevelUtil
{

	static InfractionsPlugin plugin;
	static Logger log = plugin.getLogger();
	static File f = new File("plugins" + File.separator + "Infractions" + File.separator + "config.yml");
	static FileConfiguration config = YamlConfiguration.loadConfiguration(f);

	public static Integer getLevel(String levelArg)
	{
		if(getLevel1().contains(levelArg)) return 1;
		if(getLevel2().contains(levelArg)) return 2;
		if(getLevel3().contains(levelArg)) return 3;
		if(getLevel4().contains(levelArg)) return 4;
		if(getLevel5().contains(levelArg)) return 5;

		log.warning("Unable to find level for reason '" + levelArg + "'.");
		return null;
	}

	public static List<String> getLevel1()
	{
		List<String> level1;
		level1 = SettingUtil.fetchListString(config, "level_1");
		return level1;
	}

	public static List<String> getLevel2()
	{
		List<String> level2;
		level2 = SettingUtil.fetchListString(config, "level_2");
		return level2;
	}

	public static List<String> getLevel3()
	{
		List<String> level3;
		level3 = SettingUtil.fetchListString(config, "level_3");
		return level3;
	}

	public static List<String> getLevel4()
	{
		List<String> level4;
		level4 = SettingUtil.fetchListString(config, "level_4");
		return level4;
	}

	public static List<String> getLevel5()
	{
		List<String> level5;
		level5 = SettingUtil.fetchListString(config, "level_5");
		return level5;
	}

	public LevelUtil(InfractionsPlugin instance)
	{
		plugin = instance;
		plugin.getConfig().options().copyDefaults(true);
		plugin.saveConfig();
	}
}
