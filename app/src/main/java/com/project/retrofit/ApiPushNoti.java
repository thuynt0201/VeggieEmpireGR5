package com.project.retrofit;

import android.database.Observable;

import com.project.models.NotiReponse;
import com.project.models.NotiSendData;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiPushNoti {
    @Headers(
            {
                    "Content-type:application/json",
                    "Authorization:key=BETJrvpyV4hVVvlVgWLDJ9DDSXfyP1wY_Uxu1Utk1CmgFvCvPa4q9QBkXC_-3eG4aLNgtNOZP37tKOi4lrO2vp0"
            }
    )
    @POST()
    Observable<NotiReponse> sendNotification(@Body NotiSendData data);
}
