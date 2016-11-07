package tech.emulator.maprender;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author GlitchedCode
 */
public class Renderer extends MapRenderer {

    private Image image;
    private Plugin plugin;

    public Renderer(Image image, Plugin plugin) {
        this.image = image;
        this.plugin = plugin;
    }

    public Renderer(File file, Plugin plugin) throws IOException {
        /* There are other image files but this is the main few */
        if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg") || file.getName().endsWith(".jpeg")) {
            image = ImageIO.read(file);
        }
    }

    @Override
    public void render(MapView view, MapCanvas canvas, Player player) {
        if (image != null) {
            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> canvas.drawImage(1, 1, image), 10);
        }
    }
}