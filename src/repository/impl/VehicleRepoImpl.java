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
    public void save(Vehicle vehicle) throws SQLException {
        Connection conn = getConn();
        conn.setAutoCommit(false);
        String query = "INSERT INTO m_vehicle (model, brand, production_year, color, sale_price, stock, status) VALUES (?,?,?,?,?,?,?::vehicle_status)";
        try(PreparedStatement pr = conn.prepareStatement(query)){
//            PreparedStatement pr = conn.prepareStatement("INSERT INTO m_vehicle (model, brand, production_year, color, sale_price, stock, status) VALUES (?,?,?,?,?,?,?)");
            pr.setString(1, vehicle.getModel());
            pr.setString(2, vehicle.getBrand());
            pr.setInt(3, vehicle.getProduction_year());
            pr.setString(4, vehicle.getColor());
            pr.setInt(5, vehicle.getSale_price());
            pr.setInt(6, vehicle.getStock());
            pr.setString(7, vehicle.getStatus());

            // Execute the update
            pr.executeUpdate();
//            ResultSet result = pr.executeQuery();
            conn.commit();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Vehicle vehicle) throws SQLException {
        Connection conn = getConn();
        conn.setAutoCommit(false);
        String query = "UPDATE m_vehicle SET model=?, brand=?, production_year=?, color=?, sale_price=?, stock=?, status=?::vehicle_status WHERE id=?";
        try(PreparedStatement pr = conn.prepareStatement(query)){
//            PreparedStatement pr = conn.prepareStatement("INSERT INTO m_vehicle (model, brand, production_year, color, sale_price, stock, status) VALUES (?,?,?,?,?,?,?)");
            pr.setString(1, vehicle.getModel());
            pr.setString(2, vehicle.getBrand());
            pr.setInt(3, vehicle.getProduction_year());
            pr.setString(4, vehicle.getColor());
            pr.setInt(5, vehicle.getSale_price());
            pr.setInt(6, vehicle.getStock());
            pr.setString(7, vehicle.getStatus());
            pr.setInt(8, vehicle.getId());

            // Execute the update
            pr.executeUpdate();
//            ResultSet result = pr.executeQuery();
            conn.commit();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Vehicle delete(Integer id){
        Vehicle vehicle = null;

        try (PreparedStatement pr = conn.prepareStatement("DELETE FROM m_vehicle WHERE id = ?")) {
            pr.setInt(1, id);
            ResultSet result = pr.executeQuery();

            while (result.next()) {
                id = result.getInt("id");
                String model = result.getString("model");
                String brand = result.getString("brand");
                Integer production_year = result.getInt("production_year");
                String color = result.getString("color");
                Integer sale_price = result.getInt("sale_price");
                Integer stock = result.getInt("stock");
                String status = result.getString("status");

                vehicle = new Vehicle(id, model, brand, production_year, color, sale_price, stock, status);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vehicle;
    }

    @Override
    public Vehicle getById(Integer id) {
        Vehicle vehicle = null;

        try (PreparedStatement pr = conn.prepareStatement("SELECT * FROM m_vehicle WHERE id = ?")) {
            pr.setInt(1, id);
            ResultSet result = pr.executeQuery();

            while (result.next()) {
                id = result.getInt("id");
                String model = result.getString("model");
                String brand = result.getString("brand");
                Integer production_year = result.getInt("production_year");
                String color = result.getString("color");
                Integer sale_price = result.getInt("sale_price");
                Integer stock = result.getInt("stock");
                String status = result.getString("status");

                vehicle = new Vehicle(id, model, brand, production_year, color, sale_price, stock, status);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return vehicle;
    }


    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
