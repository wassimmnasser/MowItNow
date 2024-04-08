package com.mowitnow.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mowitnow.service.LawnMowerService;

/**
 * author : Wassim MNASSER
 */
@RestController
public class LawnMowerController {

	@Autowired
	private LawnMowerService lawnMowerService;

	@PostMapping("/mow")
	public List<String> mowLawnFromFile(@RequestBody String filePath) throws IOException {
		return lawnMowerService.mowLawnFromFile(filePath);
	}

}
