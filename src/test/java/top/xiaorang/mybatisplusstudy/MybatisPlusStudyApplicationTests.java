package top.xiaorang.mybatisplusstudy;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusStudyApplicationTests {
  private static final String URL =
      "jdbc:mysql://120.78.177.161:3306/mybatis-plus?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "123456";

  @Test
  void contextLoads() {
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
                    .outputDir(projectPath + "/src/main/java"))
        .packageConfig(builder -> builder.parent("top.xiaorang.mybatisplusstudy"))
        .strategyConfig(
            builder ->
                builder
                    .addInclude("goods")
                    .controllerBuilder()
                    .enableRestStyle()
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
                        new Column("update_time", FieldFill.INSERT_UPDATE)))
        .templateEngine(new FreemarkerTemplateEngine())
        .execute();
  }
}
