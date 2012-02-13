package com.spark

class UG {
    String name;
    //private Country country;
    String webSite;
    Double latitude;
    Double longitude;
    String infos;
    Boolean modifiedKmlData;
    byte[] logo;
    String contactName;
    String contactEmail;
    String timeZoneId;
    byte[] certificateTemplate;
    String internalFriendlyName;
    static constraints = {
        name(blank:false)
        webSite(nullable:true)
        latitude(nullable:true)
        longitude(nullable:true)
        infos(nullable:true)
        logo(nullable:true)
        contactName(nullable:true)
        contactEmail( nullable:true, email:true)
        timeZoneId(nullable:true)
        certificateTemplate(nullable:true)
        internalFriendlyName(nullable:true)
    }
}
