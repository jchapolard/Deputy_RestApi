package com.PNM3.Deputy_RESTApi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.PNM3.Deputy_RESTApi.model.Deputy;
import com.PNM3.Deputy_RESTApi.repository.DeputyRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;

@SpringBootTest
@AutoConfigureMockMvc
class DeputyRestApiApplicationTests {

	 @Autowired
	 private MockMvc mockMvc;
	 
	 @Autowired
	private DeputyRepository deputyRepository;
	 
	@Test
    public void testGetDeputies1() throws Exception {
        this.mockMvc.perform(
        	get("/deputies"))
            .andExpect(status().isOk());
    }
	
	@Test
    public void testGetDeputies2() throws Exception {
        this.mockMvc.perform(
        	get("/deputies/{id}", 1L))
        	//.accept(MediaType.APPLICATION_JSON))
	        //.andDo(print())
            .andExpect(status().isOk());
           // .andExpect(MockMvcResultMatchers.jsonPath("$.intPoliticalParty").value(1));
    }
	
	@Test
	public void getAllEmployeesAPI() throws Exception 
	{
		this.mockMvc.perform(MockMvcRequestBuilders
	  			.get("/deputies")
	  			.accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.deputies").exists())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.deputies[*].id").isNotEmpty());
	}
	
	@Test
	public void deleteDeputyAPI() throws Exception 
	{
		 //this.mockMvc.perform( MockMvcRequestBuilders.delete("/deputies/{id}", 1) )
	       // .andExpect(status().isAccepted());
		 this.mockMvc.perform(
				 delete("/deputies/id=1"))
		            .andExpect(status().isOk());
	}
	
	 @Test
	 public void findOne() throws Exception {
        mockMvc.perform(get("/deputies/1"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
	 }
	 
	 @Test
	 void findAll_success() {
		 Iterable<Deputy> allDeputies = deputyRepository.findAll();
		 List<Deputy> result = new ArrayList<>();
		 allDeputies.forEach(result::add);
	     assertThat(result.size()).isGreaterThanOrEqualTo(1);
	 }

}
