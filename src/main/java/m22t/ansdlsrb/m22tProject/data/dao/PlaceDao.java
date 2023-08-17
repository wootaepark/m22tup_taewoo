package m22t.ansdlsrb.m22tProject.data.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import m22t.ansdlsrb.m22tProject.data.entity.PlaceEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PlaceDao {
    List<PlaceEntity> getPlacesByCoordinates(double minX, double maxX, double minY, double maxY, int type);
}
