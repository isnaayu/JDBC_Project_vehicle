package repository.impl;

import configuration.DbConnector;
import entity.Vehicle;
import repository.VehicleRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepoImpl implements VehicleRepo {
    DbConnector dbConnector = new DbConnector();
    private Connection conn = dbConnector.startConnect();
//    Connection conn;

    public VehicleRepoImpl(Connection conn) {
        this.conn = conn;
    }

    public VehicleRepoImpl() {
    }

    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> data = new ArrayList<>();
        try {
            PreparedStatement pr = conn.prepareStatement("SELECT * FROM m_vehicle");
            ResultSet result = pr.executeQuery();
            while (result.next()){
                Integer id = result.getInt("id");
                String model = result.getString("model");
                String brand = result.getString("brand");
                Integer production_year = result.getInt("production_year");
                String color = result.getString("color");
                Integer sale_price = result.getInt("sale_price");
                Integer stock = result.getInt("stock");
                String status = result.getString("status");
                data.add(new Vehicle(id, model, brand, production_year, color, sale_price, stock, status));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return data;
    }

    @Override
    public void save(Vehicle vehicle) {
        vehicle.setId();
        String model = "Tesla";
        String brand = "Tesla V2";
        Integer production_color = 2023;
        String color= "Putih";
        Integer sale_price=350000000;
        Integer stock=15;
        String status= "NEW";
        try {
            PreparedStatement pr = conn.prepareStatement("INSERT INTO m_vehicle (model, brand, production_year, color, sale_price, stock, status) VALUES (?,?,?,?,?,?,?)";
            ResultSet result = pr.executeQuery();

        }catch ()
    }

    @Override
    public void update(Vehicle vehicle) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Vehicle getById(Integer id) {
        return null;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
