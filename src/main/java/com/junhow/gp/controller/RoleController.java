package com.junhow.gp.controller;

import com.junhow.gp.common.ResponseBean;
import com.junhow.gp.dao.RoleMapper;
import com.junhow.gp.exception.CustomException;
import com.junhow.gp.pojo.Role;
import com.junhow.gp.service.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RoleController
 * @author CodeGenerator
 * @date 2019/03/16 18:13
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    private final IRoleService roleService;


    @Autowired
    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }
    @Autowired
    public RoleMapper roleDao;

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
        List<Role> list = roleService.selectAll();
        if (list == null || list.size() <= 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        PageInfo<Role> pageInfo = new PageInfo<Role>(list);
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
        Role role = roleService.selectByPrimaryKey(id);
        if (role == null) {
            throw new CustomException("查询失败(Query Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", role);
    }

    /**
     * 新增
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/add")
    public ResponseBean add(@RequestBody Role role) {
        int count = roleService.insert(role);
        if (count <= 0) {
            throw new CustomException("新增失败(Insert Failure)");
        }
        return new ResponseBean(200, "新增成功(Insert Success)", role);
    }

    /**
     * 更新
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/update")
    public ResponseBean update(@RequestBody Role role) {
        int count = roleService.updateByPrimaryKeySelective(role);
        if (count <= 0) {
            throw new CustomException("更新失败(Update Failure)");
        }
        return new ResponseBean(200, "更新成功(Update Success)", role);
    }

    /**
     * 删除
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/delete")
    public ResponseBean delete(@RequestBody List<Role> roles) {
        for (Role role : roles) {
            int count = roleService.deleteByPrimaryKey(role.getId());
            if (count <= 0) {
                throw new CustomException("删除失败，ID不存在(Deletion Failed. ID does not exist.)");
            }
        }
        return new ResponseBean(200, "删除成功(Delete Success)", null);
    }
    @PostMapping("/getAllRole")
    public ResponseBean getAllRole() {
        List<Role> roles = roleService.selectAll();
        return new ResponseBean(200, null, roles);
    }

    @RequestMapping("/getRolesByUserId/{id}")
    public ResponseBean getRolesByUserId(@PathVariable("id") Integer id) {
        List<Role> roles = roleDao.getRolesByUserId(id);
        return new ResponseBean(200, null, roles);
    }

}
