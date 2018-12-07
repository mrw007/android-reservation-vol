package com.wcompany.mrwah.reservation_vol;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimeSerializer implements JsonSerializer<Time> {
    private static final String TIME_FORMAT = "HH:mm:ss";

    @Override
    public JsonElement serialize(Time src, Type typeOfSrc, JsonSerializationContext context) {

        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT, Locale.FRENCH);
        return new JsonPrimitive(sdf.format(src));
    }
}