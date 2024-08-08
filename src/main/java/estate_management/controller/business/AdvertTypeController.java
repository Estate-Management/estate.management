package estate_management.controller.business;

import estate_management.domain.advert.AdvertType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import estate_management.service.business.AdvertTypeService;

import java.util.List;

@RestController
@Data
@NoArgsConstructor
public class AdvertTypeController {

    private AdvertTypeService advertTypeService;

    @Autowired
    public AdvertTypeController(AdvertTypeService advertTypeService) {
        this.advertTypeService = advertTypeService;
    }

    @GetMapping("/advert-types")
    public ResponseEntity<List<AdvertType>> getAllAdvertTypes() {
        List<AdvertType> advertTypes = advertTypeService.getAllAdvertType();
        return ResponseEntity.ok(advertTypes);
    }

}
