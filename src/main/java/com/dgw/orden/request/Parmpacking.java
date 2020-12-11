package com.dgw.orden.request;
import lombok.Data;

@Data
public class Parmpacking<T> {
    private int status;
    private String message;
    private T date;


    public static <T> Parmpacking<T> success(T date){
       Parmpacking<T> parmpacking = new Parmpacking();
        parmpacking.setDate(date);
        parmpacking.setMessage(ErrorStatus.SUCCESS.getMessage());
        parmpacking.setStatus(ErrorStatus.SUCCESS.getStatus());
        return parmpacking;
    }



    public static <T> Parmpacking<T> error(){
   Parmpacking<T> parmpacking = new Parmpacking<>();
        parmpacking.setMessage(ErrorStatus.SYS_ERROR.getMessage());
        parmpacking.setStatus(ErrorStatus.SYS_ERROR.getStatus());
        return parmpacking;
    }


}