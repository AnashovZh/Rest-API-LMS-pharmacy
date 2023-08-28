package zhanuzak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zhanuzak.entity.Pharmacy;

public interface PharmacyRepository extends JpaRepository<Pharmacy,Long> {
}
