package pl.caridina.selenium.uj.utils;

import java.io.File;
import java.nio.file.Paths;

public class CustomFile {

    public String getResourceFilePathString(String fileName) {
        try {
            return Paths.get(
                    new File(getClass()
                            .getClassLoader()
                            .getResource(fileName)
                            .getFile())
                            .getAbsolutePath()).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}