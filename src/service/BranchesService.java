package service;

import java.util.List;
import dao.BranchesMapper;
import entity.Branches;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtil;

public class BranchesService {
	BranchesMapper branchesMapper=MyBatisUtil.createSqlSession().getMapper(BranchesMapper.class);

	public List<Branches> queryAllBranches(){

		List<Branches> branches=branchesMapper.queryAllBranches();
		return branches;
	}

	public Branches queryBranchesById(int id) {
		Branches branch=branchesMapper.queryBranchesById(id);
		return branch;
	}

	public Branches queryBranchesByBusNo(String businessNo) {
		Branches branch=branchesMapper.queryBranchesByBusNo(businessNo);
		return branch;
	}
	

	public int addBranch(Branches branch) {
		int result=branchesMapper.addBranch(branch);
		return result;
	}
}
