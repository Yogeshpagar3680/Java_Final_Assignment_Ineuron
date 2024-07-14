package in.ineuron.entity;

import javax.persistence.*;

@Entity
@Table(name = "TOURIST1")
public class Tourist {

    @Id
    private Integer ticketId;
    private String city;
    private String name;
    private String packageType;
    private Double budget;

    public Tourist() {
    }

    public Tourist(Integer ticketId, String city, String name, String packageType, Double budget) {
        this.ticketId = ticketId;
        this.city = city;
        this.name = name;
        this.packageType = packageType;
        this.budget = budget;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "ticketId=" + ticketId +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", packageType='" + packageType + '\'' +
                ", budget=" + budget +
                '}';
    }
}
