package com.example.airbnbproject2;

public class CommandWords {
    private static final String[] areaCommands = {
            "kensington and chelsea", "hammersmith and fulham", "islington", "westminster", "newham", "wandsworth", "richmond upon thames", "hounslow", "barnet", "haringey", "southwark", "waltham forest", "brent", "camden", "hackney", "tower hamlets", "croydon", "lambeth", "hillingdon", "enfield", "merton", "lewisham", "city of london", "ealing", "bromley", "harrow", "havering", "greenwich", "barking and dagenham", "redbridge", "kingston upon thames", "brexley", "sutton"
    };

    private static final String[] propertyCommands = {
            "apartment", "flat", "house",
    };

    public CommandWords(){

    }

    public boolean isAreaCommand(String command){
        for(int i = 0; i < areaCommands.length; i++){
            String[] split = areaCommands[i].split(" ");
            for(String s : split) {
                if (s.equals(command)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    }

