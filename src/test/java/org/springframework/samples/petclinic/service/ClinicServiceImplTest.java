package org.springframework.samples.petclinic.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
@ExtendWith(MockitoExtension.class)
class ClinicServiceImplTest {
    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private ClinicServiceImpl clinicService;

    @Test
    void findPetTypesTest() {
        //given
        List<PetType> petTypes = new ArrayList<>();
        petTypes.add(new PetType());
        given(petRepository.findPetTypes()).willReturn(petTypes);

        //when
        Collection<PetType> resultPetTypes = clinicService.findPetTypes();

        //then
        assertThat(resultPetTypes).isNotNull();
        assertThat(resultPetTypes.size()).isEqualTo(1);
        then(petRepository).should().findPetTypes();
        then(petRepository).shouldHaveNoMoreInteractions();
    }
}