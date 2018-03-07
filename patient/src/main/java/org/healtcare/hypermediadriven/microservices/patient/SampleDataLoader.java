package org.healtcare.hypermediadriven.microservices.patient;

import org.healtcare.hypermediadriven.microservices.patient.domain.Allergy;
import org.healtcare.hypermediadriven.microservices.patient.domain.HealtCondition;
import org.healtcare.hypermediadriven.microservices.patient.domain.Patient;
import org.healtcare.hypermediadriven.microservices.patient.domain.persistence.AllergyRepository;
import org.healtcare.hypermediadriven.microservices.patient.domain.persistence.HealtConditionRepository;
import org.healtcare.hypermediadriven.microservices.patient.domain.persistence.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//@ConditionalOnProperty("loadsampledata")
@Component
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final static Logger LOGGER = LoggerFactory.getLogger(SampleDataLoader.class);

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AllergyRepository allergyRepository;
    @Autowired
    private HealtConditionRepository healtConditionRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOGGER.info("Loading sample data");
        // if (patientRepository.count() == 0) {
        // final Patient[] patients = { patientRepository.save(new Patient(UUID.randomUUID().toString(), "Rick", "Deckard", "M")), patientRepository.save(new Patient(UUID.randomUUID().toString(), "Roy", "Batty", "M")),
        // patientRepository.save(new Patient(UUID.randomUUID().toString(), "Denise", "Fox", "F")), patientRepository.save(new Patient(UUID.randomUUID().toString(), "Carol", "Smith", "F")) };
        //
        // LOGGER.info("Added {} Patients", patients.length);
        //
        // } else {
        // LOGGER.info("Database is not empty. No sample data will be loaded.");
        // }

        LOGGER.info("-------------------------------");
        LOGGER.info("Create patients:");
        LOGGER.info("-------------------------------");
        Patient johnSmith = patientRepository.save(new Patient("John", "Smith", "M"));
        Patient jamesGreen = patientRepository.save(new Patient("James", "Green", "M"));
        Patient charlesTaylor = patientRepository.save(new Patient("Charles", "Taylor", "M"));
        Patient emilyHall = patientRepository.save(new Patient("Emily", "Hall", "F"));

        // fetch all patients
        LOGGER.info("-------------------------------");
        LOGGER.info("Patient found with findAll():");
        LOGGER.info("-------------------------------");
        for (Patient patient : patientRepository.findAll()) {
            LOGGER.info(patient.toString());
        }

        LOGGER.info("-------------------------------");
        LOGGER.info("Create allergies:");
        LOGGER.info("-------------------------------");
        Allergy anaphylaxis = allergyRepository.save(new Allergy("anaphylaxis"));
        Allergy dermatitis = allergyRepository.save(new Allergy("dermatitis"));
        Allergy sneezing = allergyRepository.save(new Allergy("sneezing"));
        Allergy rhinitis = allergyRepository.save(new Allergy("rhinitis"));

        // fetch all allergies
        LOGGER.info("-------------------------------");
        LOGGER.info("Allergy found with findAll():");
        LOGGER.info("-------------------------------");
        for (Allergy allergy : allergyRepository.findAll()) {
            LOGGER.info(allergy.toString());
        }

        LOGGER.info("-------------------------------");
        LOGGER.info("Create Healt Conditions:");
        LOGGER.info("-------------------------------");
        HealtCondition tired = healtConditionRepository.save(new HealtCondition("tired"));
        HealtCondition serious = healtConditionRepository.save(new HealtCondition("serious"));
        HealtCondition excellent = healtConditionRepository.save(new HealtCondition("excellent"));
        HealtCondition weak = healtConditionRepository.save(new HealtCondition("weak"));

        // fetch all healt conditions
        LOGGER.info("-------------------------------");
        LOGGER.info("Healt Conditions found with findAll():");
        LOGGER.info("-------------------------------");
        for (HealtCondition healtCondition : healtConditionRepository.findAll()) {
            LOGGER.info(healtCondition.toString());
        }

        LOGGER.info("-------------------------------");
        LOGGER.info("Add allergies and healt condition of John Smith:");
        LOGGER.info("-------------------------------");
        johnSmith.add(dermatitis);
        johnSmith.add(sneezing);
        johnSmith.setHealtCondition(tired);
        patientRepository.save(johnSmith);
        LOGGER.info(johnSmith.toString());

        LOGGER.info("-------------------------------");
        LOGGER.info("Add allergies and healt condition of James Green:");
        LOGGER.info("-------------------------------");
        jamesGreen.add(anaphylaxis);
        jamesGreen.setHealtCondition(excellent);
        patientRepository.save(jamesGreen);
        LOGGER.info(jamesGreen.toString());

        LOGGER.info("-------------------------------");
        LOGGER.info("Add allergies and healt condition of Charles Taylor:");
        LOGGER.info("-------------------------------");
        charlesTaylor.setHealtCondition(serious);
        patientRepository.save(charlesTaylor);
        LOGGER.info(charlesTaylor.toString());

        LOGGER.info("-------------------------------");
        LOGGER.info("Add allergies and healt condition of Emily Hall:");
        LOGGER.info("-------------------------------");
        emilyHall.add(dermatitis);
        emilyHall.add(rhinitis);
        emilyHall.setHealtCondition(weak);
        patientRepository.save(emilyHall);
        LOGGER.info(emilyHall.toString());

    }

}
