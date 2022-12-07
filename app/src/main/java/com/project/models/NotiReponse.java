package com.project.models;

public class NotiReponse {
    private long multicast_id;
    private int success,failure,cannoncal_ids;

    public long getMulticast_id() {
        return multicast_id;
    }

    public void setMulticast_id(long multicast_id) {
        this.multicast_id = multicast_id;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getFailure() {
        return failure;
    }

    public void setFailure(int failure) {
        this.failure = failure;
    }

    public int getCannoncal_ids() {
        return cannoncal_ids;
    }

    public void setCannoncal_ids(int cannoncal_ids) {
        this.cannoncal_ids = cannoncal_ids;
    }

    public NotiReponse(){

    }
}
