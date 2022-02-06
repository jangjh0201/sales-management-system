package com.drtrue.domain.account;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.transaction.annotation.Transactional;;;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountTest {

	// @Autowired
	// private ObjectMapper objectMapper;

	// @Autowired
	// private MockMvc mockMvc;

	@Test
	@Transactional
	@WithMockUser(roles = "USER")
	public void indexTest() throws Exception {
		// mockMvc.perform(MockMvcRequestBuilders.get("/"))
		// .andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@Transactional
	@WithMockUser(roles = "ADMIN")
	public void test() throws Exception {
		// mockMvc.perform(MockMvcRequestBuilders.get("/account/test"))
		// .andExpect(MockMvcResultMatchers.status().isOk());
	}
}
