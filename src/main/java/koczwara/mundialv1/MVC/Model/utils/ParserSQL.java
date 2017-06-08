package koczwara.mundialv1.MVC.Model.utils;

import koczwara.mundialv1.MVC.Model.Connection.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Mroziqella on 22.04.2017.
 */
public class ParserSQL {
    private static Connection connection = ConnectionDB.getConnection();

    public PreparedStatement parseQuery(String query, Object... args) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for(int i=1;i<=args.length;i++){
                Object arg = args[i-1];
                if(arg instanceof String) {
                    statement.setString(i,(String) arg);
                }else if(arg instanceof Integer){
                    statement.setInt(i, (Integer) arg);
                }else if(arg instanceof Long){
                    statement.setLong(i,(Long) arg);
                }
                else if (arg instanceof Boolean){
                    statement.setBoolean(i, (Boolean) arg);
                }
                else {
                    throw new NotImplement("Nie obsługiwany format zaimplementuj go!!!");
                }
            }
            System.out.println("Zbudowano zapytanie: "+statement);
            return statement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
