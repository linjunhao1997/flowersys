package com.junhow.gp.controller;

import com.junhow.gp.pojo.Flower;
import com.junhow.gp.service.IFlowerService;
import com.junhow.gp.service.ITaxonomyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author linjunhao
 * @description
 * @createDate 2018/11/21 18:16
 */
@Controller
@RequestMapping(value = "/taxonomy")
public class TaxonomyController {
    @Autowired
    private ITaxonomyService taxonomyService;
    @Autowired
    private IFlowerService flowerService;

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public List<?> taxonomyEdit(@RequestBody Map<String,String> map) {
        return taxonomyService.getTaxonomyBySelected(map);
    }

    @RequestMapping(value = "/submmit/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String taxonomyEditSubmmit(@PathVariable int id, @RequestBody Flower flower) {
        flower.setId(id);
        flowerService.updateByPrimaryKeySelective(flower);
        return "success";
    }
    @RequestMapping(value = "/class")
    public String taxonomyClass(@RequestParam Integer id, Model m) {
        m.addAttribute("phylumid", id);
        m.addAttribute("id", id);
        return "pages/kind/class.html";
    }
    @RequestMapping(value = "/order")
    public String taxonomyOrder(@RequestParam Integer id, Model m) {
        m.addAttribute("classid", id);
        m.addAttribute("id", id);
        return "pages/kind/order.html";
    }
    @RequestMapping(value = "/family")
    public String taxonomyFamily(@RequestParam Integer id, Model m) {
        m.addAttribute("orderid", id);
        m.addAttribute("id", id);
        return "pages/kind/family.html";
    }
    @RequestMapping(value = "/genus")
    public String taxonomyGenus(@RequestParam Integer id, Model m) {
        m.addAttribute("familyid", id);
        m.addAttribute("id", id);
        return "pages/kind/genus.html";
    }
    @RequestMapping(value = "/species")
    public String taxonomySpecies(@RequestParam Integer id, Model m) {
        m.addAttribute("genusid", id);
        m.addAttribute("id", id);
        return "pages/kind/species.html";
    }
    @RequestMapping(value = "/subspecies")
    public String taxonomySubspecies(@RequestParam Integer id, Model m) {
        m.addAttribute("speciesid", id);
        m.addAttribute("id", id);
        return "pages/kind/subspecies.html";
    }
}
