package com.groupware.board.controller;

import java.util.List;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.reffics.groupware.board.model.BoardVO;
import com.reffics.groupware.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2 //로깅을 도와주는 어노테이션
@RequiredArgsConstructor //초기화 되지 않은final 필드와 @NonNull 어노테이션이 붙은 필드에 대한 생성자를 생성함
public class BoardController { 

	
	private final BoardService boardservice; //final 을 선언해 의존성을 주입받음

	@GetMapping("/dashboard")
	public List<BoardVO> EmplyList(BoardVO bvo){
		List<BoardVO> emplyList = boardservice.selectEmply(bvo);
		log.info(emplyList);
		return emplyList;
	}
	
	@PostMapping("/insertboard")
	public String boardInsert(@RequestBody BoardVO bvo) {
		int result = 0;
		result = boardservice.insertEmply(bvo);
		if(result == 1) {
			return "success";
		} else {
			return "fail";
		}
	}

}

