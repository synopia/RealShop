package fr.crafter.tickleman.RealShop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.bukkit.World;
import org.bukkit.block.Block;

//################################################################################### RealShopsFile
public class RealShopsFile
{

	private final RealShopPlugin plugin;
	private final String fileName = "shops";

	/** Shops list : "world;x;y;z" => RealShop */
	public HashMap<String, RealShop> shops = new HashMap<String, RealShop>();

	//--------------------------------------------------------------------------------- RealShopsFile
	public RealShopsFile(final RealShopPlugin plugin)
	{
		this.plugin = plugin;
	}

	//---------------------------------------------------------------------------------------- isShop
	public boolean isShop(Block block)
	{
		return (shopAt(block) != null);
	}

	//---------------------------------------------------------------------------------------- shopAt
	public RealShop shopAt(Block block)
	{
		return shopAt(block.getWorld().getName(), block.getX(), block.getY(), block.getZ());
	}

	//---------------------------------------------------------------------------------------- shopAt
	public RealShop shopAt(String world, int x, int y, int z)
	{
		String key = world + ";" + x + ";" + y + ";" + z;
		return shops.get(key); 
	}

	//---------------------------------------------------------------------------------------- shopAt
	public RealShop shopAt(World world, int x, int y, int z)
	{
		return shopAt(world.getName(), x, y, z); 
	}

	//------------------------------------------------------------------------------------------ load
	public void load()
	{
		try {
			BufferedReader reader = new BufferedReader(
				new FileReader("plugins/" + plugin.name + "/" + fileName + ".cfg")
			);
			String buffer;
			StringTokenizer line;
			while ((buffer = reader.readLine()) != null) {
				line = new StringTokenizer(buffer, ";");
				if (line.countTokens() >= 5) {
					try {
						String world = line.nextToken().trim();
						Integer posX = Integer.parseInt(line.nextToken().trim());
						Integer posY = Integer.parseInt(line.nextToken().trim());
						Integer posZ = Integer.parseInt(line.nextToken().trim());
						String player = line.nextToken().trim();
						String key = world + ";" + posX + ";" + posY + ";" + posZ;
						RealShop shop = new RealShop(world, posX, posY, posZ, player);
						try {
							shop.buyOnly = RealShop.csvToHashMap(line.nextToken().trim());
							shop.sellOnly = RealShop.csvToHashMap(line.nextToken().trim());
							shop.buyExclude = RealShop.csvToHashMap(line.nextToken().trim());
							shop.sellExclude = RealShop.csvToHashMap(line.nextToken().trim());
						} catch (Exception e) {
						}
						shops.put(key, shop);
					} catch (Exception e) {
						// when some values are not number, then ignore
					}
				}
			}
			reader.close();
		} catch (Exception e) {
			plugin.log.warning(
				"Needs plugins/" + plugin.name + "/" + fileName + ".cfg file (will auto-create)"
			);
		}
	}

	//------------------------------------------------------------------------------------------ save
	public void save()
	{
		try {
			BufferedWriter writer = new BufferedWriter(
				new FileWriter("plugins/" + plugin.name + "/" + fileName + ".cfg")
			);
			Iterator<RealShop> iterator = shops.values().iterator();
			while (iterator.hasNext()) {
				RealShop shop = iterator.next();
				writer.write(
					shop.world + ";"
					+ shop.posX + ";"
					+ shop.posY + ";"
					+ shop.posZ + ";"
					+ shop.player + ";"
					+ RealShop.HashMapToCsv(shop.buyOnly) + ";"
					+ RealShop.HashMapToCsv(shop.sellOnly) + ";"
					+ RealShop.HashMapToCsv(shop.buyExclude) + ";"
					+ RealShop.HashMapToCsv(shop.sellExclude)
					+ "\n"
				);
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			plugin.log.severe("Could not save plugins/" + plugin.name + "/" + fileName + ".cfg file");
		}
	}

}