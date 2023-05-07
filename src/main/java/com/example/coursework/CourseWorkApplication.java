package com.example.coursework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CourseWorkApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CourseWorkApplication.class, args);
    }


//    @Bean
//    CommandLineRunner runner()
//    {
//        return args ->
//        {
//            for (int i = 0; i < 100; i++)
//            {
//                Node node = new Node(random.nextInt(1000), random.nextInt(1000));
//                nodeRepository.save(node);
//            }
//
//            decisionMaker.startSimulatedAnnealing();
//        };
//    }

}
