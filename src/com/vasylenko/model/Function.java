package com.vasylenko.model;

import java.util.Date;
import java.util.Set;

public class Function {
    private Integer id;
    private String name;
    private String descr;
    private Date ctime;
    private FunctionGroup functionGroup;
    private Set<FunctionParam> functionParam;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public FunctionGroup getFunctionGroup() {
        return functionGroup;
    }

    public void setFunctionGroup(FunctionGroup functionGroup) {
        this.functionGroup = functionGroup;
    }

    public Set<FunctionParam> getFunctionParam() {
        return functionParam;
    }

    public void setFunctionParam(Set<FunctionParam> functionParam) {
        this.functionParam = functionParam;
    }
}
