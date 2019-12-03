package com.example.Rsyzw.models.ai;

import java.util.List;

public class AsrPartialModel {

    private String best_result;
    private int error;
    private OriginResultModel origin_result;
    private String result_type;
    private List<String> results_recognition;

    public String getBest_result() {
        return best_result;
    }

    public void setBest_result(String best_result) {
        this.best_result = best_result;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public OriginResultModel getOrigin_result() {
        return origin_result;
    }

    public void setOrigin_result(OriginResultModel origin_result) {
        this.origin_result = origin_result;
    }

    public String getResult_type() {
        return result_type;
    }

    public void setResult_type(String result_type) {
        this.result_type = result_type;
    }

    public List<String> getResults_recognition() {
        return results_recognition;
    }

    public void setResults_recognition(List<String> results_recognition) {
        this.results_recognition = results_recognition;
    }
}
