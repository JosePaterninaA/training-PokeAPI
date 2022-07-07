package com.obwankenobi.pokedex.services.utils;

import java.io.IOException;

public class TestFileLoader {

    public static String getJsonFromFileName(final String filename) throws IOException {
        return new String( TestFileLoader.class.getClassLoader().getResourceAsStream(filename + ".json").readAllBytes());
    }
}

