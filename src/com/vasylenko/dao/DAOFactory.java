package com.vasylenko.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOFactory {
    private static DAOFactory instance = null;
    DataSource ds;

    private DAOFactory() throws NamingException {
        InitialContext initialContext = new InitialContext();
        ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/cmd");
    }

    public static DAOFactory getInstance() {
        if (instance == null) {
            try {
                instance = new DAOFactory();
            } catch (NamingException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        return instance;
    }

    public FunctionParamDAO getFunctionParamDAO() {
        return new FunctionParamDAO(ds);
    }

    public FunctionGroupDAO getFunctionGroupDAO() {
        return new FunctionGroupDAO(ds);
    }

    public FunctionDAO getFunctionDAO() {
        return new FunctionDAO(ds);
    }
}
