package com.golden.raspberry.awards.config;

import com.golden.raspberry.awards.config.service.MovieService;
import com.golden.raspberry.awards.config.service.ProducerService;
import com.golden.raspberry.awards.config.service.StudioService;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@AutoConfigureMockMvc
public class AwardsSpringbootApplicationIT {

    @MockBean
	protected ProducerService producerService;

    @MockBean
    protected StudioService studioService;

    @MockBean
    protected MovieService movieService;

}
