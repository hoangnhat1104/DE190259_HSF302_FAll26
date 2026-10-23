package com.hsf302.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class StudentThymeleafApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	void testDatabaseConnection() throws Exception {
		assertNotNull(dataSource, "DataSource bean không được null!");
		try (Connection connection = dataSource.getConnection()) {
			assertNotNull(connection, "Không lấy được Connection!");
			assertTrue(connection.isValid(2), "Kết nối không hợp lệ!");

			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("==================================================");
			System.out.println(" KẾT NỐI SQL SERVER THÀNH CÔNG!");
			System.out.println(" - Database: " + connection.getCatalog());
			System.out.println(" - Database Product: " + metaData.getDatabaseProductName() + " " + metaData.getDatabaseProductVersion());
			System.out.println(" - URL: " + metaData.getURL());
			System.out.println(" - User: " + metaData.getUserName());
			System.out.println("==================================================");
		}
	}

}

