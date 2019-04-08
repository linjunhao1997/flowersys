package com.junhow.gp.controller;

import com.junhow.gp.common.ResponseBean;
import com.junhow.gp.exception.CustomException;
import com.junhow.gp.pojo.Image;
import com.junhow.gp.service.IImageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ImageController
 * @author CodeGenerator
 * @date 2019/03/16 18:13
 */
@RestController
@RequestMapping("/image")
public class ImageController {

    private final static String REALFILEPATH = "E:/upload/";
    private final static String VIRTUALFIILEPATH = "http://localhost:8080/upload/";
    private final IImageService imageService;

    @Autowired
    public ImageController(IImageService imageService) {
        this.imageService = imageService;
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
        List<Image> list = imageService.selectAll();
        if (list == null || list.size() <= 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        PageInfo<Image> pageInfo = new PageInfo<Image>(list);
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
        Image image = imageService.selectByPrimaryKey(id);
        if (image == null) {
            throw new CustomException("查询失败(Query Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", image);
    }

    /**
     * 新增
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/add")
    public ResponseBean add(@RequestBody Image image) {
        int count = imageService.insert(image);
        if (count <= 0) {
            throw new CustomException("新增失败(Insert Failure)");
        }
        return new ResponseBean(200, "新增成功(Insert Success)", image);
    }

    /**
     * 更新
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/update")
    public ResponseBean update(@RequestBody Image image) {
        int count = imageService.updateByPrimaryKeySelective(image);
        if (count <= 0) {
            throw new CustomException("更新失败(Update Failure)");
        }
        return new ResponseBean(200, "更新成功(Update Success)", image);
    }

    /**
     * 删除
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @RequestMapping("/delete")
    public ResponseBean delete(@RequestBody Integer id) {
        Image image = imageService.selectByPrimaryKey(id);
        if (image != null) {
            String src = image.getSrc();
            int begin = src.lastIndexOf("/");
            int end = src.length();
            String fileName = src.substring(begin, end);
            File file = new File(REALFILEPATH + fileName);
            file.delete();
        }
        int count = imageService.deleteByPrimaryKey(id);
        if (count <= 0) {
            throw new CustomException("删除失败，ID不存在(Deletion Failed. ID does not exist.)");
        }

        return new ResponseBean(200, "删除成功(Delete Success)", null);
    }

    @PostMapping("/upload/{id}")
    @ResponseBody
    public ResponseBean upload(@RequestParam("file") MultipartFile file, @PathVariable Integer id) {
        if (file.isEmpty()) {
            return null;
        }

        String fileName = file.getOriginalFilename();

        File dest = new File(REALFILEPATH + fileName);
        try {
            file.transferTo(dest);
            Image image = new Image();
            image.setSrc(VIRTUALFIILEPATH + fileName);
            image.setFlowerid(id);
            imageService.insert(image);
        } catch (IOException e) {
            return null;
        }
        return new ResponseBean(200, "上传成功",null);
    }
}
