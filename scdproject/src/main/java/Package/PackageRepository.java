package Package;

import Package.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package, Long> {
    @Query("SELECT p FROM Package p WHERE p.courierId IS NULL")
    List<Package> findUnallocatedPackages();

}
