package org.kakarla.OrchestratingPrecisionRealtime.Service;

import org.kakarla.OrchestratingPrecisionRealtime.model.DecisionModel;

public interface RealTime {

     DecisionModel decisions();

     void invokeRealTimelambda();

}
