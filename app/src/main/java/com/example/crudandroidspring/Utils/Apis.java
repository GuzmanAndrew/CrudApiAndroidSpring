package com.example.crudandroidspring.Utils;

public class Apis {
    public static final String URL_001 = "http://192.168.1.6:8081/api/";

    public static PresionService getPresionService() {
        return Clients.getPresion(URL_001).create(PresionService.class);
    }
}
