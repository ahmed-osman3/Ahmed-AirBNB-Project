package com.example.airbnbproject2;
import com.opencsv.CSVReader;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;


public class Parser {

    /**
     * Reads CSV Data and parses it into A Listing Object
     * @return ArrayList of Listing objects
     */
    public ArrayList<Listing> load(){
        ArrayList<Listing> listings = new ArrayList<>();
        try{
            URL url = getClass().getResource("listings (1).csv");
            CSVReader reader = new CSVReader(new FileReader(new File(url.toURI()).getAbsolutePath()));
           reader.readNext();
            String[] nextLine;

            while( (nextLine = reader.readNext()) != null){
                String id = nextLine[0];
                String name = nextLine[1];
                int host_id = Integer.parseInt(nextLine[2]);
                String host_name = nextLine[3];
                String neighbourhood = nextLine[5];
                double latitude = Double.parseDouble(nextLine[6]);
                double longitude = Double.parseDouble(nextLine[7]);
                String room_type = nextLine[8];
                String price =nextLine[9];
                int min_stay = Integer.parseInt(nextLine[10]);
                int no_reviews = Integer.parseInt(nextLine[11]);
                String last_review = nextLine[12];
                double reviews_pm = 0;
                if(!nextLine[13].equals("")){
                    reviews_pm  = Double.parseDouble(nextLine[13]);
                }
                int calc_listings = Integer.parseInt(nextLine[14]);
                int availabilty_365 = Integer.parseInt(nextLine[15]);
                int num_of_review = Integer.parseInt(nextLine[16]);
                Listing listing = new Listing(id,name,host_id,host_name,neighbourhood,latitude,longitude,room_type,price,min_stay,no_reviews,last_review,reviews_pm,calc_listings,num_of_review, false, 0, 0);
                 listings.add(listing);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return listings;

}


    /**
     * Filters properties by neighbourhood
     * @param listings
     * @param neighbourhood
     * @return Filtered  list of properties with corresponding neighbourhood
     */
    public ArrayList<Listing> filterNeighbourhood(ArrayList<Listing> listings,String neighbourhood){
        ArrayList<Listing> fListings = new ArrayList<>();
        for(int i = 0; i < listings.size(); i++ ){
            if(listings.get(i).getNeighbourhood().toLowerCase().equals(neighbourhood)){
                fListings.add(listings.get(i));
            }
        }
        return fListings;

}

    /**
     * Filters properties for number of guests.
     * @param listings
     * @param guests
     * @return Filtered list of properties that are big enough for number of guests
     */
    public ArrayList<Listing> filterRooms(ArrayList<Listing> listings, int guests){
    ArrayList<Listing> fListings = new ArrayList<>();
    for(int i = 0; i < listings.size(); i++ ){
        if(getBeds(listings.get(i)) >= guests){
            fListings.add(listings.get(i));
        }
    }
    return fListings;
}

    /**
     * Determines how many beds are in a property depending on the listings property type.
     * @param listing
     * @return Number of beds
     */
    public int getBeds(Listing listing){
        String name = listing.getName();
        String room = listing.getRoom_type();
        int val = 0;
        String[] args = name.split(" ");

        if(room.equals("Private room")){
            val = 1; // 1 room 1 bed.
        }

        for(String s : args){
            if(s.equalsIgnoreCase("house") && room.equals("Entire home/apt")){
                val = 4; // 2 bedrooms, 2 people for each room.
            }

            if( (s.equalsIgnoreCase("apartment") || s.equalsIgnoreCase("flat")) && room.equals("Entire home/apt")){
                val = 2; // 1 bedroom 2 people apartment.
            }
        }

        return val;
}
}
