package org.zerock.myapp.mapper;

import java.util.Objects;
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

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/**/root-context.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IdCheckMapperTests {

	@Setter(onMethod_ = @Autowired)
	private IdCheckMapper mapper;

	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked");

		Objects.requireNonNull(this.mapper);

		log.trace("this.mapper{}, type {}", this.mapper, this.mapper.getClass().getName());

	} // beforeAll

//	@Disabled
	@Test
	@DisplayName("testIdCheck")
	@Order(1)
	@Timeout(value = 1, unit = TimeUnit.MINUTES)
	public void testIdCheck() {
		log.trace("testIdCheck () invoked.");


	} // testIdCheck

} // end class
