package com.jk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.beans.Inspection;
import com.jk.beans.Status;
import com.jk.service.InspectionService;

@Controller
public class MyController {
	
	@Resource
	private InspectionService inspectionService;
	
	@RequestMapping("queryAll")
	public String queryAll(@RequestParam(defaultValue="1")Integer pageNum,
			Model model,
			Integer id,String keyword,String mes,String name,String product ,String address,
			@RequestParam(defaultValue="0")Double startCapital,@RequestParam(defaultValue="0")Double endCapital,
			String startIdate,String endIdate
			
			){
		
		Map<String, Object> map = new  HashMap<String, Object>();
		map.put("id",id );
		map.put("keyword", keyword);
		map.put("mes",mes );
		map.put("name",name );
		map.put("product", product);
		map.put("address",address );
		map.put("startCapital", startCapital);
		map.put("endCapital", endCapital);
		map.put("startIdate", startIdate);
		map.put("endIdate", endIdate);
		PageHelper.startPage(pageNum, 8);
		List<Inspection> list = inspectionService.queryAll(map);
		PageInfo<Inspection> pi = new PageInfo<Inspection>(list);
		
		model.addAttribute("pi", pi);
		return "queryAll";
	}
	
	@RequestMapping("queryById")
	public String queryById(Integer id,Model model){
		
		Inspection ss = inspectionService.queryById(id);
		System.out.println(ss);
		System.out.println(id);
		model.addAttribute("ss",ss);
		return "update";
	}

	@RequestMapping("updateStatus")
	@ResponseBody
	public boolean updateStatus(Integer id,String status){
		try {
			Map<String, Object> map = new  HashMap<String, Object>();
			map.put("id", id);
			map.put("status", status);
			inspectionService.updateStatus(map);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
