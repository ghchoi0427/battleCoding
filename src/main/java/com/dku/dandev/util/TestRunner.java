package com.dku.dandev.util;

import com.dku.dandev.domain.GradingEntity;
import com.dku.dandev.domain.TestStatus;
import com.dku.dandev.domain.Testcase;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class TestRunner {
    private final String PATH = "submissions";

    public void checkDirectory() {
        File directory = new File(PATH);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public GradingEntity<TestStatus> runTest(String src, List<Testcase> testcases) throws IOException {
        String filename = createSubmissionFile(src);
        GradingEntity<TestStatus> compileResult = compile(filename);
        if (compileResult.getTestResult() != TestStatus.succeed) {
            System.out.println("Error: " + compileResult.getTestResult());
            return compileResult;
        }
        return testInput(filename, testcases);
    }

    public String createSubmissionFile(String src) throws IOException {
        checkDirectory();
        String filename = PATH + "/Program.java";
        File file = new File(filename);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(src.getBytes(StandardCharsets.UTF_8));
        fos.close();
        return filename;
    }

    public GradingEntity<TestStatus> testInput(String filename, List<Testcase> testcases) throws IOException {
        int hitCount = 0;
        for (Testcase testcase : testcases) {
            GradingEntity<TestStatus> executeResult = execute(filename, testcase.getInput());
            if (executeResult.getTestResult() != TestStatus.succeed) {
                System.out.println("Error: " + executeResult.getTestResult());
                continue;
            }
            if (testcase.getOutput().trim().equals(executeResult.getBody().trim())) {
                hitCount++;
            }
        }
        if (testcases.size() == 0) {
            return new GradingEntity<>(TestStatus.noTestcase);
        }

        GradingEntity<TestStatus> succeed = new GradingEntity<>(TestStatus.succeed);
        succeed.setBody(String.valueOf(hitCount * 100 / testcases.size()));
        return succeed;
    }

    private GradingEntity<TestStatus> compile(String filename) throws IOException {    // 정상적으로 컴파일 시 null 반환, 에러시 에러메시지 반환
        String compileCommand = "javac " + filename;
        Process compileProcess = Runtime.getRuntime().exec(compileCommand);
        InputStream pos = compileProcess.getErrorStream();
        String errorMessage = read(pos);
        if (errorMessage.contains("error")) {      //TODO: need more elegant way to detect error occurrence
            GradingEntity<TestStatus> compileError = new GradingEntity<>(TestStatus.compileError);
            compileError.setBody(errorMessage);
            return compileError;
        }
        return new GradingEntity<>(TestStatus.succeed);
    }

    private GradingEntity<TestStatus> execute(String filename, String input) throws IOException {
        String execCommand = "java " + filename;
        Process execProcess = Runtime.getRuntime().exec(execCommand);
        InputStream errorStream = execProcess.getErrorStream();
        OutputStream pos = execProcess.getOutputStream();
        InputStream pis = execProcess.getInputStream();

        write(pos, input);
        print(errorStream);

        //TODO: 실행 시 에러 검증

        GradingEntity<TestStatus> succeed = new GradingEntity<>(TestStatus.succeed);
        succeed.setBody(read(pis));
        return succeed;
    }

    public void write(OutputStream outputStream, String input) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(input);
        bw.close();
    }

    public void print(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public String read(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        br.close();
        return sb.toString();
    }

}
