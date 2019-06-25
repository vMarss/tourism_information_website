package cn.wolfcode.trip.base.mapper;

import cn.wolfcode.trip.base.domain.Region;
import java.util.List;

public interface RegionMapper {

    int insert(Region record);

    Region selectByPrimaryKey(Long id);

    List<Region> selectAll();

}