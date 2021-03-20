package com.example.cloudmobilityprivatehospital;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "test-properties")
@Data
public class TestProperties {

	private String user;
	private String password;
}
