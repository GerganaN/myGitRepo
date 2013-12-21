package com.skrill.interns.weather;

public enum Cities {

    SOFIA("http://sinoptik.bg/sofia-bulgaria-100727011"), VARNA("http://sinoptik.bg/vratsa-bulgaria-100725712"), VRACA(
            "http://sinoptik.bg/varna-bulgaria-100726050"), YAMBOL("http://sinoptik.bg/yambol-bulgaria-100725578"), MONTANA(
            "http://sinoptik.bg/montana-bulgaria-100729114"), BURGAS("http://sinoptik.bg/burgas-bulgaria-100732770"), PLOVDIV(
            "http://sinoptik.bg/plovdiv-bulgaria-100728193");

    private String url;

    Cities(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
