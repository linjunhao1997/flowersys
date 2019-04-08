package com.junhow.gp.controller;

import com.junhow.gp.common.ResponseBean;
import com.junhow.gp.exception.CustomException;
import com.junhow.gp.pojo.Phylum;
import com.junhow.gp.service.IPhylumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PhylumController
 * @author CodeGenerator
 * @date 2019/03/16 18:13
 */
@RestController
@RequestMapping("/phylum")
public class PhylumController {

    private final IPhylumService phylumService;

    @Autowired
    public PhylumController(IPhylumService phylumService) {
        this.phylumService = phylumService;
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
        List<Phylum> list = phylumService.selectAll();
        if (list == null || list.size() <= 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        PageInfo<Phylum> pageInfo = new PageInfo<Phylum>(list);
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
        Phylum phylum = phylumService.selectByPrimaryKey(id);
        if (phylum == null) {
            throw new CustomException("查询失败(Query Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", phylum);
    }

    /**
     * 新增
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/add")
    public ResponseBean add(@RequestBody Phylum phylum) {
        int count = phylumService.insert(phylum);
        if (count <= 0) {
            throw new CustomException("新增失败(Insert Failure)");
        }
        return new ResponseBean(200, "新增成功(Insert Success)", phylum);
    }

    /**
     * 更新
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/update")
    public ResponseBean update(@RequestBody Phylum phylum) {
        int count = phylumService.updateByPrimaryKeySelective(phylum);
        if (count <= 0) {
            throw new CustomException("更新失败(Update Failure)");
        }
        return new ResponseBean(200, "更新成功(Update Success)", phylum);
    }

    /**
     * 删除
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @RequestMapping("/delete")
    public ResponseBean delete(@RequestBody List<Phylum> ids) {
        for (Phylum id : ids) {
            int count = phylumService.deleteByPrimaryKey(id);
            if (count <= 0) {
                throw new CustomException("删除失败，ID不存在(Deletion Failed. ID does not exist.)");
            }
        }
        return new ResponseBean(200, "删除成功(Delete Success)", null);
    }

}
