package zhanuzak.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import zhanuzak.entity.Pharmacy;
import zhanuzak.repository.PharmacyRepository;
import zhanuzak.service.PharmacyService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class PharmacyImpl implements PharmacyService {
    private final PharmacyRepository pharmacyRepository;

    @Override
    public List<Pharmacy> findAllPharmacy() {
        return pharmacyRepository.findAll();
    }

    @Override
    public Pharmacy savePharmacy(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    @Override
    public Pharmacy findById(Long pharmacyId) {
        return pharmacyRepository.findById(pharmacyId).orElseThrow(() -> new RuntimeException(
                "Pharmacy waith id:" + pharmacyId + "not found!"));
    }

    @Override
    public Pharmacy updatePharmacy(Long pharmacyId, Map<String, Object> fields) {
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId).orElseThrow(() -> new RuntimeException(
                "Pharmacy waith id:" + pharmacyId + "not found!"));
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Pharmacy.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, pharmacy, value);
        });
        return pharmacyRepository.save(pharmacy);
    }

    @Override
    public String deletePharmacy(Long pharmacyId) {
       if(!pharmacyRepository.existsById(pharmacyId)){
           throw  new NoSuchElementException("Pharmacy with id:"+pharmacyId+"not found!!");
       }
       pharmacyRepository.deleteById(pharmacyId);
        return "Successfully deleted with id:"+pharmacyId;
    }
}
