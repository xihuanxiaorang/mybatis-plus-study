package top.xiaorang.mybatisplusstudy;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class MybatisPlusStudyApplicationTests {
  private static final String URL =
      "jdbc:mysql://120.78.177.161:3306/mybatis-plus?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "123456";

  @Test
  void contextLoads() {}

  public static void main(String[] args) {
    String projectPath = System.getProperty("user.dir");
    FastAutoGenerator.create(new DataSourceConfig.Builder(URL, USERNAME, PASSWORD))
        .globalConfig(
            builder ->
                builder
                    .author("xiaorang")
                    .enableSwagger()
                    .commentDate("yyyy-MM-dd")
                    .fileOverride()
                    .disableOpenDir()
                    .dateType(DateType.ONLY_DATE)
                    .outputDir(projectPath + "/src/main/java"))
        .packageConfig(builder -> builder.parent("top.xiaorang.mybatisplusstudy"))
        .strategyConfig(
            (scanner, builder) ->
                builder
                    .addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                    .controllerBuilder()
                    .enableRestStyle()
                    .enableHyphenStyle()
                    .serviceBuilder()
                    .formatServiceFileName("%sService")
                    .mapperBuilder()
                    .enableMapperAnnotation()
                    .entityBuilder()
                    .enableLombok()
                    .versionColumnName("version")
                    .logicDeleteColumnName("deleted")
                    .idType(IdType.ASSIGN_ID)
                    .addTableFills(
                        new Column("create_time", FieldFill.INSERT),
                        new Column("update_time", FieldFill.INSERT_UPDATE))
                    .build())
        .templateEngine(new FreemarkerTemplateEngine())
        .execute();
  }

  // 处理 all 情况
  protected static List<String> getTables(String tables) {
    return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
  }
}
