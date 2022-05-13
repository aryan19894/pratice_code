package companyOA.hackerrank.arcessium.model;

public class Person {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String website;
    private Company company;

    public Person(int id, String name, String username, String email, Address address, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.website = website;
        this.company = company;
    }

    public Person() {
    }

    public String toString() {
        return "Person{id=" + this.id + ", name='" + this.name + '\'' + ", username='" + this.username + '\'' + ", email='" + this.email + '\'' + ", address=" + this.address + ", website='" + this.website + '\'' + ", company=" + this.company + '}';
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
