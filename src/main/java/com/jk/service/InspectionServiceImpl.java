package com.jk.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jk.beans.Inspection;
import com.jk.mapper.InspectionMapper;

@Service
public class InspectionServiceImpl implements InspectionService{

	@Resource
	private InspectionMapper  inspectionMapper;

	public List<Inspection> queryAll(Map<String, Object> map) {
		return inspectionMapper.queryAll(map);
	}

	public Inspection queryById(Integer id) {
		// TODO Auto-generated method stub
		return inspectionMapper.queryById(id);
	}

	public void updateStatus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		 inspectionMapper.updateStatus(map);
	}
}
