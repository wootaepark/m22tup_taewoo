package m22t.ansdlsrb.m22tProject.service;

import m22t.ansdlsrb.m22tProject.data.dto.FrontendDto;
import m22t.ansdlsrb.m22tProject.data.dto.PlaceDto;

import java.util.List;

public interface PlaceService {
    List<PlaceDto> getPlacesByCoordinates(FrontendDto frontendDto);

}