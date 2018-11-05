package com.spbstu.utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.spbstu.hw5.entities.Data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.Map;

public class ResourceLoader {

    private static Map<String, Data> data;

    static {
        try {
            load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private ResourceLoader() {
        // not called
    }

    private static void load() throws FileNotFoundException, UnsupportedEncodingException {
        FileReader fileReader = new FileReader(
                // to avoid path problem in Jenkins
                URLDecoder.decode(
                        ResourceLoader.class.getClassLoader().getResource("MetalsColorsDataSet.json").getFile(),
                        "UTF-8"
                )
        );
        JsonReader jsonReader = new JsonReader(fileReader);

        Type type = new TypeToken<Map<String, Data>>() {
        }.getType();

        data = new Gson().fromJson(jsonReader, type);
    }

    public static Data getData(String dataId) {
        return data.get(dataId);
    }

    public static Object[][] getAllData() {
        Object[][] result =  new Data [data.values().size()][];
        int i = 0;
        for (Data element : data.values()) {
            result[i] = new Data[] {element};
            i += 1;
        }
        return result;
    }
}
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import com.spbstu.hw8.entities.Data;
//import lombok.SneakyThrows;
//
//import java.io.InputStream;
//import java.lang.reflect.Type;
//import java.util.Map;
//
//public class ResourceLoader {
//    static String convertStreamToString(java.io.InputStream is) {
//        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
//        return s.hasNext() ? s.next() : "";
//    }
//
//    private static Map<String, Data> DATA;
//
//    static {
//        load();
//    }
//
//    @SneakyThrows
//    private static void load() {
//        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        InputStream is = classloader.getResourceAsStream("MetalsColorsDataSet.json");
//
//        Type type = new TypeToken<Map<String, Data>>() {}.getType();
//
//        String theString = convertStreamToString(is);
//
//        DATA = new Gson().fromJson(theString, type);
//
//    }
//
//    public static Data getData(String dataId) {
//        return DATA.get(dataId);
//    }
//
//    public static Object[] getAllData() {
//        return DATA.values().toArray();
//    }
//}