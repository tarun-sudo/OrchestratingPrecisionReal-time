package org.kakarla.OrchestratingPrecisionRealtime.Service;


import org.kakarla.OrchestratingPrecisionRealtime.Config.ThreadFactory.CustomConcurrentNumberThreadFactory;
import org.kakarla.OrchestratingPrecisionRealtime.RealTimeProcessor.lambda.aws.LambdaInvoker;
import org.kakarla.OrchestratingPrecisionRealtime.model.DecisionModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Component
public class RealTimeServiceImpl implements RealTime {

    @Override
    public DecisionModel decisions() {
        DecisionModel decisionModel = new DecisionModel();
        decisionModel.setDecisionState("Saved to Aurora DB");
        decisionModel.setDecisionState("true");
        return decisionModel;
    }

    @Override
    public void invokeRealTimelambda() {
        int numberofThreads = 10;
        int numberOfInvocations = 10;
        try {
            // Create a custom ThreadFactory with a base name
            CustomConcurrentNumberThreadFactory threadFactory = new CustomConcurrentNumberThreadFactory("LambdaInvoker");
            ExecutorService executorService = Executors.newFixedThreadPool(numberofThreads, threadFactory);
            List<Future<String>> futureList = new ArrayList<>();

            for (int x = 0; x < numberofThreads; x++) {
                for (int y = 0; y < numberOfInvocations; y++) {
                    LambdaInvoker task = new LambdaInvoker("myfifrstLambda");
                    futureList.add(executorService.submit(task));
                }
            }

            // Process the results
            for (Future<String> future : futureList) {
                try {
                    String result = future.get();
                    System.out.println("Lambda Invocation Result: " + result.concat("Completions"));
                } catch (Exception e) {
                    throw new RuntimeException("Call Failed at");
                }
            }
            executorService.shutdown();
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException("");
        }

    }
}
