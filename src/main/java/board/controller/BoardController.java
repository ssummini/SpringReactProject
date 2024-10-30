package board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import board.bean.BoardDTO;
import board.service.BoardService;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping(value="board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@PostMapping(value = "write")
	@ResponseBody
	public void write(@RequestParam String subject, @RequestParam String content) {

		boardService.write(subject, content);
	}
	
	@GetMapping(value = "list")
    public List<BoardDTO> list() { //List<BoardDTO> 객체를 자동으로 JSON 배열로 변환하여 보낸다.
        List<BoardDTO> list = boardService.getList();
        System.out.println(list);
        return list;
    }
	
	@GetMapping(value = "detail")
    public BoardDTO detail(@RequestParam int seq) { 
		System.out.println("seq = " + seq);
		BoardDTO boardDTO = boardService.getDetail(seq);
        return boardDTO;
    }
}
