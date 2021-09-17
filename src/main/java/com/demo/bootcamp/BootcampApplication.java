package com.demo.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Örnek senaryo 1:spring initializer ile projeyi create ettik sonra enableautoconfiguration olmadan projeyi
//çalıstırıp hata alındığını görmek
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
//@EnableJpaRepositories(basePackageClasses = {TestRepository.class})
@SpringBootApplication
public class BootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampApplication.class, args);
	}

}
