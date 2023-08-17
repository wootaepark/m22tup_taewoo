package m22t.ansdlsrb.m22tProject.controller;

import m22t.ansdlsrb.m22tProject.data.dto.FrontendDto;
import m22t.ansdlsrb.m22tProject.data.dto.PlaceDto;
import m22t.ansdlsrb.m22tProject.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class PlaceController {
    private final PlaceService placeService;
    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }
    @PostMapping
    public ResponseEntity<List<PlaceDto>> searchPlacesByCoordinatesAndType(@RequestBody FrontendDto frontendDto) {
        List<PlaceDto> places = placeService.getPlacesByCoordinates(frontendDto);
        return ResponseEntity.ok(places);
    }
}
