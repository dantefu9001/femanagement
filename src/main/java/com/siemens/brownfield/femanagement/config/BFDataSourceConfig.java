package com.siemens.brownfield.femanagement.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.siemens.brownfield.femanagement.dao.bf",
        sqlSessionTemplateRef= "bfSqlSessionTemplate")
public class BFDataSourceConfig {

    private final BFDataBaseProperties bfDataBaseProperties;

    public BFDataSourceConfig(BFDataBaseProperties bfDataBaseProperties) {
        this.bfDataBaseProperties = bfDataBaseProperties;
    }

    @Bean("bfDataSource")
    public DataSource getBFDataSource(){
        return DataSourceBuilder.create()
                .url(bfDataBaseProperties.url)
                .driverClassName(bfDataBaseProperties.driverClassName)
                .username(bfDataBaseProperties.username)
                .password(bfDataBaseProperties.password)
                .build();
    }

    @Bean("bfSqlSessionFactory")
    public SqlSessionFactory BFSqlSessionFactory(@Qualifier("bfDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/bf/*.xml"));
        return bean.getObject();
    }

    @Bean("bfTransactionManager")
    public DataSourceTransactionManager bfTransactionManager(@Qualifier("bfDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "bfSqlSessionTemplate")
    public SqlSessionTemplate bfSqlSessionTemplate(@Qualifier("bfSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
