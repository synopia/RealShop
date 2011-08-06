package fr.crafter.tickleman.RealPermissions;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.crafter.tickleman.RealPlugin.RealPlugin;

//########################################################################### class PermissionsLink
public class PermissionsLink
{

	public static boolean initialized = false;

	private static RealPlugin plugin;

	//--------------------------------------------------------------------------------- hasPermission
	public static boolean hasPermission(Player player, String permission)
	{
        return player.hasPermission(permission);
	}

	//------------------------------------------------------------------------------------------ init
	public static boolean init(RealPlugin plugin)
	{
        initialized = true;
    	plugin.log.info("permissions initialized", true);
        return true;
	}

}
