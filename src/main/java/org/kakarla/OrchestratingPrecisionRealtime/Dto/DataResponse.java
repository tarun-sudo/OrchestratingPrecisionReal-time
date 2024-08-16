package org.kakarla.OrchestratingPrecisionRealtime.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@NonNull
public class DataResponse {
    private String CustomerId;

    private String CustomerClassification;

    private String CustomerType;

    private String lastFour;

    private String firstSix;
}
