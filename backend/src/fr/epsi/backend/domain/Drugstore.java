package fr.epsi.backend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "drugstore")
public class Drugstore implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private int latitude;
    @Column(nullable = false)
    private int longitude;

    @OneToMany(mappedBy = "drugstore", cascade = CascadeType.ALL)
    private Set<DrugstoreFormation> formations = new HashSet<>();

    @OneToMany(mappedBy = "drugstore", cascade = CascadeType.ALL)
    private Set<DrugstoreProductSell> productsSell = new HashSet<>();

    @OneToMany(mappedBy = "drugstore", cascade = CascadeType.ALL)
    private Set<DrugstoreProductBuy> productsBuy = new HashSet<>();

    public Drugstore() {
    }

    public Drugstore(String name, String city, int latitude, int longitude) {
        this.name = name;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Drugstore(String name, int latitude, int longitude, Set<DrugstoreFormation> formations, Set<DrugstoreProductSell> productsSell, Set<DrugstoreProductBuy> productsBuy) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.formations = formations;
        this.productsSell = productsSell;
        this.productsBuy = productsBuy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public Set<DrugstoreFormation> getFormations() {
        return formations;
    }

    public void setFormations(Set<DrugstoreFormation> formations) {
        this.formations = formations;
    }

    public Set<DrugstoreProductSell> getProductsSell() {
        return productsSell;
    }

    public void setProductsSell(Set<DrugstoreProductSell> productsSell) {
        this.productsSell = productsSell;
    }

    public Set<DrugstoreProductBuy> getProductsBuy() {
        return productsBuy;
    }

    public void setProductsBuy(Set<DrugstoreProductBuy> productsBuy) {
        this.productsBuy = productsBuy;
    }

    public void addProductBuy(DrugstoreProductBuy drugstoreProductBuy) {
        drugstoreProductBuy.setDrugstore(this);
    }

    public void addProductSell(DrugstoreProductSell drugstoreProductSell) {
        drugstoreProductSell.setDrugstore(this);
    }

    public void addFormation(DrugstoreFormation drugstoreFormation) {
        drugstoreFormation.setDrugstore(this);
    }

    public float getDistance(float longitude, float latitude) {
        float latitude1 = (float) (latitude * Math.PI / 180);
        float latitude2 = (float) (this.latitude * Math.PI / 180);

        float longitude1 = (float) (longitude * Math.PI / 180);
        float longitude2 = (float) (latitude * Math.PI / 180);

        float R = 6371f;
        float d = (float) (R * Math.acos(Math.cos(latitude1) * Math.cos(latitude2) *
                        Math.cos(longitude2 - longitude1) + Math.sin(latitude1) *
                        Math.sin(latitude2)));
        return d;
    }
}
