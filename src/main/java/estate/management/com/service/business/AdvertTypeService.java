package estate.management.com.service.business;

import estate.management.com.repository.business.AdvertTypeRepository;
import estate.management.com.domain.advert.AdvertType;
import estate.management.com.exception.ResourceNotFoundException;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public AdvertType getAdvertTypeById(Long id) {
        return advertTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Advert Type not found"));
    }

}
