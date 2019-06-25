package cn.wolfcode.trip.base.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
public class Region {
    private Long id;

    private String name;

    private Region parent;

    private Integer state;

}