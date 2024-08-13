package org.kakarla.OrchestratingPrecisionRealtime.Controller;

import org.kakarla.OrchestratingPrecisionRealtime.Service.RealTime;
import org.kakarla.OrchestratingPrecisionRealtime.model.DecisionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RealTimeController<T> {

    @Autowired
    RealTime realTime;

    @ResponseBody
    DecisionModel getDecisions() throws Exception {
        DecisionModel decisionModel = null;
        try{
            decisionModel =realTime.decisions();
        } catch (Exception exception) {
            throw  new Exception("failed to Query DB");
        }
        return  decisionModel;
    }

    @ResponseBody
    void invokeLambdaFunction() throws Exception {
        try{
            realTime.invokeRealTimelambda();
        } catch (RuntimeException exception) {
            throw  new Exception("failed to Query DB");
        }
    }

}
