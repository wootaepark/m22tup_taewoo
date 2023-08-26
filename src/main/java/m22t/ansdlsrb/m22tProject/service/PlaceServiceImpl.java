package m22t.ansdlsrb.m22tProject.service;

import m22t.ansdlsrb.m22tProject.data.dao.PlaceDao;
import m22t.ansdlsrb.m22tProject.data.dto.FrontendDto;
import m22t.ansdlsrb.m22tProject.data.dto.PlaceDto;
import m22t.ansdlsrb.m22tProject.data.entity.PlaceEntity;
import m22t.ansdlsrb.m22tProject.data.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService{

    PlaceDao placeDao;
    private PlaceRepository placeRepository;
    @Autowired
    public PlaceServiceImpl(PlaceDao placeDao){
        this.placeDao = placeDao;
    }
    @Override
    public List<PlaceDto> getPlacesByCoordinates(FrontendDto frontendDto) {
        double minX = frontendDto.getX() - 0.005;
        double maxX = frontendDto.getX() + 0.005;
        double minY = frontendDto.getY() - 0.005;
        double maxY = frontendDto.getY() + 0.005;

        List<PlaceEntity> places = placeDao.getPlacesByCoordinates(minX, maxX, minY, maxY, frontendDto.getType());

        List<PlaceDto> placeDtos = new ArrayList<>();
        for (PlaceEntity placeEntity : places) {
            PlaceDto placeDto = new PlaceDto();
            placeDto.setId(placeEntity.getId());
            placeDto.setType(placeEntity.getType());
            placeDto.setLocation(placeEntity.getLocation());
            placeDto.setName(placeEntity.getName());
            placeDto.setAddress(placeEntity.getAddress());
            placeDto.setRoadAddress(placeEntity.getRoadAddress());
            placeDto.setPhone(placeEntity.getPhone());
            placeDto.setUrl(placeEntity.getUrl());
            placeDto.setX(placeEntity.getX());
            placeDto.setY(placeEntity.getY());
            placeDto.setImgUrl(placeEntity.getImgUrl());

            placeDtos.add(placeDto);
        }
        return placeDtos;
    }




}
