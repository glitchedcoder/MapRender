package tech.emulator.maprender;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapView;
import org.bukkit.plugin.java.JavaPlugin;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author GlitchedCode
 */
public class MapRender extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    /* How you would use it: */

    @EventHandler
    public void onMapInit(MapInitializeEvent event) {
        MapView view = event.getMap();
        view.getRenderers().forEach(mapRenderer -> view.removeRenderer(mapRenderer));
        try {
            view.addRenderer(new Renderer(new File("File"), this));
            view.addRenderer(new Renderer(ImageIO.read(new URL("http://myles.i.pxl.lt/zGelcj.png")), this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}