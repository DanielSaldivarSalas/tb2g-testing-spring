package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {
    @Mock
    private ClinicService clinicService;
    @Mock
    Map<String, Object> model;
    @InjectMocks
    private VetController vetController;

    List<Vet> vetsList;
    @BeforeEach
    void setUp(){
        vetsList = new ArrayList<>();
        vetsList.add(new Vet());
        given(clinicService.findVets()).willReturn(vetsList);
    }
    @Test
    void showVetListTest() {
        //given
        //when
        String result = vetController.showVetList(model);

        //then
        assertThat(result).isEqualTo("vets/vetList");
        then(clinicService).should().findVets();
        then(clinicService).shouldHaveNoMoreInteractions();
    }

    @Test
    void showResourcesVetListTest() {
        //given


        //when
        Vets vets = vetController.showResourcesVetList();

        //then
        assertThat(vets).isNotNull();
        then(clinicService).should().findVets();
        then(clinicService).shouldHaveNoMoreInteractions();
    }
}