package cn.et.company.service;

import java.util.List;

import cn.et.company.entity.Emp;
import cn.et.company.utils.PageTools;

public interface EmpService {
	
	public List<Emp> queryEmp(Integer id);
	public  PageTools queryEmp1(String ename,Integer page,Integer rows);
	
	public void updateEmp(Emp em);
	public void deleteEmp(Integer eid);
	
	public void saveEmp(Emp em);
}
