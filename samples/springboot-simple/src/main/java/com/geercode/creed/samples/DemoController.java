package com.geercode.creed.samples;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jerryniu
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
