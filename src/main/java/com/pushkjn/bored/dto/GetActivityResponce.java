package com.pushkjn.bored.dto;

import java.util.UUID;

import com.pushkjn.bored.model.Activity;

import lombok.Data;

@Data
public class GetActivityResponce {
    private String activity;
    private Integer challenge;
    private UUID id;
    private String category;

    public static GetActivityResponce from(Activity activity) {
        GetActivityResponce responce = new GetActivityResponce();

        responce.setActivity(activity.getActivity());
        responce.setChallenge(activity.getChallenge());
        responce.setId(activity.getExternal_id());
        responce.setCategory(activity.getCategory());

        return responce; 
    }
}
