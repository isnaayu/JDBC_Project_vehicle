package entity;

public class Vehicle {
    private Integer id;
    private String model;
    private String brand;
    private Integer production_year;
    private String color;
    private Integer sale_price;
    private Integer stock;
    private String status;

    public Vehicle() {
    }

    public Vehicle(Integer id, String model, String brand, Integer production_year, String color, Integer sale_price, Integer stock, String status) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.production_year = production_year;
        this.color = color;
        this.sale_price = sale_price;
        this.stock = stock;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getProduction_year() {
        return production_year;
    }

    public void setProduction_year(Integer production_year) {
        this.production_year = production_year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSale_price() {
        return sale_price;
    }

    public void setSale_price(Integer sale_price) {
        this.sale_price = sale_price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", production_year=" + production_year +
                ", color='" + color + '\'' +
                ", sale_price=" + sale_price +
                ", stock=" + stock +
                ", status='" + status + '\'' +
                '}';
    }
}
