package com.tyler.tracex.domain.model.getnamebatterybyrange;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GetNameBatteryByPostcodeInput implements Serializable {
    private static final long serialVersionUID = -7583721206416035161L;
    private Integer fromPostCode;
    private Integer toPostCode;
    private Integer pageIndex;
    private Integer pageSize;
}
