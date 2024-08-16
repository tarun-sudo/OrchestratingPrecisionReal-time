package org.kakarla.OrchestratingPrecisionRealtime.Repository;

import org.kakarla.OrchestratingPrecisionRealtime.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}