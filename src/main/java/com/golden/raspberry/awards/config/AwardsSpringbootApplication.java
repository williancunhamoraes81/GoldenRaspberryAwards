package com.golden.raspberry.awards.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@Slf4j
@SpringBootApplication
public class AwardsSpringbootApplication {
    public static Logger LOG = LoggerFactory.getLogger(AwardsSpringbootApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(AwardsSpringbootApplication.class, args);


        if(LOG.isInfoEnabled()){
            LOG.info("\n\n"+
                    "mmmmmmmmmmmmmmmmmmmmmy+////ohs.                   \n" +
                    "mmmmmmmmmmmmmmmmmmmy:---.``..:so                  \n" +
                    "mmmmmmmmmmmmmmmmmmh./:/.`.-``..yo                 \n" +
                    "mmmmmmmmmmmmmmmmmm+-/::.`...`../m`                \n" +
                    "mmmmmmmmmmmmmmmmmmy/:-:-......-sm.                \n" +
                    "mmmmmmmmmmmmmmmmmmmo:::....---omm.                \n" +
                    "mmmmmmmmmmmmmmmmmmmdy+::-.--+ydmm/                \n" +
                    "mmmmmmmmmmmmmmmmmh+//--.....---/hd`               \n" +
                    "mmmmmmmmmmmmmmmms::---.---:-....:ds               \n" +
                    "mmmmmmmmmmmmmmms::------..::.-..-+m:              \n" +
                    "mmmmmmmmmmmmmms--.-:-::.--------:-sh`             \n" +
                    "mmmmmmmmmmmmmy-.-::::/:-.--.-:----:hy-            \n" +
                    "mmmmmmmmmmmmm/-:::+y://----../o:---/mds-          \n" +
                    "mmmmmmmmmmmmmo::+hdm/:/:-::/-+mds++smmmms:.`      \n" +
                    "mmmmmmmmmmmmmdddmmmm+:/::::/:+mmmmmmmmmmmmdhs/-`  \n" +
                    "mmmmmmmmmmmmmmmmmmmd/:/::::/-odddmmmmmmmmmmmmmdds+\n" +
                    "mmmmmmmmmmmmmmdddddh////::/+:odddddddmmmmmmmmmmmmm\n" +
                    "mmmmmmmmmmmmdddddddh/::::://+hdddddddddmmmmmmmmmmm\n" +
                    "mmmmmmmmmmddddddddddo:-/:://sddddddddddddmmmmmmmmm\n" +
                    "mmmmmmmmddddddddddddo::/:://yddddddddddddddmmmmmmm\n" +
                    "\n\n");
        }
    }
}
