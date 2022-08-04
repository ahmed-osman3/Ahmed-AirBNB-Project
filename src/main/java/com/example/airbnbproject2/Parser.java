package com.example.airbnbproject2;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;


public class Parser {

    private String csvPath = "/Users/ahmed/Downloads/Air-BNB-Project/AirBNB-Project/src/main/resources/listings (1).csv";


    public Parser(){

    }

    public static void main(String[] args){
        Parser parser = new Parser();
        ArrayList<Listing> l = parser.load();
        System.out.println("" + l.size());
    }



public ArrayList<Listing> load(){
        ArrayList<Listing> listings = new ArrayList<>();
        try{
            URL url = getClass().getResource("listings (1).csv");
            CSVReader reader = new CSVReader(new FileReader(new File(url.toURI()).getAbsolutePath()));
           reader.readNext();
            String[] nextLine;
            while((nextLine = reader.readNext()) != null){
                String id = nextLine[0];
                String name = nextLine[1];
                int host_id = Integer.parseInt(nextLine[2]);
                String host_name = nextLine[3];
                String neighbourhood = nextLine[5];
                double latitude = Double.parseDouble(nextLine[6]);
                double longitude = Double.parseDouble(nextLine[7]);
                String room_type = nextLine[8];
                int price = Integer.parseInt(nextLine[9]);
                int min_stay = Integer.parseInt(nextLine[10]);
                int no_reviews = Integer.parseInt(nextLine[11]);
                String last_review = nextLine[12];
                double reviews_pm = 0;
                if(nextLine[13] != ""){
                    reviews_pm  = Double.parseDouble(nextLine[13]);
                }
                int calc_listings = Integer.parseInt(nextLine[14]);
                int availabilty_365 = Integer.parseInt(nextLine[15]);
                int num_of_review = Integer.parseInt(nextLine[16]);
                Listing listing = new Listing(id,name,host_id,host_name,neighbourhood,latitude,longitude,room_type,price,min_stay,no_reviews,last_review,reviews_pm,calc_listings,availabilty_365,num_of_review, false, 0, 0);
                listings.add(listing);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return listings;

}

public ArrayList<Listing> filterArea(ArrayList<Listing> listings,String area){
    Iterator it = listings.iterator();
    while(it.hasNext()){
        Listing l = (Listing) it.next();
        if(!(l.getNeighbourhood().equals(area))){
            it.remove();
        }
    }
    return listings;
}




public void filterPType(ArrayList<Listing> listings, String property){

}

public void filterRooms(ArrayList<Listing> listings, int guests){

}

public void filterBooked(ArrayList<Listing> listings){

}
}
