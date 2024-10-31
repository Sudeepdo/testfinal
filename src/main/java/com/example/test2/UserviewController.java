package com.example.test2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;
public class UserviewController implements Initializable {
    public TextField istudent;
    public TextField iRoom;
    public TextField iteacher;
    public TextField iid;
    public Label msg;

    @FXML
    private TableView<Program> tableView;
    @FXML
    private TableColumn<Program, Integer> id;
    @FXML
    private TableColumn<Program, String> student;
    @FXML
    private TableColumn<Program, String> teacher;
    @FXML
    private TableColumn<Program, Integer> Room;
    ObservableList<Program> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new
                PropertyValueFactory<Program, Integer>("id"));
        student.setCellValueFactory(new
                PropertyValueFactory<Program, String>("student"));
        teacher.setCellValueFactory(new
                PropertyValueFactory<Program, String>("teacher"));
        Room.setCellValueFactory(new
                PropertyValueFactory<Program, Integer>("Room"));
        tableView.setItems(list);
    }

    @FXML
    protected void onHelloButtonClick() {
        populateTable();
    }

    public void populateTable() {
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/lab1.2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM tbl_user";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            list.clear();
            tableView.setItems(list);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String student = resultSet.getString("student");
                String teacher = resultSet.getString("teacher");
                int Room = resultSet.getInt("Room");
                tableView.getItems().add(new Program(id, student, teacher,
                        Room));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadData(ActionEvent actionEvent) {

        String getid = iid.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/lab1.2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM tbl_user WHERE `id` = '" + getid + "' ";

            msg.setText(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String student = resultSet.getString("student");
                String teacher = resultSet.getString("teacher");
                String Room = resultSet.getString("Room");
                istudent.setText(student);
                iteacher.setText(teacher);
                iRoom.setText(Room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void DeleteData(ActionEvent actionEvent) {
        String getid = iid.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/lab1.2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM tbl_user WHERE `id`= '" + getid + "' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertData(ActionEvent actionEvent) {
        String getid = iid.getText();
        String getstudent = istudent.getText();
        String getteacher = iteacher.getText();
        String getRoom = iRoom.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/lab1.2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `tbl_user`(`student`, `teacher`, `room`) VALUES('" + getstudent + "', '" + getteacher + "', '" + getRoom + "')";

            msg.setText(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            populateTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void UpdateData(ActionEvent actionEvent) {
        String getid = iid.getText();
        String getstudent = istudent.getText();
        String getteacher = iteacher.getText();
        String getRoom = iRoom.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/lab1.2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `tbl_user` SET `student`='"+getstudent+"',`teacher`='"+getteacher+"',`room`='"+getRoom+"' WHERE `id` = '"+getid+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}











