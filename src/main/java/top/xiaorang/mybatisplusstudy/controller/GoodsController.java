package top.xiaorang.mybatisplusstudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
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

  @GetMapping
  public String save() {
    goodsService.save(
        Goods.builder().name("指甲钳").price(new BigDecimal("3.5")).code("0002").build());
    return "success";
  }
}
