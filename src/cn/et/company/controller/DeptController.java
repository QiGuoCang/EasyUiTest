package cn.et.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.et.company.entity.Emp;
import cn.et.company.entity.Result;
import cn.et.company.entity.TreeNode;
import cn.et.company.service.DeptService;
import cn.et.company.service.EmpService;
import cn.et.company.utils.PageTools;



@Controller
public class DeptController {
	@Autowired
	EmpService service;
	@Autowired
	DeptService ser;
	@ResponseBody
	@RequestMapping("/queryDept")
	public List<TreeNode> queryDept(Integer id){
		if(id==null){
			id=0;
		}
		return ser.queryTreeNode(id);
		
	}
	
	@ResponseBody
	@RequestMapping("/queryEmp")
	public List<Emp> queryEmp(Integer id){
		System.out.println("Sdfds");
		return service.queryEmp(id);
	}
	
	
	@ResponseBody
	@RequestMapping("/queryEmp1")
	public PageTools queryEmp1(String ename,Integer page,Integer rows){
		System.out.println("sdf");
		return service.queryEmp1(ename, page, rows);
	}
	
	//Ìí¼Ó
	@ResponseBody
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public Result saveStudent(Emp em,MultipartFile aa){
		Result r = new Result();
		r.setCode(1);
		try {
			
			service.saveEmp(em);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
			// TODO: handle exception
		}
		return r;
	}
	//É¾³ý
	@ResponseBody
	@RequestMapping(value="/emp/{eid}",method=RequestMethod.DELETE)
	public Result deleteStudent(@PathVariable String eid,Integer page,Integer rows){
		String [] temp = eid.split(",");
		Result r = new Result();
		r.setCode(1);
		try {
			for (String str : temp) {
				service.deleteEmp(Integer.parseInt(str));
			}
//			String str = null;
//			str.toString();
			
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
			// TODO: handle exception
		}
		return r;
		
		}
	
	//ÐÞ¸Ä
	@ResponseBody
	@RequestMapping(value="/emp/{eid}",method=RequestMethod.PUT)
	public Result updateStudent(@PathVariable Integer eid, Emp emp){
		emp.setId(eid);
		Result r = new Result();
		r.setCode(1);
		try {
			service.updateEmp(emp);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
			// TODO: handle exception
		}
		return r;
		
		}
}