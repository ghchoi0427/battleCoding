package com.dku.dandev.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@SpringBootTest
class TestRunnerTest {

    String src = "public class TestRunner {\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.println(\"Hello world\");\n" +
            "    }\n" +
            "}\n";

    String src2 = "public class TestRunner {\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.println(\"this is test\");\n" +
            "    }\n" +
            "}\n";

    @Test
    void 파일생성() throws IOException {
        File f = new File("name.java");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(src.getBytes(StandardCharsets.UTF_8));

        f.createNewFile();
    }

    @Test
    void 파일생성_이름지정() throws IOException {
        // 폴더 이름 = problemId + '-' +  userId
        // 파일 이름 = problemId + '-' + userId + '-' + submissionId
        String filename = UUID.randomUUID().toString();
        File f = new File(filename + ".java");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(src.getBytes(StandardCharsets.UTF_8));

        if (f.createNewFile()) {
            System.out.println("success");
        } else {
            System.out.println("no");
        }
    }

    @Test
    void 디렉토리_생성2() {
        String path = "temp";
        File directory = new File(path);
        boolean mkdir = directory.mkdir();
        if (mkdir) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    @Test
    void 디렉토리_생성_파일_생성() throws IOException {
        String path = "submissions";
        String filename = "def.java";

        checkDirectory();

        File file = new File(path + "/" + filename);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(src.getBytes(StandardCharsets.UTF_8));
        fos.close();
    }

    void checkDirectory() {
        String path = "submissions";
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    void createFile() throws IOException {
        String filename = UUID.randomUUID().toString();
        File f = new File(filename + ".java");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(src.getBytes(StandardCharsets.UTF_8));
        f.createNewFile();
    }

    @Test
    void 입출력() throws IOException {
        createFile();
    }

}