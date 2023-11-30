import configuration.DbConnector;
import repository.VehicleRepo;
import repository.impl.VehicleRepoImpl;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException{
        VehicleRepoImpl repo = new VehicleRepoImpl();
        System.out.println(repo.getAll());


//        try{
//            repo.getConn().setAutoCommit(true);
//            PreparedStatement pr = repo.getConn().prepareStatement("UPDATE m_employee SET salary=salary+500000 WHERE id=1");
//            pr.executeQuery();
//            PreparedStatement pr2 = repo.getConn().prepareStatement("UPDATE m_employee SET salary=salary-500000 WHERE id=2");
//            pr2.executeQuery();
//            repo.getConn().commit();
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }





























//        DbConnector dbConnector = new DbConnector();
//        Connection conn = dbConnector.startConnect();



//
////        String url = "jdbc:postgresql://localhost/db_sinar_harapan_makmur";
////        String username = System.getenv("USERNAME_DB");
////        String password = System.getenv("PASSWORD_DB");
////
//        try(conn) {
//////            DML
////            Statement statement1 = conn.createStatement();
////            String query2 = "INSERT INTO m_vehicle (brand, model, production_year, color, sale_price, stock, status) VALUES('Tesla', 'Yaris', 2022, 'red', 300000000, 10, 'NEW')";
////
////            try {
////                int count = statement1.executeUpdate(query2);
////            }catch (SQLException e){
////                System.out.println(e.getMessage());
////            }
////
////
////
////
////
////
////            System.out.println("success");
////            Statement statement = conn.createStatement();
//////            Gunakan ResultSet untuk digunkan menampung data hasil
//////            DQL -> excuteQuery()
////            int minimal = 3000000;
////            String query = "SELECT * FROM m_vehicle where sale_price> "+minimal+" and id<"+3;
////            ResultSet result = statement.executeQuery(query);
////
////            while (result.next()){
////                System.out.println(result.getInt("sale_price"));
////            }
////
//////            PreparedStatement preparedStatement = conn.prepareStatement("select * from m_employee where salary>? and id>? order by id limit 3 ");
////            PreparedStatement preparedStatement = conn.prepareStatement("select * from m_employee where salary>? and first_name ilike ?");
//////            preparedStatement.setInt(2,5);
////            preparedStatement.setString(2,"%c");
////            preparedStatement.setInt(1, minimal);
////            ResultSet rs = preparedStatement.executeQuery();
////
////            while (rs.next()){
////                System.out.println(rs.getString("first_name"));
////            }
//
//
//            Statement statement = conn.createStatement();
////            String query = "ALTER TABLE m_customer ADD COLUMN password VARCHAR(50)";
////            String query = "UPDATE m_customer SET password='isna' WHERE id=11";
////            String email = "isnaayu2@gmail.com";
////            String password_user = "isna";
//            String email,password_user;
//            Scanner input = new Scanner(System.in);
//
//            System.out.print("email = ");
//            email = input.nextLine();
//            System.out.print("password = ");
//            password_user = input.nextLine();
//
//            String query = "SELECT * FROM m_customer WHERE email="+"'"+email+"'"+" AND password="+"'"+password_user+"'";
////            ResultSet resultSet = statement.executeQuery(query);
//            ResultSet result = statement.executeQuery(query);
//
//            try(result) {
//                if (result.next()){
//                    System.out.print("sukses");
//                }else {
//                    System.out.print("failed");
//                }
//            }catch (SQLException e){
//                System.out.println(e.getMessage());
//            }
//
////            result.close();
////            statement.close();
////            statement1.close();
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
    }
}