package m22t.ansdlsrb.m22tProject.data.dao;

import m22t.ansdlsrb.m22tProject.data.entity.PlaceEntity;
import m22t.ansdlsrb.m22tProject.data.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlaceDaoImpl implements PlaceDao{
    PlaceRepository placeRepository;
    @Autowired
    public PlaceDaoImpl(PlaceRepository placeRepository){
        this.placeRepository = placeRepository;
    }
    @Override
    public List<PlaceEntity> getPlacesByCoordinates(double minX, double maxX, double minY, double maxY, int type) {
        if(type==0) // 타입이 0인 경우 == 모든 장소 카테고리 선택
            return placeRepository.getAllPlacesByXBetweenAndYBetween(minX, maxX, minY, maxY);
        else // 카페, 공공회의실, 공공회의실 타입 선택
            return placeRepository.getPlacesByXBetweenAndYBetweenAndType(minX, maxX, minY, maxY, type);
    }
}
