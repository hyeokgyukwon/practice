package org.zerock.myapp.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.myapp.domain.NoticeDTO;
import org.zerock.myapp.domain.NoticeVO;
import org.zerock.myapp.exception.ServiceException;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/**/root-*.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NoticeServiceTests {
	
	@Setter(onMethod_=@Autowired)
	private NoticeService service;
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked.");
	} // beforeAll
	
//	@Disable
	@Test
	@Order(1)
	@DisplayName("테스트 1 : getList")
	@Timeout(value=2, unit=TimeUnit.SECONDS)
	void testGetList() throws ServiceException {
		log.trace("testGetList() invoked.");
	
		List<NoticeVO> list = this.service.getList();
		
		assert list != null;
		list.forEach(log::info);
		
	} // testGetList()
	
	
//	@Disable
	@Test
	@Order(2)
	@DisplayName("테스트 2 : get")
	@Timeout(value=2, unit=TimeUnit.SECONDS)
	void testGet() throws ServiceException {
		log.trace("testGet() invoked.");
	
		int no = 6;
		NoticeVO vo = this.service.get(no);
		
		assert vo != null;
		log.info("\t+ vo : {}", vo);
		
	} // testGet()
	
	
//	@Disable
	@Test
	@Order(3)
	@DisplayName("테스트 3 : register")
	@Timeout(value=2, unit=TimeUnit.SECONDS)
	void testRegister() throws ServiceException {
		log.trace("testRegister() invoked.");

		NoticeDTO dto = new NoticeDTO();
		dto.setTitle("<공지> 6월 둘째주 장원 이벤트 당첨자 발표!");
		dto.setContent("<공지> 6월 둘째주 장원 이벤트 당첨자 발표!");
		dto.setWriter("admin");
		
		boolean success = this.service.register(dto);
		
		log.info("\t+ success : {}", success);
		
	} // testRegister()
	
	
	
//	@Disable
	@Test
	@Order(4)
	@DisplayName("테스트 4 : remove")
	@Timeout(value=2, unit=TimeUnit.SECONDS)
	void testRemove() throws ServiceException {
		log.trace("testRemove() invoked.");

		int no = 30;
		boolean success = this.service.remove(no);
		
		log.info("\t+ success : {}", success);
		
	} // testRemove()
	
	
	
//	@Disable
	@Test
	@Order(5)
	@DisplayName("테스트 5 : modify")
	@Timeout(value=10, unit=TimeUnit.MINUTES)
	void testModify() throws ServiceException {
		log.trace("testModify() invoked.");
		
		NoticeVO vo32 = this.service.get(32);
		
		NoticeDTO dto = new NoticeDTO();
		dto.setNo(32);
		dto.setTitle("'업데이트 테스트q'");
		dto.setContent("'업데이트 테스트q'");
		dto.setWriter("admin");
		boolean success = this.service.modify(dto);
		
		log.info("\t+ success : {}", success);
		
	} // testModify()
	
	
	
} // end class
