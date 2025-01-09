package Courier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {
    @Query("SELECT c FROM Courier c WHERE c.managerId IS NOT NULL")
    List<Courier> findCouriersWithManagers();


}
