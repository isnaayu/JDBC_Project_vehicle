package repository;

import entity.Vehicle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface VehicleRepo {
    List<Vehicle> getAll();

    void save(Vehicle vehicle) throws SQLException;

    void update(Vehicle vehicle) throws SQLException;

    Vehicle delete(Integer id);

    Vehicle getById(Integer id);
}
