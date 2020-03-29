package com.jk.mapper;

import java.util.List;
import java.util.Map;

import com.jk.beans.Inspection;

public interface InspectionMapper {

	public void insert(Inspection is);
	
	public List<Inspection> queryAll(Map<String,Object> map);

	public Inspection queryById(Integer id);

	public void updateStatus(Map<String, Object> map);
}
