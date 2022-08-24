package arashamini.ghalbesecurity;
// import for colored text
import org.bukkit.ChatColor;
// import sender
import org.bukkit.command.CommandSender;
public class CustomMsg {
    public static void sendMessage(String message, CommandSender Sender) {
        message = ChatColor.translateAlternateColorCodes('&', message);
        Sender.sendMessage(message);
    }
}
