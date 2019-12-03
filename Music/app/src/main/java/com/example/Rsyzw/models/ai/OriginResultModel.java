package com.example.Rsyzw.models.ai;

public class OriginResultModel {

    private Long corpus_no;
    private int err_no;
    private ResultModel result;
    private String sn;
    private Double voice_energy;

    public Long getCorpus_no() {
        return corpus_no;
    }

    public void setCorpus_no(Long corpus_no) {
        this.corpus_no = corpus_no;
    }

    public int getErr_no() {
        return err_no;
    }

    public void setErr_no(int err_no) {
        this.err_no = err_no;
    }

    public ResultModel getResult() {
        return result;
    }

    public void setResult(ResultModel result) {
        this.result = result;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Double getVoice_energy() {
        return voice_energy;
    }

    public void setVoice_energy(Double voice_energy) {
        this.voice_energy = voice_energy;
    }
}
