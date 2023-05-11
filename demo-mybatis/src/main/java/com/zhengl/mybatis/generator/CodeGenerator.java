package com.zhengl.mybatis.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {

    public static void main(String[] args) {
        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder("jdbc:mysql://192.168.10.34:3306/test5", "root", "123456")
                .dbQuery(new MySqlQuery())
                .build();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .outputDir("D://")
                .author("hero良")
                .dateType(DateType.TIME_PACK)
                .commentDate("yyyy-MM-dd")
                .build();

        // 包配置(PackageConfig)
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("com.cloudree.monitor")
                .entity("entity")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("dao")
                .xml("mapper")
                .controller("controller")
                .build();

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .enableCapitalMode()
                .enableSkipView()
                .disableSqlFilter()
                .addInclude("t_monitor_energy_daily_paper")
                .addTablePrefix("t_monitor_")
                .build();

        // Entity 策略配置
        strategyConfig
                .entityBuilder()
                .superClass(Model.class)
                .disableSerialVersionUID()
                .enableChainModel()
                .enableLombok()
                .enableRemoveIsPrefix()
                .enableTableFieldAnnotation()
                .enableActiveRecord()
                .logicDeleteColumnName("status")
                .logicDeletePropertyName("status")
                .naming(NamingStrategy.underline_to_camel)
                .columnNaming(NamingStrategy.underline_to_camel)
                .idType(IdType.ASSIGN_UUID)
                .fileOverride()
                .build();


        // Controller 策略配置
        strategyConfig
                .controllerBuilder()
                .enableHyphenStyle()
                .enableRestStyle()
                .formatFileName("%sController")
                .build();

        // Service 策略配置
        strategyConfig
                .serviceBuilder()
                .superServiceClass(IService.class)
                .superServiceImplClass(ServiceImpl.class)
                .formatServiceFileName("I%sService")
                .formatServiceImplFileName("%sServiceImp")
                .build();

        // Mapper 策略配置
        strategyConfig
                .mapperBuilder()
                .superClass(BaseMapper.class)
                .enableMapperAnnotation()
                .enableBaseResultMap()
                .enableBaseColumnList()
                .formatMapperFileName("I%sMapper")
                .formatXmlFileName("%sMapper")
                .build();

        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig);
        autoGenerator.strategy(strategyConfig);
        autoGenerator.packageInfo(packageConfig);
        autoGenerator.global(globalConfig);
        autoGenerator.execute();
    }
}
