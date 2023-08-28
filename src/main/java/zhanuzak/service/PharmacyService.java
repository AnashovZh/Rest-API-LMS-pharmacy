package zhanuzak.service;

import zhanuzak.entity.Pharmacy;

import java.util.List;
import java.util.Map;

public interface PharmacyService {

    List<Pharmacy> findAllPharmacy();

    Pharmacy savePharmacy(Pharmacy pharmacy);

    Pharmacy findById(Long pharmacyId);

    Pharmacy updatePharmacy(Long pharmacyId, Map<String, Object> fields);

    String deletePharmacy(Long pharmacyId);
}
