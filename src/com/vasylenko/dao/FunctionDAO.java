package com.vasylenko.dao;

import com.vasylenko.model.Function;
import com.vasylenko.model.FunctionGroup;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FunctionDAO {
    final static String FUNCTIONS_BY_GROUP = "select * from FUNCTIONS"
            + "where ID_GROUP=?";

    DataSource ds;
    FunctionDAO(DataSource ds) {
        this.ds = ds;
    }

    public List<Function> allFunctionsByGroup(FunctionGroup functionGroup) {
        List<Function> functions = new ArrayList<Function>();
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(FUNCTIONS_BY_GROUP);
            ps.setInt(1, functionGroup.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Function fu = new Function();
                fu.setId(rs.getInt(1));
                fu.setName(rs.getString(3));
                fu.setDescr(rs.getString(4));
                fu.setCtime(rs.getDate(5));
                fu.setFunctionGroup(functionGroup);
                functions.add(fu);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return functions;
    }
}
