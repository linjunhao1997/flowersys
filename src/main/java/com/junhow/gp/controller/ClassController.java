package com.junhow.gp.controller;

import com.junhow.gp.common.ResponseBean;
import com.junhow.gp.exception.CustomException;
import com.junhow.gp.pojo.Class;
import com.junhow.gp.service.IClassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassController
 * @author CodeGenerator
 * @date 2019/03/16 16:24
 */
@RestController
@RequestMapping("/class")
public class ClassController {

    private final IClassService classService;

    @Autowired
    public ClassController(IClassService classService) {
        this.classService = classService;
    }

    /**
     * 列表
     * @author CodeGenerator
     * @date 2019/03/16 16:24
     */
    @RequestMapping("/list/{id}")
    public Map<String, Object> list(@PathVariable Integer id, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {
        if (page <= 0 || rows <= 0) {
            page = 1;
            rows = 10;
        }
        PageHelper.startPage(page, rows);
        Class aClass = new Class();
        aClass.setPhylumid(id);
        List<Class> list = classService.select(aClass);
        if (list == null || list.size() <= 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        PageInfo<Class> pageInfo = new PageInfo<Class>(list);
        Map<String, Object> result = new HashMap<String, Object>(16);
        result.put("code", "0");
        result.put("count", pageInfo.getTotal());
        result.put("data", pageInfo.getList());
        return result;
    }

    /**
     * 查询
     * @author CodeGenerator
     * @date 2019/03/16 16:24
     */
    @PostMapping("/detail")
    public ResponseBean detail(@RequestParam Integer id) {
        Class aClass = classService.selectByPrimaryKey(id);
        if (aClass == null) {
            throw new CustomException("查询失败(Query Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", aClass);
    }

    /**
     * 新增
     * @author CodeGenerator
     * @date 2019/03/16 16:24
     */
    @PostMapping("/add")
    public ResponseBean add(@RequestBody Class aClass) {
        int count = classService.insert(aClass);
        if (count <= 0) {
            throw new CustomException("新增失败(Insert Failure)");
        }
        return new ResponseBean(200, "新增成功(Insert Success)", aClass);
    }

    /**
     * 更新
     * @author CodeGenerator
     * @date 2019/03/16 16:24
     */
    @PostMapping("/update")
    public ResponseBean update(@RequestBody Class aClass) {
        int count = classService.updateByPrimaryKeySelective(aClass);
        if (count <= 0) {
            throw new CustomException("更新失败(Update Failure)");
        }
        return new ResponseBean(200, "更新成功(Update Success)", aClass);
    }

    /**
     * 删除
     * @author CodeGenerator
     * @date 2019/03/16 16:24
     */
    @RequestMapping("/delete")
    public ResponseBean delete(@RequestBody List<Class> ids) {
        for (Class id : ids) {
            int count = classService.deleteByPrimaryKey(id);
            if (count <= 0) {
                throw new CustomException("删除失败，ID不存在(Deletion Failed. ID does not exist.)");
            }
        }
        return new ResponseBean(200, "删除成功(Delete Success)", null);
    }

}
