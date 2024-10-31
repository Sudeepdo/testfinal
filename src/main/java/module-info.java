module com.example.test2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mariadb.jdbc; // MariaDB JDBC driver


    opens com.example.test2 to javafx.fxml;
    exports com.example.test2;
}