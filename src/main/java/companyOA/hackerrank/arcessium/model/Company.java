package companyOA.hackerrank.arcessium.model;

public class Company {
    private String name;
    private String basename;

    public Company() {
    }

    public Company(String name, String basename) {
        this.name = name;
        this.basename = basename;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBasename() {
        return this.basename;
    }

    public void setBasename(String basename) {
        this.basename = basename;
    }
}
