package com.pxg.pojo;

import lombok.Data;

@Data
public class UserOtherMessage {
    private String name;
    private String company;
    private String city;
    private String age;
    private String identitycard;
    private String companyfront;
    private String companyrear;
    private String operatingpost;
    private String bankid;

    public UserOtherMessage(String name, String company, String city, String age, String identitycard,
                            String companyfront, String companyrear, String operatingpost, String bankid) {
        this.name = name;
        this.company = company;
        this.city = city;
        this.age = age;
        this.identitycard = identitycard;
        this.companyfront = companyfront;
        this.companyrear = companyrear;
        this.operatingpost = operatingpost;
        this.bankid = bankid;
    }

    public UserOtherMessage() {

    }
}
