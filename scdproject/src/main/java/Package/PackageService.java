package Package;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {
    private final PackageRepository packageRepository;

    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }
    public Package savePackage(Package newPackage) {
        return packageRepository.save(newPackage);
    }
    public List<Package> getUnallocatedPackages() {
        return packageRepository.findUnallocatedPackages();
    }

}
