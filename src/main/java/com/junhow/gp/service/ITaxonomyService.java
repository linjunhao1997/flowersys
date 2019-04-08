package com.junhow.gp.service;


import com.junhow.gp.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author linjunhao
 * @description
 * @createDate 2019/3/5 12:57
 */
@Service
public class ITaxonomyService {
    @Autowired
    private PhylumMapper phylumDao;
    @Autowired
    private ClassMapper classDao;
    @Autowired
    private OrderMapper orderDao;
    @Autowired
    private FamilyMapper familyDao;
    @Autowired
    private GenusMapper genusDao;
    @Autowired
    private SpeciesMapper speciesDao;
    @Autowired
    private SubspeciesMapper subspeciesDao;
    public List<?> getTaxonomyBySelected(Map<String,String> map){
        if (map.get("name")!= null) {
            return phylumDao.selectAll();
        }
        if (map.get("phylumname")!= null ) {
            return classDao.selectByTypeName(map.get("phylumname"));
        }
        if (map.get("classname")!= null ) {
            return orderDao.selectByTypeName(map.get("classname"));
        }
        if (map.get("ordername")!= null ) {
            return familyDao.selectByTypeName(map.get("ordername"));
        }
        if (map.get("familyname")!= null ) {
            return genusDao.selectByTypeName(map.get("familyname"));
        }
        if (map.get("genusname")!= null ) {
            return speciesDao.selectByTypeName(map.get("genusname"));
        }
        if (map.get("speciesname")!= null ) {
            return subspeciesDao.selectByTypeName(map.get("speciesname"));
        }
        return null;

    }
}
