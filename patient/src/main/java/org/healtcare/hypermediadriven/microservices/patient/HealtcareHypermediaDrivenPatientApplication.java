package org.healtcare.hypermediadriven.microservices.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author ldicesare
 * @email ing.dicesare@gmail.com
 *
 */
@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = { "org.healtcare.hypermediadriven" })
public class HealtcareHypermediaDrivenPatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealtcareHypermediaDrivenPatientApplication.class, args);
	}

}
