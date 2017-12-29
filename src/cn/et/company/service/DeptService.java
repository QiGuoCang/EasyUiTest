package cn.et.company.service;

import java.util.List;

import cn.et.company.entity.Emp;
import cn.et.company.entity.TreeNode;
import cn.et.company.utils.PageTools;

public interface DeptService {
	

	public List<TreeNode> queryTreeNode(Integer pid);
	

}