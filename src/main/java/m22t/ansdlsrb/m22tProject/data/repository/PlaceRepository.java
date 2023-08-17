package m22t.ansdlsrb.m22tProject.data.repository;

import m22t.ansdlsrb.m22tProject.data.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<PlaceEntity, Long> {
    List<PlaceEntity> getAllPlacesByXBetweenAndYBetween(double minX, double maxX, double minY, double maxY);
    List<PlaceEntity> getPlacesByXBetweenAndYBetweenAndType(double minX, double maxX, double minY, double maxY, int type);
}
