package karol.spring.recipeApp.services;

import karol.spring.recipeApp.models.UnitOfMeasure;
import karol.spring.recipeApp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Karol Wlazło
 * recipeApp
 */

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public List<UnitOfMeasure> listAllUnitOfMeasure() {

        List<UnitOfMeasure> units = new ArrayList<>();
        unitOfMeasureRepository.findAll().forEach(units::add);

        return units;
    }
}
