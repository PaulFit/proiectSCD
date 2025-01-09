package Package;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
public class PackageController {
    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping
    public List<Package> getAllPackages() {
        return packageService.getAllPackages();
    }
    @PostMapping
    public Package createPackage(@RequestBody Package newPackage) {
        newPackage.setCreatedOn(LocalDateTime.now());
        newPackage.setStatus(Package.Status.NEW);
        return packageService.savePackage(newPackage);
    }

    Actualizează PackageService.java pentru a adăuga metoda de salvare:
    java
    Copiază codul
    public Package savePackage(Package newPackage) {
        return packageRepository.save(newPackage);
    }
    @GetMapping("/unallocated")
    public List<Package> getUnallocatedPackages() {
        return packageService.getUnallocatedPackages();
    }

    @PutMapping("/{id}/deliver")
    public Package markAsDelivered(@PathVariable Long id) {
        Package pkg = packageService.getPackageById(id);
        pkg.setStatus(Package.Status.DELIVERED);
        return packageService.savePackage(pkg);
    }


}
