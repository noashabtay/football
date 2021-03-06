package com.football.Domain.League;

import com.football.Exception.ObjectNotExist;

import java.util.HashMap;

public class League {
    private String name;
    private HashMap<Season,LeagueInSeason> leagueInSeasons;

    public League(String name) {
        this.name = name;
        leagueInSeasons=new HashMap<>();
    }

    public LeagueInSeason getLeagueInSeason(Season season) throws ObjectNotExist {
        if(leagueInSeasons.containsKey(season))
             return leagueInSeasons.get(season);
        else{
            for(Season s: leagueInSeasons.keySet()){
                if(s.getYear().equals(season.getYear()))
                    return leagueInSeasons.get(s);
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public void addLeagueInSeason(LeagueInSeason leagueInSeason){
        if(leagueInSeason != null && !leagueInSeasons.containsKey(leagueInSeason.getSeason())){
            leagueInSeasons.put(leagueInSeason.getSeason(), leagueInSeason);
        }
    }

    public Season getSeason(String season){
        if(this.leagueInSeasons!= null ){
            for(Season season1 : this.leagueInSeasons.keySet()){
                if(season.equals(season1.getYear())){
                    return season1;
                }
            }
        }
        return null;
    }

    public HashMap<Season,LeagueInSeason> getSeasons(){
        return leagueInSeasons;
    }

    @Override
    public String toString(){
        String details = "\'"+this.name+"\',\'";
        for(Season lS : leagueInSeasons.keySet()){
            details += lS.getYear() +":";
        }
        if (details != null && details.length() > 0 && details.charAt(details.length() - 1) == ':') {
            details = details.substring(0, details.length() - 1);
        }
        details += "\'";
        return details;
    }
    public String getSeasonString()
    {
        String str="";
        for (Season season:leagueInSeasons.keySet()
        ) {
            str=season.toString()+";"+leagueInSeasons.get(season).toString()+":";
        }
        return str;
    }
}
