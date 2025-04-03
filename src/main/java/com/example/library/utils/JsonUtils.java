package com.example.library.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtils {

    public static <T> List<T> convertJson(String path, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(new File(path),
                mapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }

}
