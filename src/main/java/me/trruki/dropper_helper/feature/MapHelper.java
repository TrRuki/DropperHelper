package me.trruki.dropper_helper.feature;

import com.google.gson.JsonArray;
import me.trruki.dropper_helper.JsonDB;
import me.trruki.dropper_helper.ScoreboardManager;
import me.trruki.dropper_helper.block.ModBlocks;
import me.trruki.dropper_helper.block.custom.ArrowBlock;
import me.trruki.dropper_helper.config.ModConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MapHelper {
    static final Pattern curMapRegExp = Pattern.compile(" ✘ (.+) ◀");
    public static void tick(MinecraftClient client){
        if (client.player == null || client.world == null) {return;}
        List<Map.Entry<Integer, String>> scoreboardLines = ScoreboardManager.getRawLines(client.player.getScoreboard());
        if (scoreboardLines == null){return;}
        String curMap = null;
        for (Map.Entry<Integer, String> entry : scoreboardLines){
            Matcher matcher = curMapRegExp.matcher(entry.getValue());
            if (matcher.find()){
                curMap = matcher.group(1);
            }
        }
        if (curMap == null) {return;}
        if (!JsonDB.getJson().getAsJsonObject("maps").has(curMap)) {return;}
        if (ModConfig.getPathHighlighter()) {pathHighlighter(client, curMap);}
        if (ModConfig.getDirectionArrow()) {directionArrow(client, curMap);}
    }

    private static void pathHighlighter(MinecraftClient client, String curMap){
        JsonArray highlightCoords = JsonDB.getJson().getAsJsonObject("maps").getAsJsonObject(curMap).getAsJsonArray("highlight");
        int x, y, z;
        for (int i = 0; i < highlightCoords.size(); i++){
            JsonArray coord = highlightCoords.get(i).getAsJsonArray();
            x = coord.get(0).getAsInt();
            y = coord.get(1).getAsInt();
            z = coord.get(2).getAsInt();
            client.world.setBlockState(new BlockPos(x,y,z), ModBlocks.RED_BLOCK.getDefaultState());
        }
    }

    private static void directionArrow(MinecraftClient client, String curMap){
        JsonArray arrowCoords = JsonDB.getJson().getAsJsonObject("maps").getAsJsonObject(curMap).getAsJsonArray("arrow");
        int x, y, z;
        String facing;
        for (int i = 0; i < arrowCoords.size(); i++){
            JsonArray coord = arrowCoords.get(i).getAsJsonArray();
            x = coord.get(0).getAsInt();
            y = coord.get(1).getAsInt();
            z = coord.get(2).getAsInt();
            facing = coord.get(3).getAsString();
            client.world.setBlockState(new BlockPos(x,y,z), ModBlocks.ARROW_BLOCK.getDefaultState().with(ArrowBlock.FACING, Direction.valueOf(facing)));
        }
    }
}