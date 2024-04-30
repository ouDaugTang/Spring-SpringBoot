package com.aloha.spring.service;

import org.springframework.stereotype.Service;

@Service
public class BServiceImpl implements MyService{

	@Override
	public void test() {
		System.out.println("BServiceImpl...");
	}

}
