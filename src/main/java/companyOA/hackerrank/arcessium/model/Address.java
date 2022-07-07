package companyOA.hackerrank.arcessium.model;

public class Address {
    private String street;
    private String suit;
    private String city;
    private String zipcode;
    private Geo geo;

    public Address() {
    }

    public Address(String street, String suit, String city, String zipcode, Geo geo) {
        this.street = street;
        this.suit = suit;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuit() {
        return this.suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return this.geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
