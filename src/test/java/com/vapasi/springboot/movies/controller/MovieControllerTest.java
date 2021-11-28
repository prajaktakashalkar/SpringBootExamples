package com.vapasi.springboot.movies.controller;


import com.vapasi.springboot.movies.dto.Movie;
import com.vapasi.springboot.movies.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    public void shouldReturnOKForMoviesReturned() throws Exception{
        mockMvc.perform(get("/api/v1/movies/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(movieService,times(1)).getMovieList();
    }

    @Test
    void shouldReturnAsAcceptedResponseOnUpdatingOfMovie() throws Exception {
        when(movieService.updateMovie(any())).thenReturn(new Movie(1,"pirates of caribbean", "Johny Depp", "Gore Verbinsky"));
        mockMvc.perform(put("/api/v1/movies/")
                        .content("{\"id\": 1, \n" +
                                "    \"name\": \"pirates of caribbean\", \n" +
                                "    \"actor\": \"Johny Depp\", \n" +
                                "    \"director\": \"Gore Verbinsky\"\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andExpect(content().json("{\"id\":1,\"name\":\"pirates of caribbean\",\"actor\":\"Johny Depp\",\"director\":\"Gore Verbinsky\"}"));

    }


}
