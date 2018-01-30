package com.cloud.event.dto;

import com.cloud.event.util.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idEvent;
    private String name;
    private String category;
    private String place;
    private String address;
    @JsonFormat(pattern = Constants.PATTERN_ISO_DATE_TIME)
    private Date initialDate;
    @JsonFormat(pattern = Constants.PATTERN_ISO_DATE_TIME)
    private Date finalDate;
    private Boolean isPresencial;

}
