package ru.myapp.enums;

public enum TypeEnum {
    Cat, Dog, Bird;
    public static TypeEnum getType(String status){
        for (TypeEnum type : TypeEnum.values()) {
            if(type.name().equals(status)) {
                return type;
            }
        }
        return null;
    }
}
