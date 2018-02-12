package com.vasylenko.jsfBeans;

import com.vasylenko.dao.DAOFactory;
import com.vasylenko.model.Function;
import com.vasylenko.model.FunctionGroup;
import com.vasylenko.model.FunctionParam;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name= "dtSelectionv")
@SessionScoped
public class ViewAllDataBean {
    private List<FunctionGroup> functionGroupList;
    private List<Function> functionList;
    private List<FunctionParam> functionParamList;
    private FunctionGroup selectedGroup;
    private Function selectedFunction;
    private DAOFactory factory = DAOFactory.getInstance();

    public ViewAllDataBean() {
    }

    @PostConstruct
    public void showList() {
        this.functionGroupList = factory.getFunctionGroupDAO().allFunctionGroup();
    }

    public void onRowGroupSelect(SelectEvent event) {
        this.selectedGroup = ((FunctionGroup) event.getObject());
        this.functionList = factory.getFunctionDAO().allFunctionsByGroup(this.selectedGroup);
    }

    public void onRowFunctionSelect(SelectEvent event) {
        this.selectedFunction = ((Function) event.getObject());
        this.functionParamList = factory.getFunctionParamDAO().allParamsByFunction(this.selectedFunction);
    }

    public List<FunctionGroup> getFunctionGroupList() {
        return functionGroupList;
    }

    public void setFunctionGroupList(List<FunctionGroup> functionGroupList) {
        this.functionGroupList = functionGroupList;
    }

    public List<Function> getFunctionList() {
        return functionList;
    }

    public void setFunctionList(List<Function> functionList) {
        this.functionList = functionList;
    }

    public List<FunctionParam> getFunctionParamList() {
        return functionParamList;
    }

    public void setFunctionParamList(List<FunctionParam> functionParamList) {
        this.functionParamList = functionParamList;
    }

    public FunctionGroup getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(FunctionGroup selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public Function getSelectedFunction() {
        return selectedFunction;
    }

    public void setSelectedFunction(Function selectedFunction) {
        this.selectedFunction = selectedFunction;
    }
}
