package zhanuzak.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zhanuzak.entity.Pharmacy;
import zhanuzak.service.PharmacyService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pharmacies")
@RequiredArgsConstructor
public class PharmacyApi {
    private final PharmacyService pharmacyService;

    @GetMapping
    List<Pharmacy> getAllPharmacy() {
        return pharmacyService.findAllPharmacy();
    }

    @PostMapping
    Pharmacy save(@RequestBody Pharmacy pharmacy) {
        return pharmacyService.savePharmacy(pharmacy);
    }

    @GetMapping("/{pharmacyId}")
    Pharmacy getById(@PathVariable Long pharmacyId) {
        return pharmacyService.findById(pharmacyId);
    }
    @PostMapping("/{pharmacyId}")
    Pharmacy updatePharmacyById(@PathVariable Long pharmacyId, @RequestBody Map<String ,Object>fields){
        return pharmacyService.updatePharmacy(pharmacyId,fields);
    }
    @PostMapping("/{pharmacyId}")
    String deletePharmacy(@PathVariable Long pharmacyId){
       return pharmacyService.deletePharmacy(pharmacyId);
    }
}
