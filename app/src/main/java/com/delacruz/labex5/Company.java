package com.delacruz.labex5;

/*
Making of object TopCopmanyr
 */
public class Company {
    private int cLogo;
    private String cName, cCountry, cIndustry, cCeo, cInfo;

    /*
    Constructor
     */
    public Company(int cLogo, String cName, String cCountry, String cIndustry, String cCeo, String cInfo) {
        this.cLogo = cLogo;
        this.cName = cName;
        this.cCountry = cCountry;
        this.cIndustry = cIndustry;
        this.cCeo = cCeo;
        this.cInfo = cInfo;
    }

   /*
    Getters
     */

    public int getcLogo() {
        return cLogo;
    }

    public String getcName() {
        return cName;
    }

    public String getcCountry() {
        return cCountry;
    }

    public String getcIndustry() {
        return cIndustry;
    }

    public String getcCeo() {
        return cCeo;
    }

    public String getcInfo() {
        return cInfo;
    }
}

