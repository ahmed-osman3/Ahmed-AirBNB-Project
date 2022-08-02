package com.example.airbnbproject2;

public class Listing {
    private int id;
    private String name;
    private int host_id;
    private String host_name;
    private String neighbourhood;
    private double latitude;
    private double longitude;
    private String room_type;
    private int price;
    private int min_stay;
    private int no_reviews;
    private String last_review;
    private double review_pm;
    private int calc_Listings;
    private int availabilty_365;
    private int number_of_reviews_ltm;

    public Listing(int id, String name, int host_id, String host_name,String neighbourhood, double latitude, double longitude, String room_type, int price, int min_stay, int no_reviews, String last_review, double review_pm, int calc_Listings, int availabilty_365, int number_of_reviews_ltm){
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
        this.calc_Listings = calc_Listings;
        this.availabilty_365 = availabilty_365;
        this.number_of_reviews_ltm = number_of_reviews_ltm;
    }

    /**
     *
     * @return Id of property
     */
    public int getId ()
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
    public int getPrice() {
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

    /**
     *
     * @return Availability of property per year
     */
    public int getAvailabilty_365() {
        return availabilty_365;
    }
}
