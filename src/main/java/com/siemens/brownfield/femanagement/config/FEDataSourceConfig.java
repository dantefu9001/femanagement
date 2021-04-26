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
@MapperScan(basePackages = "com.siemens.brownfield.femanagement.dao.fe",
        sqlSessionTemplateRef ="feSqlSessionTemplate")
public class FEDataSourceConfig {

    private final FEDataBaseProperties feDataBaseProperties;

    public FEDataSourceConfig(FEDataBaseProperties feDataBaseProperties) {
        this.feDataBaseProperties = feDataBaseProperties;
    }

    @Bean("feDataSource")
    @Primary
    public DataSource getFEDataSource(){
        return DataSourceBuilder.create()
                .url(feDataBaseProperties.url)
                .driverClassName(feDataBaseProperties.driverClassName)
                .username(feDataBaseProperties.username)
                .password(feDataBaseProperties.password)
                .build();
    }

    @Bean("feSqlSessionFactory")
    @Primary
    public SqlSessionFactory FESqlSessionFactory(@Qualifier("feDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/fe/*.xml"));
        return bean.getObject();
    }

    @Bean("feTransactionManager")
    @Primary
    public DataSourceTransactionManager feTransactionManager(@Qualifier("feDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "feSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate firstSqlSessionTemplate(@Qualifier("feSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    private Class getType(String type) {
        try {
            return Class.forName(type);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
