package karol.spring.recipeApp.services;

import karol.spring.recipeApp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import karol.spring.recipeApp.models.UnitOfMeasure;
import karol.spring.recipeApp.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


/**
 * @author Karol Wlazło
 * recipeApp
 */

class UnitOfMeasureServiceImplTest {

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    UnitOfMeasureService unitOfMeasureService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        unitOfMeasureService = new UnitOfMeasureServiceImpl(unitOfMeasureRepository);
    }

    @Test
    void listAllUnitOfMeasure() {

        List<UnitOfMeasure> unitOfMeasureList = new ArrayList<>();

        UnitOfMeasure uom1= new UnitOfMeasure();
        uom1.setId(1L);
        unitOfMeasureList.add(uom1);

        UnitOfMeasure uom2= new UnitOfMeasure();
        uom2.setId(1L);
        unitOfMeasureList.add(uom2);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasureList);

        List<UnitOfMeasure> commands = unitOfMeasureService.listAllUnitOfMeasure();

        assertEquals(2, commands.size());
        verify(unitOfMeasureRepository, times(1)).findAll();
    }
}