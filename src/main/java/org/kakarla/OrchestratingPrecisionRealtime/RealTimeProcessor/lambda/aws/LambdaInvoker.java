package org.kakarla.OrchestratingPrecisionRealtime.RealTimeProcessor.lambda.aws;

import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.InvokeRequest;
import software.amazon.awssdk.services.lambda.model.InvokeResponse;

import java.util.concurrent.Callable;

public class LambdaInvoker implements Callable<String> {

    private String functionName = "myfifrstLambda";

    public LambdaInvoker(String functionName) {
        this.functionName = functionName;
    }

    InvokeResponse trigger() throws Exception {
        InvokeResponse invokeResponse = null;
        LambdaClient lambdaClient = LambdaClient.builder().build();
        try {
            InvokeRequest invokeRequest = InvokeRequest.builder().
                    functionName(functionName).
                    payload(SdkBytes.fromUtf8String("{ \"key\": \"value\" }")).
                    build();
            invokeResponse = lambdaClient.invoke(invokeRequest);
            System.out.println(invokeResponse);
        } catch (Exception e) {
            throw new Exception("Failed to call Lambda request");
        }
        return invokeResponse;
    }

    @Override
    public String call() throws Exception {
        return "value";
    }
}
