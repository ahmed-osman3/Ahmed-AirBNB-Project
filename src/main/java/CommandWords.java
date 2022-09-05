package com.example.airbnbproject2;

public class CommandWords {
    // All area command words
    private static final String[] areaCommands = {
            "kensington and chelsea", "hammersmith and fulham", "islington", "westminster", "newham", "wandsworth", "richmond upon thames", "hounslow", "barnet", "haringey", "southwark", "waltham forest", "brent", "camden", "hackney", "tower hamlets", "croydon", "lambeth", "hillingdon", "enfield", "merton", "lewisham", "city of london", "ealing", "bromley", "harrow", "havering", "greenwich", "barking and dagenham", "redbridge", "kingston upon thames", "brexley", "sutton"
    };


    /**
     *
     * @param command
     * @return true if command is area command
     */
    public boolean isAreaCommand(String command){
        for(int i = 0; i < areaCommands.length; i++){
            if(command.equals(areaCommands[i])){
                return true;
            }
                String[] split = areaCommands[i].split(" ");
                for (String s : split) {
                    if (s.equals(command) && command !="and") {
                        return true;
                    }
                }

        }
        return false;
    }

    /**
     *
     * @param command
     * @return Neighbourhood of corresponding command.
     */
    public String getArea(String command){
        for(int i = 0; i < areaCommands.length; i++){
            if(command.equals(areaCommands[i])){
                return areaCommands[i];
            }
            String[] split = areaCommands[i].split(" ");
            for (String s : split) {
                if (s.equals(command) && command !="and") {
                    return areaCommands[i];
                }
            }

        }
        return "";
    }

    }

