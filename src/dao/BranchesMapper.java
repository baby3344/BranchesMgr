package dao;

import entity.Branches;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BranchesMapper {
    /**
     * 查询所有网点信息的方法
     * @return 所有网点信息集合
     */
    public List<Branches> queryAllBranches();

    /**
     * 根据id查询指定网点信息
     * @param id 网点编号
     * @return 指定网点对象
     */
    public Branches queryBranchesById(@Param("id") int id);

    /**
     * 根据营业执照号查询指定网点信息
     * @param businessNo 营业执照号
     * @return 网点信息对象
     */
    public Branches queryBranchesByBusNo(@Param("businessNo") String businessNo);

    /**
     * 添加新的网点信息的方法的
     * @param branch 待添加网点对象
     * @return 受影响行数
     */
    public int addBranch(Branches branch);


}
