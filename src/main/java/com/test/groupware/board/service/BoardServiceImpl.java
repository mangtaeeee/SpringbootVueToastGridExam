package com.reffics.groupware.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.reffics.groupware.board.mapper.BoardDAO;
import com.reffics.groupware.board.model.BoardVO;


@Service	
public class BoardServiceImpl implements BoardService {

	@Resource //Java 에서 지원하는 어노테이션이며 특정 프레임워크에 종속적이지 않다. spring 지원 예로는 @Autowried가 있다.
	private BoardDAO boardDao;
	
	@Override
	public List<BoardVO> selectEmply(BoardVO bvo) {
		List<BoardVO> list = boardDao.selectEmply(bvo);
		return list;
	}

	@Override
	public int insertEmply(BoardVO bvo) {
		int result = 0;
		result = boardDao.insertEmply(bvo);
		return result;
	}

}
