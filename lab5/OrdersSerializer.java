package ru.eltex.app.lab5;

import com.google.gson.*;
import ru.eltex.app.lab2.Orders;

import java.lang.reflect.Type;

public class OrdersSerializer implements JsonSerializer<Orders> {
    @Override
    public JsonElement serialize(Orders orders, Type type, JsonSerializationContext context) {
        JsonObject = new JsonObject();
        result.add("map", context.serialize(orders.getCreateTime().values()));
        return result;
    }
}
