package models;

public class CountryIso2 {

    private String countryName;
    private String iso2code;

    public CountryIso2(String countryName, String iso2code) {
        this.countryName = countryName;
        this.iso2code = iso2code;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getIso2code() {
        return iso2code;
    }

    public void setIso2code(String iso2code) {
        this.iso2code = iso2code;
    }
}
