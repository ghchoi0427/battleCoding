package com.dku.dandev.util;

import com.dku.dandev.domain.Problem;
import com.dku.dandev.domain.Testcase;
import com.dku.dandev.service.ProblemService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class Crawler {
    private final String baseUrl = "https://www.acmicpc.net";
    private final String problemUrl = "/problem/";
    private final ProblemService problemService;

    public Crawler(ProblemService problemService) {
        this.problemService = problemService;
    }

    public void crawlProblems(int rangeFrom, int rangeTo) {
        for (int i = rangeFrom; i <= rangeTo; i++) {
            run(i);
        }
    }

    public void run(int problemNumber) {
        final String url = baseUrl + problemUrl + problemNumber;
        Connection connection = Jsoup.connect(url);

        try {
            Document document = connection.get();
            Element desc = document.getElementById("problem_description");

            Element input = document.getElementById("problem_input");
            Element output = document.getElementById("problem_output");
            assertElementsNotNull(desc, input, output);
            String example = input.html() + output.html();

            Problem problem = generateProblem(desc.html(), example);
            Long problemId = problemService.saveProblem(problem);

            List<Testcase> testcases = generateTestcase(document, problemId);
            testcases.forEach(problemService::saveTestcase);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void assertElementsNotNull(Element desc, Element input, Element output) {
        assert desc != null;
        assert input != null;
        assert output != null;
    }

    private List<Testcase> generateTestcase(Document document, Long problemId) {
        List<Testcase> result = new ArrayList<>();
        int count = 1;
        while (true) {
            Element input = document.getElementById("sample-input-" + count);
            Element output = document.getElementById("sample-output-" + count);
            if (input == null || output == null) {
                break;
            }
            result.add(new Testcase(input.html(), output.html(), problemId));
            count++;
        }
        return result;
    }

    private Problem generateProblem(String question, String example) {
        return new Problem(question, example);
    }

}
