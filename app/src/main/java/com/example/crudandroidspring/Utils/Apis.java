package com.example.crudandroidspring.Utils;

public class Apis {
    public static final String URL_001 = "http://devmedkaback-env.eba-da9gbdsz.us-east-2.elasticbeanstalk.com/api/";

    public static PresionService getPresionService() {
        return Clients.getPresion(URL_001).create(PresionService.class);
    }
}
