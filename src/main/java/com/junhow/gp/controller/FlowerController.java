package com.junhow.gp.controller;

import com.junhow.gp.common.ResponseBean;
import com.junhow.gp.exception.CustomException;
import com.junhow.gp.pojo.Flower;
import com.junhow.gp.service.IFlowerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FlowerController
 * @author CodeGenerator
 * @date 2019/03/16 18:13
 */
@RestController
@RequestMapping("/flower")
public class FlowerController {

    private final IFlowerService flowerService;

    @Autowired
    public FlowerController(IFlowerService flowerService) {
        this.flowerService = flowerService;
    }

    /**
     * 列表
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @GetMapping("/list")
    public Map<String, Object> list(@ModelAttribute Flower flower, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        if (page <= 0 || limit <= 0) {
            page = 1;
            limit = 10;
        }
        List<Flower> list = null;
        PageHelper.startPage(page, limit);
        if (flower == null) {
            list = flowerService.selectAll();
        } else {
            list = flowerService.select(flower);
        }

        if (list == null || list.size() <= 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        PageInfo<Flower> pageInfo = new PageInfo<Flower>(list);
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
        Flower flower = flowerService.selectByPrimaryKey(id);
        if (flower == null) {
            throw new CustomException("查询失败(Query Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", flower);
    }

    /**
     * 新增
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/add")
    public ResponseBean add(@RequestBody Flower flower) {
        int count = flowerService.insert(flower);
        if (count <= 0) {
            throw new CustomException("新增失败(Insert Failure)");
        }
        return new ResponseBean(200, "新增成功(Insert Success)", flower);
    }

    /**
     * 更新
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/update")
    public ResponseBean update(@RequestBody Flower flower) {
        int count = flowerService.updateByPrimaryKeySelective(flower);
        if (count <= 0) {
            throw new CustomException("更新失败(Update Failure)");
        }
        return new ResponseBean(200, "更新成功(Update Success)", flower);
    }

    /**
     * 删除
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @RequestMapping("/delete")
    public ResponseBean delete(@RequestBody List<Flower> ids) {
        for (Flower id : ids) {
            int count = flowerService.deleteByPrimaryKey(id);
            if (count <= 0) {
                throw new CustomException("删除失败，ID不存在(Deletion Failed. ID does not exist.)");
            }
        }
        return new ResponseBean(200, "删除成功(Delete Success)", null);
    }

    @RequestMapping(value="/imagemanage")
    public ModelAndView imagemanage(@RequestParam String name) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("imgList", this.flowerService.getFlowerAndImg(name));
        mv.setViewName("pages/flower/image.html");
        return mv;
    }

}
