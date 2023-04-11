package org.zerock.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.NoticeDTO;
import org.zerock.myapp.domain.NoticeVO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.NoticeService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@AllArgsConstructor

@RequestMapping("/admin/notice")
@Controller

// 아래 annotation의 배열({속성명1}, {속성명2}, {...})에 지정한
// 모델 속성들은 자동으로 세션에도 저장하게 해주는 annotation
@SessionAttributes({"notice", "noticeDTO"}) // String 타입의 배열을 인자로 받음!
// 모델로 들어가는 속성 중에, 해당 이름을 가진 속성을 session scope에도 넣겠다는 의미!
// session 속성을 건드리지 않고 /get 요청에서의 Notice를 인자로 받아서 session scope에 넣어줌!

public class NoticeController {

//	@Setter(onMethod_=@Autowired)
	// Spring Framework v4.3이후부터는, 아래와 같은 조건 시, 자동 주입:
	// (1) 주입받을 필드가 오직 1개이고,
	// (2) 이 필드를 매개변수로 가지는 생성자가 있다면! 자동 주입!
	private NoticeService service;
	
	@GetMapping("/list")
	public void list(Model model) throws ControllerException {	// 게시판 전체 목록 조회 요청 처리 핸들러
		
		log.trace("list({}) invoked.", model);
		
		// 주입 잘 됐는지 확인용
//		Objects.requireNonNull(this.service);
//		log.info("\t+ this.service: {}", this.service);
		
		try {
			//step1. 페이징처리된 현재 currPage에 해당하는 게시글목록 받아옴
			List<NoticeVO> list = this.service.getList();
			model.addAttribute("list", list); // view로 날아갈 model 상자 안에 model 데이터를 담음
		} catch (Exception e) {
			throw new ControllerException(e);
		} // try-catch
		
	} // list()
	
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("no") Integer no, Model model) throws ControllerException {
		// 매개변수 이름이 전송 파라미터와 어쩔수없이 달라야 한다면
		// 이 RequestParam으로 값을 달라고 할 전송 파라미터를 지정
		
		log.trace("get({}, {}) invoked.", no, model);
		
		try {
			NoticeVO vo = this.service.get(no);
			model.addAttribute("notice", vo);
		} catch (Exception e) {
			throw new ControllerException(e);
		} // try-catch
		
	} // get()
	
	
	@PostMapping("/remove")
	public String remove(Integer no, RedirectAttributes rttrs) 
			throws ControllerException {
		
		log.trace("remove({}, {}) invoked.", no, rttrs);
		
		try {
			boolean success = this.service.remove(no); 

			
			rttrs.addAttribute("result", (success)? "success" : "failure"); 
			//성공했던 실패했든 그대로 있으면 안되고 이동시켜야 하기 때문에 리다이렉션 무조건 
			return "redirect:/notice/list"; // redirect 때문에 string으로 선언한듯
		}catch(Exception e) {
			throw new ControllerException(e);
		} // try catch
	} // remove()
	
	
	@PostMapping("/modify")
	public String modify(NoticeDTO dto, RedirectAttributes rttrs) 
			throws ControllerException {
		
		log.trace("modify({}, {}) invoked.",dto, rttrs);
		
		try {
			boolean success = this.service.modify(dto);
			log.info("\t: success: {}", success);

			rttrs.addAttribute("result", (success)? "success" : "failure"); 
			// KEY = 수정처리결과
			
			return "redirect:/admin/notice/list"; // 실패했든 성공했든 여기로 이동
		} catch (Exception e) {
			throw new ControllerException(e);
		} // try-catch
		
	} // modify()
	
	
	@PostMapping("/register")
	public String register(NoticeDTO dto, RedirectAttributes rttrs) 
			throws ControllerException {
		
		log.trace("register({}, {}) invoked.", dto, rttrs);
		
		try {
			boolean success = this.service.register(dto);
			log.info("\t: success: {}", success);

			// 비지니스 요청 처리용 전송파라미터 전송처리
			rttrs.addAttribute("result", (success)? "success" : "failure"); 
			// KEY = 등록처리결과
			
			return "redirect:/admin/notice/list"; // 실패했든 성공했든 여기로 이동
		} catch (Exception e) {
			throw new ControllerException(e);
		} // try-catch
		
	} // register()
	
//	==============================================================================
//	HttpSession, HttpServletRequest, HttpServletResponse 객체가 정말
//	필요하면, DispatcherServlet에게 "달라!"라고 지정하면 "줍니다!"
//	(주의사항) 하지만, 이 객체를 직접 핸들링하는 것은, 스프링에 반하는 행위입니다!
//	-> 권장 X
//	==============================================================================
	@GetMapping("/temp")
	void temp(
			HttpSession session,
			HttpServletRequest req,
			HttpServletResponse res,
			@SessionAttribute("notice") NoticeVO vo
			) {
		
		log.trace("temp({}, {}, {}) invoked.", session, req, res);
		
	} // temp()
	
	
	@ModelAttribute("NoticeDTO")
	NoticeDTO createNoticeDTO() { // 이 메소드는 요청을 처리하는 핸들러 메소드가 아님!
		
		log.trace("createNoticeDTO() invoked.");
		
		NoticeDTO dto = new NoticeDTO();
		dto.setNo(1001);
		dto.setTitle("TEST");
		
		return dto;
		
	} // createNoticeDTO()
	
	@GetMapping("/register")
	public void register() {
		log.trace("register() invoked.");
	}
	
} // end class