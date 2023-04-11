package org.zerock.myapp.mapper;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.myapp.domain.MemberVO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= { "file:src/main/webapp/WEB-INF/spring/**/root-*.xml" })

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberMapperTests {

	// 의존성 주입
	@Inject
	private MemberMapper memberMapper;
	
	@BeforeAll
	void beforeAll() {	// 1회성 전처리
		
		log.trace("beforeAll() invoked.");
		
		assert this.memberMapper != null;
//		assertNotNull(this.userService);
		log.info("\t+ this.userService: {}", this.memberMapper);
		
	} // beforeAll()
	
	@Test
	void contextLoads() {
		log.trace("contextLoads() invoked.");
	
	} // contextLoads()
	
//	회원가입 테스트
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("memberJoin Test")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void memberJoin() throws Exception {
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMEMBER_ID("TEST_SENGNA");
		memberVO.setMEMBER_PW("TEST_SENGNA");
		memberVO.setMEMBER_NAME("TEST_SENGNA");
		memberVO.setMEMBER_MAIL("TEST_SENGNA");
		memberVO.setMEMBER_HP("1055555555");
		memberVO.setMEMBER_ADDR1("TEST_SENGNA");
		memberVO.setMEMBER_ADDR2("TEST_SENGNA");
		memberVO.setMEMBER_ZIPCODE(123456);
		
		memberMapper.memberJoin(memberVO);
	
		log.info("memberVO: {}", memberVO);

		
	} // memberJoin()
	
	
//	로그인 테스트
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("memberLogin Test")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void memberLogin() throws Exception {
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMEMBER_ID("TEST_SENGNA");
		memberVO.setMEMBER_PW("TEST_SENGNA");
				
		memberMapper.memberLogin(memberVO);
	
		log.info("Login 테스트 결과: {}", memberMapper.memberLogin(memberVO));
		
		
	} // memberLogin()

//	@Disabled
	@Test
	@Order(1)
	@DisplayName("memberSignup")
	@Timeout(value = 1, unit = TimeUnit.MINUTES)
	public void memberSignup() throws Exception{
		log.info("memberSignup() invoked.");
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMemberId("aaa");
		memberVO.setMemberPw("1234567890z");
		memberVO.setMemberName("차은우");
		memberVO.setMemberMail("eunwoochachacha@gmail.com");
		memberVO.setMemberHp("01035552020");
		memberVO.setMemberAddr1(12345);
		memberVO.setMemberAddr2("강남역 10번 출구");
		memberVO.setMemberAddr3("dd");
		memberVO.setGender("남자");
		memberVO.setADMINCK(1);
		memberVO.setBirthDate("1999-01-01");
//		memberVO.setJoinDate(1991-01-01);
		
		
		memberMapper.memberSignup(memberVO);
		
	} // memberSignup
	
} // end class
