package com.example.airbnbproject2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Parser {

    private String csvPath = "/Users/ahmed/Downloads/Air-BNB-Project/AirBNB-Project/src/main/resources/listings (1).csv";
    public ArrayList<Listing> listings;

    public Parser(){

    }

public void loadData(){
    listings = new ArrayList<>();
        String line = "";
        try {
        BufferedReader br = new BufferedReader(new FileReader(csvPath));
        br.readLine();
        while ( (line = br.readLine()) != null) {
            String[] args = line.split(",");
            int id = Integer.parseInt(args[0]);
            String name = args[1];
            int host_id = Integer.parseInt(args[2]);
            String host_name = args[3];
            String neighbourhood = args[5];
            double latitude = Double.parseDouble(args[6]);
            double longitude = Double.parseDouble(args[7]);
            String room_type = args[8];
            int price = Integer.parseInt(args[9]);
            int min_stay = Integer.parseInt(args[10]);
            int no_reviews = Integer.parseInt(args[11]);
            String last_review = args[12];
            double reviews_pm = Double.parseDouble(args[13]);
            int calc_listings = Integer.parseInt(args[14]);
            int availabilty_365 = Integer.parseInt(args[15]);
            int num_of_review = Integer.parseInt(args[16]);
            Listing listing = new Listing(id,name,host_id,host_name,neighbourhood,latitude,longitude,room_type,price,min_stay,no_reviews,last_review,reviews_pm,calc_listings,availabilty_365,num_of_review);
            listings.add(listing);
        }
    }
     catch (FileNotFoundException e) {
        e.printStackTrace();
    }catch (IOException e) {
        e.printStackTrace();
    }
}

public static void main(String[] args){
        Parser p = new Parser();
        p.loadData();
        System.out.println(p.listings.get(0).getId());
}

}
