package com.junhow.gp.controller;

import com.junhow.gp.common.ResponseBean;
import com.junhow.gp.exception.CustomException;
import com.junhow.gp.pojo.UserRole;
import com.junhow.gp.service.IUserRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserRoleController
 * @author CodeGenerator
 * @date 2019/03/16 18:13
 */
@RestController
@RequestMapping("/user/role")
public class UserRoleController {

    private final IUserRoleService userRoleService;

    @Autowired
    public UserRoleController(IUserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    /**
     * 列表
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @GetMapping("/list")
    public Map<String, Object> list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        if (page <= 0 || limit <= 0) {
            page = 1;
            limit = 10;
        }
        PageHelper.startPage(page, limit);
        List<UserRole> list = userRoleService.selectAll();
        if (list == null || list.size() <= 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        PageInfo<UserRole> pageInfo = new PageInfo<UserRole>(list);
        Map<String, Object> result = new HashMap<String, Object>(16);
        result.put("code", 0);
        result.put("count", pageInfo.getTotal());
        result.put("data", pageInfo.getList());
        return result;
    }

    /**
     * 查询
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/detail")
    public ResponseBean detail(@RequestParam Integer id) {
        UserRole userRole = userRoleService.selectByPrimaryKey(id);
        if (userRole == null) {
            throw new CustomException("查询失败(Query Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", userRole);
    }

    /**
     * 新增
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/add")
    public ResponseBean add(@RequestBody UserRole userRole) {
        int count = userRoleService.insert(userRole);
        if (count <= 0) {
            throw new CustomException("新增失败(Insert Failure)");
        }
        return new ResponseBean(200, "新增成功(Insert Success)", userRole);
    }

    /**
     * 更新
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/update")
    public ResponseBean update(@RequestBody UserRole userRole) {
        int count = userRoleService.updateByPrimaryKeySelective(userRole);
        if (count <= 0) {
            throw new CustomException("更新失败(Update Failure)");
        }
        return new ResponseBean(200, "更新成功(Update Success)", userRole);
    }

    /**
     * 删除
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/delete")
    public ResponseBean delete(@RequestParam List<Integer> ids) {
        for (Integer id : ids) {
            int count = userRoleService.deleteByPrimaryKey(id);
            if (count <= 0) {
                throw new CustomException("删除失败，ID不存在(Deletion Failed. ID does not exist.)");
            }
        }
        return new ResponseBean(200, "删除成功(Delete Success)", null);
    }

    @PostMapping("/setUserRole/{id}")
    public ResponseBean add(@PathVariable String id, @RequestBody Map<String, String>  map) {
        UserRole ur = new UserRole();
        ur.setUserid(id);
        List<UserRole> urs = userRoleService.select(ur);
        List<String> roleids = new ArrayList<>();
        for (UserRole userRole : urs) {
            roleids.add(userRole.getRoleid());
        }
        List<String> inputList = new ArrayList<>();
        for (Map.Entry<String, String> entry : ((Map<String, String>)map).entrySet()) {
            inputList.add(entry.getValue());
            if(roleids.contains(entry.getValue())) {

            }
            else {
                ur.setRoleid(entry.getValue());
                userRoleService.insertSelective(ur);
            }
        }
        ur.setRoleid(null);
        urs = userRoleService.select(ur);
        roleids.clear();
        for (UserRole userRole : urs) {
            roleids.add(userRole.getRoleid());
        }
        roleids.removeAll(inputList);
        if (roleids.size() > 0) {
            for(String s : roleids) {
                ur.setRoleid(s);
                userRoleService.delete(ur);
            }
        }
        return new ResponseBean(200, "修改成功(Insert Success)",null);
    }

}
