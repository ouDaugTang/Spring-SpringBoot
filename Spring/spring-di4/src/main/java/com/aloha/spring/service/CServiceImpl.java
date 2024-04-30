package com.aloha.spring.service;

import org.springframework.stereotype.Service;

// 빈 등록 어노테이션 ("빈이름")
// : * 빈 이름을 지정하지 않으면 클래스명을 기본으로 지정
//   * "빈이름" 을 지정하면 @Qualifier("지정한빈이름")
@Service("C")
public class CServiceImpl implements MyService{

	@Override
	public void test() {
		System.out.println("CServiceImpl...");
	}

}
