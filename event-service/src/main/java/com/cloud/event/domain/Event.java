package com.cloud.event.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EVENT1")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_event", nullable = false, unique = true)
    private Integer idEvent;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "place")
    private String place;
    @Column(name = "address")
    private String address;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_start")
    private Date initialDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_final")
    private Date finalDate;
    @Column(name = "presencial")
    private Boolean isPresencial;

}
