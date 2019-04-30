package com.no.company.workfordayserver.jsonmodels;

import com.no.company.workfordayserver.entities.Hashtag;

import java.util.List;

public class FiltersForWork {

    private Double lowBudget;
    private Double highBudjet;
    private Double lat;
    private Double ln;
    private Double radius;
    private List<Hashtag> hashtagList;
    private int page;
    private int results;

    public Double getLowBudget() {
        return lowBudget;
    }

    public void setLowBudget(Double lowBudget) {
        this.lowBudget = lowBudget;
    }

    public Double getHighBudjet() {
        return highBudjet;
    }

    public void setHighBudjet(Double highBudjet) {
        this.highBudjet = highBudjet;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLn() {
        return ln;
    }

    public void setLn(Double ln) {
        this.ln = ln;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        if (results>50) results = 50;
        this.results = results;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public List<Hashtag> getHashtagList() {
        return hashtagList;
    }

    public void setHashtagList(List<Hashtag> hashtagList) {
        this.hashtagList = hashtagList;
    }
}
