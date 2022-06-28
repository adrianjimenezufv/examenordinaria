package ufv.dis.final2022.AJC;

public class IPEncontrada {
    private String IP;
    private String country_code;
    private String region_code;
    private String city_name;
    private String zip_code;
    private String time_zone;

    public IPEncontrada() {
    }

    public IPEncontrada(String IP, String country_code, String region_code, String city_name, String zip_code, String time_zone) {
        this.IP = IP;
        this.country_code = country_code;
        this.region_code = region_code;
        this.city_name = city_name;
        this.zip_code = zip_code;
        this.time_zone = time_zone;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getRegion_code() {
        return region_code;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    @Override
    public String toString() {
        return "IPEncontrada{" +
                "IP='" + IP + '\'' +
                ", country_code='" + country_code + '\'' +
                ", region_code='" + region_code + '\'' +
                ", city_name='" + city_name + '\'' +
                ", zip_code='" + zip_code + '\'' +
                ", time_zone='" + time_zone + '\'' +
                '}';
    }
}
