package be.guntherdw.NicksPlugin;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author GuntherDW
 */
public class ConfigNicks {

    static Map<String, User> displayNicks = new HashMap<String, User>();
    static File path = null;
    static Logger log = Logger.getLogger("Minecraft");

    public static void setPath(File path) {
        ConfigNicks.path = path;
    }

    public static void reloadNicks() {

        if (path == null) {
            log.warning("[NicksMod] Path was null!");
            return;
        }

        String txtUrl = path.getParent();
        log.info("[NicksMod] Checking " + txtUrl + "!");
        InputStream is = null;

        // this.readConfig(new File(Minecraft.b(), confPath));

        File f = new File(txtUrl, "NicksMod-nicks.txt");
        try {
            is = new FileInputStream(f);


            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {

                String[] split = new String(inputLine.getBytes(), "UTF-8").split(":");
                if (split.length == 2) {
                    // System.out.println("[mod_PonyCraft] Setting nick for "+split[0]+", "+split[1]);
                    displayNicks.put(split[0].toLowerCase(), new User(split[0], split[1]));
                }
            }
            in.close();
        } catch (Exception ex) {
            log.warning("[NicksMod] Got an exception on " + f.getAbsolutePath() + "!");
        }

    }

    public static boolean hasNick(String username) {
        return displayNicks.containsKey(username.toLowerCase());
    }

    public static String getNick(String username) {
        if (hasNick(username))
            return displayNicks.get(username.toLowerCase()).getDisplayName();
        else
            return username;
    }

}
