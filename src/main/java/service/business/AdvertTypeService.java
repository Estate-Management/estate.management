package service.business;

import domain.advert.AdvertType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.business.AdvertTypeRepository;

import java.util.List;

@Getter
@Service
@Data
@NoArgsConstructor
public class AdvertTypeService {

    private AdvertTypeRepository advertTypeRepository;

    @Autowired
    public AdvertTypeService(AdvertTypeRepository advertTypeRepository) {
        this.advertTypeRepository = advertTypeRepository;
    }

    public List<AdvertType> getAllAdvertType() {
        return advertTypeRepository.findAll();
    }

}
