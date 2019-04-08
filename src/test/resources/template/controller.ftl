package ${basePackage}.controller;

import ${basePackage}.common.ResponseBean;
import ${basePackage}.exception.CustomException;
import ${basePackage}.pojo.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ${modelNameUpperCamel}Controller
 * @author ${author}
 * @date ${date}
 */
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {

    private final I${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @Autowired
    public ${modelNameUpperCamel}Controller(I${modelNameUpperCamel}Service ${modelNameLowerCamel}Service) {
        this.${modelNameLowerCamel}Service = ${modelNameLowerCamel}Service;
    }

    /**
     * 列表
     * @author ${author}
     * @date ${date}
     */
    @GetMapping("/list")
    public Map<String, Object> list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        if (page <= 0 || limit <= 0) {
            page = 1;
            limit = 10;
        }
        PageHelper.startPage(page, limit);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.selectAll();
        if (list == null || list.size() <= 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        PageInfo<${modelNameUpperCamel}> pageInfo = new PageInfo<${modelNameUpperCamel}>(list);
        Map<String, Object> result = new HashMap<String, Object>(16);
        result.put("code", 0);
        result.put("count", pageInfo.getTotal());
        result.put("data", pageInfo.getList());
        return result;
    }

    /**
     * 查询
     * @author ${author}
     * @date ${date}
     */
    @PostMapping("/detail")
    public ResponseBean detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.selectByPrimaryKey(id);
        if (${modelNameLowerCamel} == null) {
            throw new CustomException("查询失败(Query Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", ${modelNameLowerCamel});
    }

    /**
     * 新增
     * @author ${author}
     * @date ${date}
     */
    @PostMapping("/add")
    public ResponseBean add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        int count = ${modelNameLowerCamel}Service.insert(${modelNameLowerCamel});
        if (count <= 0) {
            throw new CustomException("新增失败(Insert Failure)");
        }
        return new ResponseBean(200, "新增成功(Insert Success)", ${modelNameLowerCamel});
    }

    /**
     * 更新
     * @author ${author}
     * @date ${date}
     */
    @PostMapping("/update")
    public ResponseBean update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        int count = ${modelNameLowerCamel}Service.updateByPrimaryKeySelective(${modelNameLowerCamel});
        if (count <= 0) {
            throw new CustomException("更新失败(Update Failure)");
        }
        return new ResponseBean(200, "更新成功(Update Success)", ${modelNameLowerCamel});
    }

    /**
     * 删除
     * @author ${author}
     * @date ${date}
     */
    @PostMapping("/delete")
    public ResponseBean delete(@RequestParam List<Integer> ids) {
        for (Integer id : ids) {
            int count = ${modelNameLowerCamel}Service.deleteByPrimaryKey(id);
            if (count <= 0) {
                throw new CustomException("删除失败，ID不存在(Deletion Failed. ID does not exist.)");
            }
        }
        return new ResponseBean(200, "删除成功(Delete Success)", null);
    }

}