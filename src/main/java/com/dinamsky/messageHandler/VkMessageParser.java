package com.dinamsky.messageHandler;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class VkMessageParser {

    private JsonParser parser;
    private JsonElement jsonElement;
    private JsonObject rootJsonObject;
    private JsonObject childJsonObject;

    private String message;
    private String userId;


    public VkMessageParser(String incomingJson){
        parser = new JsonParser();
        jsonElement = parser.parse(incomingJson);
        rootJsonObject = jsonElement.getAsJsonObject();
        childJsonObject = rootJsonObject.getAsJsonObject("object");
        this.message = childJsonObject.get("body").getAsString();
        this.userId = childJsonObject.get("user_id").getAsString();
    }

    public String getMessage() {
        return message;
    }

    public String getUserId() {
        return userId;
    }

}
