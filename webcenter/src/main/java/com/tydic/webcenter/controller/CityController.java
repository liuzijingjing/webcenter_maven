package com.tydic.webcenter.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.common.utils.SystemConstant;
import com.tydic.webcenter.service.demo.CityService;
import com.tydic.webcenter.service.model.CityDTO;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author liuzh
 * @since 2015-12-19 11:10
 */
@RestController
@RequestMapping("/cities")
public class CityController {

    @Reference(version = SystemConstant.SERVICE_DUBBO_VERSION)
    private CityService cityService;

    @RequestMapping
    public PageInfo<CityDTO> getAll(CityDTO city) {
        Response<List<CityDTO>> response = cityService.getAllCity(city);
        return new PageInfo<CityDTO>(response.getResult());
    }

    @RequestMapping(value = "/add")
    public CityDTO add() {
        return new CityDTO();
    }

    @RequestMapping(value = "/view/{id}")
    public CityDTO view(@PathVariable Integer id) {
        ModelAndView result = new ModelAndView();
        Response<CityDTO> response = cityService.getById(Long.valueOf(id.toString()));
        return response.getResult();
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelMap delete(@PathVariable Integer id) {
        ModelMap result = new ModelMap();
        if(cityService.deleteById(Long.valueOf(id.toString())).getResult()){
            result.put("msg", "删除成功!");
        }else {
            result.put("msg", "删除失败!");
        }

        return result;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelMap save(CityDTO city) {
        ModelMap result = new ModelMap();
        String msg = null;
        if(cityService.save(city).getResult()){
            msg = city.getId() == null ? "新增成功!" : "更新成功!";
        } else {
            msg = city.getId() == null ? "新增失败!" : "更新失败!";
        }
        result.put("city", city);
        result.put("msg", msg);
        return result;
    }
}
