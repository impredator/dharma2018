package com.dharma.patterns.gof.structure.facade;

import java.sql.Connection;

class MySqlHelper {

    public static Connection getMySqlDBConnection() {
        System.out.println("get MySql DB connection using connection parameters");
        return null;
    }

    public void generateMySqlPDFReport(String tableName, Connection con) {
        System.out.println("MYSQL: get data from table and generate pdf report");
    }

    public void generateMySqlHTMLReport(String tableName, Connection con) {
        System.out.println("MYSQL: get data from table and generate pdf report");
    }
}

class OracleHelper {

    public static Connection getOracleDBConnection() {
        System.out.println("get Oracle DB connection using connection parameters");
        return null;
    }

    public void generateOraclePDFReport(String tableName, Connection con) {
        System.out.println("ORACLE: get data from table and generate pdf report");
    }

    public void generateOracleHTMLReport(String tableName, Connection con) {
        System.out.println("ORACLE: get data from table and generate pdf report");
    }

}

class HelperFacade {

    public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName) {
        Connection con = null;
        switch (dbType) {
            case MYSQL:
                con = MySqlHelper.getMySqlDBConnection();
                MySqlHelper mySqlHelper = new MySqlHelper();
                switch (reportType) {
                    case HTML:
                        mySqlHelper.generateMySqlHTMLReport(tableName, con);
                        break;
                    case PDF:
                        mySqlHelper.generateMySqlPDFReport(tableName, con);
                        break;
                }
                break;
            case ORACLE:
                con = OracleHelper.getOracleDBConnection();
                OracleHelper oracleHelper = new OracleHelper();
                switch (reportType) {
                    case HTML:
                        oracleHelper.generateOracleHTMLReport(tableName, con);
                        break;
                    case PDF:
                        oracleHelper.generateOraclePDFReport(tableName, con);
                        break;
                }
                break;
        }

    }

    public enum DBTypes {
        MYSQL, ORACLE
    }

    public enum ReportTypes {
        HTML, PDF
    }
}

public class DemoFacade {
    public static void main(String[] args) {
        String tableName = "Employee";

        //不使用门面
        Connection con = MySqlHelper.getMySqlDBConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        mySqlHelper.generateMySqlHTMLReport(tableName, con);

        Connection con1 = OracleHelper.getOracleDBConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOraclePDFReport(tableName, con1);

        //使用门面
        HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, tableName);
        HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, tableName);
    }
}
