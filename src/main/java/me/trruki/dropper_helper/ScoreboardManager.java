package me.trruki.dropper_helper;

import net.minecraft.scoreboard.*;
import net.minecraft.text.Text;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScoreboardManager {
    public static List<Map.Entry<Integer, String>> getRawLines(Scoreboard scoreboard) {
        if (scoreboard == null){
            return null;
        }
        ScoreboardObjective objective = scoreboard.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR);
        if (objective == null) {return null;}
        List<Map.Entry<Integer, String>> linesWithScores = new ArrayList<>();
        String line;
        int id;
        for (ScoreHolder holder : scoreboard.getKnownScoreHolders()) {
            id = scoreboard.getOrCreateScore(holder, objective).getScore();
            if (id == 0) {scoreboard.removeScore(holder, objective);}
            Team team = scoreboard.getScoreHolderTeam(holder.getNameForScoreboard());
            if (team == null) {continue;}
            line = team.getPrefix().getString() + team.getSuffix().getString();
            linesWithScores.add(new AbstractMap.SimpleEntry<>(id, line));
        }

        return linesWithScores;
    }

    public static List<Map.Entry<Integer, Text>> getFormattedLines(Scoreboard scoreboard) {
        if (scoreboard == null){
            return null;
        }
        ScoreboardObjective objective = scoreboard.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR);
        if (objective == null) {return null;}
        List<Map.Entry<Integer, Text>> linesWithScores = new ArrayList<>();
        Text line;
        int id;
        for (ScoreHolder holder : scoreboard.getKnownScoreHolders()) {
            id = scoreboard.getOrCreateScore(holder, objective).getScore();
            if (scoreboard.getScoreHolderTeam(holder.getNameForScoreboard()) == null || scoreboard.getScoreHolderTeam(holder.getNameForScoreboard()).getPrefix() == null || scoreboard.getScoreHolderTeam(holder.getNameForScoreboard()).getSuffix() == null) {continue;}
            line = scoreboard.getScoreHolderTeam(holder.getNameForScoreboard()).getPrefix().copy().append(scoreboard.getScoreHolderTeam(holder.getNameForScoreboard()).getSuffix());
            linesWithScores.add(new AbstractMap.SimpleEntry<>(id, line));
        }

        return linesWithScores;
    }

    public static String getRawDisplayName(Scoreboard scoreboard) {
        if (scoreboard == null){
            return null;
        }
        ScoreboardObjective objective = scoreboard.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR);
        if (objective == null) {return null;}
        if (objective.getDisplayName() == null) {return null;}
        return objective.getDisplayName().getString();
    }

    public static String getName(Scoreboard scoreboard) {
        if (scoreboard == null){
            return null;
        }
        ScoreboardObjective objective = scoreboard.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR);
        if (objective == null) {return null;}
        if (objective.getName() == null) {return null;}
        return objective.getName();
    }

    public static Text getFormattedDisplayName(Scoreboard scoreboard) {
        if (scoreboard == null){
            return null;
        }
        ScoreboardObjective objective = scoreboard.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR);
        if (objective == null) {return null;}
        if (objective.getDisplayName() == null) {return null;}
        return objective.getDisplayName();
    }
}
