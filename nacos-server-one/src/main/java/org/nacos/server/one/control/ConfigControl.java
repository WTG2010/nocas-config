package org.nacos.server.one.control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigControl {
	
	@Value(value = "${common}")
	private String common;
	
	@GetMapping("common")
	public String getCommon() {
		return common;
	}

}
