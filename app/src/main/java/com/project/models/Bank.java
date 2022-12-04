package com.project.models;

import java.io.Serializable;

public class Bank implements Serializable {
    int bankLogo;
    String bankName;

    public Bank(int bankLogo, String bankName) {
        this.bankLogo = bankLogo;
        this.bankName = bankName;
    }

    public int getBankLogo() {
        return bankLogo;
    }

    public void setBankLogo(int bankLogo) {
        this.bankLogo = bankLogo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
