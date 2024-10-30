package board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import board.service.BoardService;
import member.service.MemberService;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;

	@Autowired
	private HttpSession session;
	
	@Override
	public void write(String subject, String content) {
       String id = (String) session.getAttribute("memId");
       String name = (String) session.getAttribute("memName");
       String email = (String) session.getAttribute("memEmail");
		
		Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("email", email);
        map.put("subject", subject);
        map.put("content", content);
        
		boardDAO.write(map);
		boardDAO.refUpdate();
	}

	@Override
	public List<BoardDTO> getList() {
		List<BoardDTO> list = boardDAO.getList();
		System.out.println("list = " + list);
		return list;
	}

	@Override
	public BoardDTO getDetail(int seq) {
		BoardDTO boardDTO = boardDAO.getDetail(seq);
		System.out.println("boardDTO = " + boardDTO);
		return boardDTO;
	}

}
