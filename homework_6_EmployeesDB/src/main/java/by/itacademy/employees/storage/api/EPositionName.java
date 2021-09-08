package by.itacademy.employees.storage.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum EPositionName {

    HR_MANAGER("HR manager"),
    LABORATORY_ASSISTANT("Laboratory assistant"),
    TECHNICIAN("Technician"),
    COMMODITY_SPECIALIST("Commodity specialist"),
    ECONOMIST("Economist"),
    LEGAL_ADVISOR("Legal advisor"),
    PSYCHOLOGIST("Psychologist"),
    APPRAISER("Appraiser"),
    INTERPRETER("Interpreter"),
    MANAGER("Manager");

    public final String POSITION_NAME;

    public final List<EPositionName> ePositionNameList = Arrays.asList(EPositionName.values());

    EPositionName(String positName) {
        this.POSITION_NAME = positName;
    }
    public List<String> addPositionNameInList(List<EPositionName> examples) {

        List<String> positionName = new ArrayList<>();
        for (int i = 0; i < values().length; i++) {
            String name = examples.get(i).POSITION_NAME;
            positionName.add(name);
        }
        return positionName;
    }

}
