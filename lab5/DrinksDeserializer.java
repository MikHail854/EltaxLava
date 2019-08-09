package ru.eltex.app.lab5;

import com.google.gson.*;
import ru.eltex.app.lab1.Phone;
import ru.eltex.app.lab1.Smartphone;
import ru.eltex.app.lab1.TheTablet;

import java.lang.reflect.Type;

public class DrinksDeserializer implements JsonDeserializer <Drinks>{
    @Override
    public Drinks deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.has("typephone")){
            return context.deserialize((jsonObject, Phone.class));
        }
        if (jsonObject.has("typesmartphone")){
            return context.deserialize(jsonObject, Smartphone.class);
        }
        else {
            return context.deserialize(jsonObject,
                    TheTablet.class);
        }
    }
}
