package com.vasylenko.dao;

import com.vasylenko.model.FunctionGroup;
import com.vasylenko.model.FunctionParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FunctionGroupDAO {
    final static String ALL_FUNCTION_GROUPS = "select * from GROUP_FUNCTION";

    DataSource ds;
    FunctionGroupDAO(DataSource ds) {
        this.ds = ds;
    }

    public List<FunctionGroup> allFunctionGroup() {
        List<FunctionGroup> fgList = new ArrayList<FunctionGroup>();
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(ALL_FUNCTION_GROUPS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FunctionGroup fg = new FunctionGroup();
                fg.setId(rs.getInt(1));
                fg.setName(rs.getString(2));
                fg.setDescr(rs.getString(3));
                fg.setCtime(rs.getDate(4));
                fgList.add(fg);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return fgList;
    }
}
