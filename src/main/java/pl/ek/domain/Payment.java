package pl.ek.domain;

import lombok.Getter;

@Getter
public enum Payment {
    CREDITCARD("CREDIT CARD"),
    CASH("CASH"),
    TRANSFER("TRANSFER");

    private  String name;
    private Payment(String name){
        this.name=name;
    }
}
