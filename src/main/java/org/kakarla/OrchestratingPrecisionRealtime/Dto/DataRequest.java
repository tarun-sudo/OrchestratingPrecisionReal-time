package org.kakarla.OrchestratingPrecisionRealtime.Dto;

import lombok.Data;

@Data
public class DataRequest {

    private String CustomerId;

    private String CustomerClassification;

    private String CustomerType;

    private String lastFour;

    private String firstSix;
}
