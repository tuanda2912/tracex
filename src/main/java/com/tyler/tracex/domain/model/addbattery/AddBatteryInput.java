package com.tyler.tracex.domain.model.addbattery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddBatteryInput implements Serializable {
    private static final long serialVersionUID = 1787208969968399440L;

    @Valid
    @Schema(description = "Add battery detail List")
    private List<AddBatteryDetailInput> addBatteryDetailList;

    //some more detail if needed
}
