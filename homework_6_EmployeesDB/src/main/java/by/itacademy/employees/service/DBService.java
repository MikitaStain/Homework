package by.itacademy.employees.service;

import by.itacademy.employees.res.NameResourse;
import by.itacademy.employees.storage.api.EDepartmentName;
import by.itacademy.employees.storage.api.EPositionName;

import java.util.List;

public class DBService {

    private EDepartmentName eDepartmentName;
    private EPositionName ePositionName;
    private AddNewElementInDB addNewElementInDB;
    private NameResourse nameResourse;

    public List<String> getNamePosition(){
        return ePositionName.addPositionNameInList(ePositionName.ePositionNameList);
    }
    public List<String> getNameDepartment(){
        return eDepartmentName.addDepartmentNameInList(eDepartmentName.eDepartmentNameList);
    }
    public void addInDB(){
        List<String> nameInDBDepartment = addNewElementInDB.getNameInDB(nameResourse.NAME_DEPARTMENT_TABLE);
        List<String> nameInDBPosition = addNewElementInDB.getNameInDB(nameResourse.NAME_POSITION_TABLE);

        addNewElementInDB.addNameInDB(getNamePosition(),
                nameInDBPosition,
                nameResourse.NAME_DB,
                nameResourse.NAME_POSITION_TABLE,
                nameResourse.NAME_COLUMN_POSITION);

        addNewElementInDB.addNameInDB(getNameDepartment(),
                nameInDBDepartment,
                nameResourse.NAME_DB,
                nameResourse.NAME_DEPARTMENT_TABLE,
                nameResourse.NAME_COLUMN_DEPARTMENT);
    }



}
