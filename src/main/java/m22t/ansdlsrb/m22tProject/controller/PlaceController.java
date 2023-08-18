package m22t.ansdlsrb.m22tProject.controller;

import m22t.ansdlsrb.m22tProject.data.dto.FrontendDto;
import m22t.ansdlsrb.m22tProject.data.dto.PlaceDto;
import m22t.ansdlsrb.m22tProject.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping()
public class PlaceController {
    private final PlaceService placeService;
    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }
    @PostMapping("/search-places")
    public ResponseEntity<List<PlaceDto>> searchPlacesByCoordinatesAndType(@RequestBody FrontendDto frontendDto) {
        List<PlaceDto> places = placeService.getPlacesByCoordinates(frontendDto);
        return ResponseEntity.ok(places);
    }
}
