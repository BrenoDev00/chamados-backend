package com.projects.chamados.config;

import com.projects.chamados.enums.TechnicianShift;
import com.projects.chamados.models.Technician;
import com.projects.chamados.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private TechnicianRepository technicianRepository;

    @Override
    public void run(String... args){
        // instâncias de técnicos
        var John = new Technician(null, "John Lorem Ipsum", "john@mail.com", TechnicianShift.DAYTIME, "123password.");
        var Marie = new Technician(null, "Marie Lorem Ipsum", "marie@mail.com", TechnicianShift.NIGHTTIME, "123password.");
        var Andrew = new Technician(null, "Andrew Lorem Ipsum", "andrew@mail.com", TechnicianShift.DAYTIME, "123password.");
        var Paul = new Technician(null, "Paul Lorem Ipsum", "paul@mail.com", TechnicianShift.NIGHTTIME, "123password.");


        // salvamento de entidades
        this.technicianRepository.saveAll(Arrays.asList(John, Marie, Andrew, Paul));
    }
}
