package com.example.airbnbproject2;

public class Listing {
    private final String id;
    private final String name;
    private final int host_id;
    private final String host_name;
    private final String neighbourhood;
    private final double latitude;
    private final double longitude;
    private final String room_type;
    private final String  price;
    private final int min_stay;
    private int no_reviews;
    private final String last_review;
    private final double review_pm;
    private final int calclisting;
    private int num_review;



    public Listing(String id, String name,int host_id, String host_name,String neighbourhood, double latitude, double longitude, String room_type,String price, int min_stay,int no_reviews, String last_review, double review_pm, int calcListing, int num_review,boolean booked, int checkDate, int leaveDate){
        this.id = id;
        this.name = name;
        this.host_id = host_id;
        this.host_name = host_name;
        this.neighbourhood = neighbourhood;
        this.latitude = latitude;
        this.longitude = longitude;
        this.room_type = room_type;
        this.price = price;
        this.min_stay = min_stay;
        this.no_reviews = no_reviews;
        this.last_review = last_review;
        this.review_pm = review_pm;
        this.calclisting = calcListing;
        this.no_reviews = no_reviews;

    }

    /**
     *
     * @return Id of property
     */
    public String getId ()
    {
        return id;
    }

    /**
     *
     * @return Description of property
     */
    public  String getName(){
        return name;
    }



    /**
     *
     * @return Host ID of property
     */
    public int getHost_id(){
        return host_id;
    }

    /**
     *
     * @return Host name of property
     */
    public String getHost_name(){
        return host_name;
    }

    /**
     *
     * @return Neighbourhood of property
     */
    public String getNeighbourhood() {
        return neighbourhood;
    }

    /**
     *
     * @return Latitude of property
     */
    public double getLatitude(){
        return latitude;
    }

    /**
     *
     * @return Longitude of property
     */
    public double getLongitude(){
        return longitude;
    }

    /**
     *
     * @return Room type of property;
     */
    public String getRoom_type() {
        return room_type;
    }


    /**
     *
     * @return Price of property
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @return Min stay of property
     */
    public int getMin_stay() {
        return min_stay;
    }



    /**
     *
     * @return Number of reviews of property
     */
    public int getNo_reviews() {
        return no_reviews;
    }

    /**
     *
     * @return Date of last review
     */
    public String getLast_review(){
        return last_review;
    }

    /**
     *
     * @return Number of reviews per month
     */
    public double getReview_pm() {
        return review_pm;
    }

}
