package com.vasylenko.dao;

import com.vasylenko.model.Function;
import com.vasylenko.model.FunctionParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FunctionParamDAO {
    final static String FUNCTION_PARAMS_BY_FUNCTION = "select * from FUN_PARAM "
            + "where ID_FUN=?";

    DataSource ds;
    FunctionParamDAO(DataSource ds) {
        this.ds = ds;
    }

    public List<FunctionParam> allParamsByFunction(Function function) {
        List<FunctionParam> params = new ArrayList<FunctionParam>();
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(FUNCTION_PARAMS_BY_FUNCTION);
            ps.setInt(1, function.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FunctionParam fp = new FunctionParam();
                fp.setId(rs.getInt(1));
                fp.setName(rs.getString(2));
                fp.setDescr(rs.getString(3));
                fp.setCtime(rs.getDate(4));
                fp.setFunction(function);
                params.add(fp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return params;
    }
}
