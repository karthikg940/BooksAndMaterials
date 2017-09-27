
package com.virtusa.test.base

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification


class WebAppIntegrationBaseSpecification extends Specification {
	MockMvc mockMvc

	@Autowired
	WebApplicationContext wac

	def setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build()
	}
}
