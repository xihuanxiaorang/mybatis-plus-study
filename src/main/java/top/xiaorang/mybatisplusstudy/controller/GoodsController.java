package top.xiaorang.mybatisplusstudy.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.xiaorang.mybatisplusstudy.entity.Goods;
import top.xiaorang.mybatisplusstudy.service.GoodsService;

import java.math.BigDecimal;

/**
 * <p>
 *  前端控制器
 * </p>
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
            Goods.builder().name("手机").code("0001").price(new BigDecimal("12.05")).build());
    return "success";
  }
}
