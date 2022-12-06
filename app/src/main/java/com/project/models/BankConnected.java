package com.project.models;

import java.io.Serializable;

public class BankConnected implements Serializable {

    String bankName;
    Double bankTienNap;
    Double bankSoDu;

    public BankConnected(String bankName, Double bankTienNap, Double bankSoDu) {

        this.bankName = bankName;
        this.bankTienNap = bankTienNap;
        this.bankSoDu = bankSoDu;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Double getBankTienNap() {
        return bankTienNap;
    }

    public void setBankTienNap(Double bankTienNap) {
        this.bankTienNap = bankTienNap;
    }

    public Double getBankSoDu() {
        return bankSoDu;
    }

    public void setBankSoDu(Double bankSoDu) {
        this.bankSoDu = bankSoDu;
    }
}
