package top.xiaorang.mybatisplusstudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import top.xiaorang.mybatisplusstudy.entity.Goods;
import top.xiaorang.mybatisplusstudy.service.GoodsService;

import java.math.BigDecimal;

/**
 * 前端控制器
 *
 * @author xiaorang
 * @since 2021-12-20
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
  private final GoodsService goodsService;

  public GoodsController(GoodsService goodsService) {
    this.goodsService = goodsService;
  }

  @PostMapping()
  public String save(@RequestBody Goods goods) {
    goodsService.save(goods);
    return "success";
  }
}
