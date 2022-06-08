package com.savantdegrees

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

@SpringBootApplication(
		exclude = [DataSourceAutoConfiguration]
)
class TestApplication {
	static void main(String[] args) {
		SpringApplication.run(TestApplication)
	}
}
