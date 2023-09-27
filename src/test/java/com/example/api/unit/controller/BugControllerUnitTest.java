package com.example.api.unit.controller;

import com.example.api.controller.BugController;
import com.example.api.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BugController.class)
class BugControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BugService mockJobService;

//    @WithMockUser(value = "spring")
//    @Test
//    @DisplayName("GET /v1/jobs - Return all available Jobs")
//    void when_find_jobs_should_return_available_jobs() throws Exception {
//
//        given(mockJobService.findAll()).willReturn(buildJobs());
//
//        mockMvc
//                .perform(
//                        get("/v1/jobs")
//                                .contentType(APPLICATION_JSON)
//                                .accept(APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$.[0].id", is(1)));
//    }

//    @WithMockUser(value = "spring")
//    @Test
//    @DisplayName("GET /v1/jobs - No Jobs found (204)")
//    void when_find_no_jobs_should_return_204() throws Exception {
//
//        given(mockJobService.findAll()).willReturn(new ArrayList<>());
//
//        mockMvc
//                .perform(
//                        get("/v1/jobs")
//                                .contentType(APPLICATION_JSON)
//                                .accept(APPLICATION_JSON))
//                .andExpect(status().isNoContent());
//    }

//    private List<JobDTO> buildJobs() {
//        return List.of(JobDTO.builder().id(1L).name("Front Desk").description("This is a Front Desk job").build());
//    }

}
