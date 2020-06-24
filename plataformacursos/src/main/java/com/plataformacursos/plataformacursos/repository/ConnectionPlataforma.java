package com.plataformacursos.plataformacursos.repository;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class ConnectionPlataforma {
	
	@Bean
	public DataSource connect() {
		DriverManagerDataSource connection = new DriverManagerDataSource();
		connection.setDriverClassName("com.mysql.jdbc.Driver");
		connection.setUrl("jdbc:mysql://localhost:3306/plataformacursos");
		connection.setUsername("root");
		connection.setPassword("");
		return connection;
	}
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		adapter.setPrepareConnection(true);
		return adapter;
	}
}
