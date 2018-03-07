package org.healtcare.hypermediadriven.microservices.patient.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.healtcare.hypermediadriven.microservices.patient.domain.Allergy;
import org.healtcare.hypermediadriven.microservices.patient.dto.AllergyDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

@Service
public class AllergyConverter {

    @Autowired
    private ModelMapper mapper;

    public AllergyDTO convert(final Allergy entity) {
        return entity == null ? null : mapper.map(entity, AllergyDTO.class);
    }

    public Optional<AllergyDTO> convert(final Optional<Allergy> entity) throws ParseException {
        AllergyDTO dto = mapper.map(entity.get(), AllergyDTO.class);
        return Optional.of(dto);
    }

    public List<AllergyDTO> convert(final List<Allergy> entities) {
        List<AllergyDTO> dtos = new ArrayList<>();
        for (Allergy entity : entities) {
            dtos.add(mapper.map(entity, AllergyDTO.class));
        }
        return dtos;
    }

    public List<AllergyDTO> convert(final List<Allergy> entities, final String patientUUID) {
        List<AllergyDTO> dtos = new ArrayList<>();
        for (Allergy entity : entities) {
            AllergyDTO dto = mapper.map(entity, AllergyDTO.class);
            dto.setPatientUUID(patientUUID);
            dtos.add(dto);
        }
        return dtos;
    }

    public Allergy convert(final AllergyDTO dto) {
        Allergy entity = mapper.map(dto, Allergy.class);
        return entity;
    }

}
