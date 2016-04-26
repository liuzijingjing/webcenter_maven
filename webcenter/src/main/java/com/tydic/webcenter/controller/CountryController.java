package com.tydic.webcenter.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.common.utils.SystemConstant;
import com.tydic.webcenter.service.demo.CountryService;
import com.tydic.webcenter.service.model.CountryDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author liuzh
 * @since 2015-12-19 11:10
 */
@Controller
@RequestMapping("/countries")
public class CountryController {

    @Reference(version = SystemConstant.SERVICE_DUBBO_VERSION)
    private CountryService countryService;

    @RequestMapping
    public ModelAndView getAll(CountryDTO country) {
        ModelAndView result = new ModelAndView("index");
        Response<List<CountryDTO>> response = countryService.getAll(country);
        result.addObject("pageInfo", new PageInfo<CountryDTO>(response.getResult()));
        result.addObject("queryParam", country);
        result.addObject("page", country.getPage());
        result.addObject("rows", country.getRows());
        return result;
    }

    @RequestMapping(value = "/add")
    public ModelAndView add() {
        ModelAndView result = new ModelAndView("view");
        result.addObject("country", new CountryDTO());
        return result;
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable Integer id) {
        ModelAndView result = new ModelAndView("view");
        Response<CountryDTO> country = countryService.getById(Long.valueOf(id.toString()));
        result.addObject("country", country);
        return result;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable Integer id, RedirectAttributes ra) {
        ModelAndView result = new ModelAndView("redirect:/countries");
        countryService.deleteById(Long.valueOf(id.toString()));
        ra.addFlashAttribute("msg", "删除成功!");
        return result;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(CountryDTO country) {
        ModelAndView result = new ModelAndView("view");
        String msg = country.getId() == null ? "新增成功!" : "更新成功!";
        countryService.save(country);
        result.addObject("country", country);
        result.addObject("msg", msg);
        return result;
    }
}
