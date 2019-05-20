package com.junhow.gp.controller;

import com.junhow.gp.pojo.Flower;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 通用访问匹配页面跳转
 * @author linjunhao
 * @date 2019/1/24 19:27
 */
@Controller
public class IndexController {

    /**
     * 通用页面跳转
     * @param url
     * @return java.lang.String
     * @author linjunhao
     * @date 2019/1/24 19:27
     */
    @RequestMapping("{url}.shtml")
    public String page(@PathVariable("url") String url) {
        return url;
    }

    /**
     * 通用页面跳转(二级目录)
     * @param module
     * @param url
     * @return java.lang.String
     * @author linjunhao
     * @date 2019/1/24 19:27
     */
    @RequestMapping("{module}/{url}.shtml")
    public String page(@PathVariable("module") String module, @PathVariable("url") String url) {
        return module + "/" + url;
    }

    /**
     * 通用页面跳转(三级目录)
     * @param module
     * @param url
     * @return java.lang.String
     * @author linjunhao
     * @date 2019/1/25 19:35
     */
    @RequestMapping("{module}/{module2}/{url}.shtml")
    public String page(@PathVariable("module") String module, @PathVariable("module2") String module2,
                       @PathVariable("url") String url) {
        return module + "/" + module2 + "/" + url;
    }

    @RequestMapping(value="flower/edit")
    public ModelAndView taxonomyUpdate(ModelAndView mv, @RequestParam String phylumname,
                                       @RequestParam String classname, @RequestParam String ordername, @RequestParam String familyname,
                                       @RequestParam String genusname,
                                       @RequestParam String speciesname, @RequestParam String subspeciesname,
                                       @RequestParam int id){
        Flower flower = new Flower();
        flower.setId(id);
        flower.setPhylumname(phylumname != null ? phylumname : "");
        flower.setClassname(classname != null ? classname : "");
        flower.setOrdername(ordername != null ? ordername : "");
        flower.setFamilyname(familyname != null ? familyname : "");
        flower.setGenusname(genusname != null ? genusname : "");
        flower.setSpeciesname(speciesname != null ? speciesname : "");
        flower.setSubspeciesname(subspeciesname != null ? subspeciesname : "");
        mv.addObject("flower", flower);
        // 注意路径问题
        mv.setViewName("pages/flower/edit.html");
        return mv;
    }
    @RequestMapping("index")
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("pages/front/index.html");
        return mv;
    }
    @RequestMapping("index/proposal")
    public ModelAndView proposal(ModelAndView mv) {
        mv.setViewName("pages/front/proposal.html");
        return mv;
    }

}