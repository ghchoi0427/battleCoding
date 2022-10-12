package com.dku.dandev.util;


import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class TestRunner {
    private final String PATH = "submissions";
    private final String PREFIX = "S";

    public void checkDirectory() {
        File directory = new File(PATH);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public String createSubmissionFile(Long submissionId, String src) throws IOException {
        checkDirectory();
        String filename = PATH + "/" + PREFIX + submissionId + ".java";
        File file = new File(filename);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(src.getBytes(StandardCharsets.UTF_8));
        fos.close();
        return filename;
    }

}
