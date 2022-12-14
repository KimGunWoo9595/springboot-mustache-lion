package com.mustache.bbs.controllerRest;

import com.mustache.bbs.domain.dto.hospitalDto.HospitalResponse;
import com.mustache.bbs.domain.dto.hospitalDto.HospitalListDto;
import com.mustache.bbs.domain.dto.hospitalDto.HospitalWithReview;
import com.mustache.bbs.domain.dto.hospitalDto.Result;
import com.mustache.bbs.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HospitalRestController {

    private final HospitalService hospitalService;

    @GetMapping("/api/hospitals/{id}") // 병원만 조회
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) {
        HospitalResponse hospitalResponse = hospitalService.getHospital(id);//엔티티
        return ResponseEntity.ok().body(hospitalResponse); // 리턴은 dto
    }

    @GetMapping("/api/hospitals/{id}/reviews") // 병원과 리뷰 조회
    public ResponseEntity<HospitalWithReview> getWithReview(@PathVariable Integer id) {
        HospitalWithReview hospitalWithReview = hospitalService.getHospitalWithReview(id);//엔티티
        return ResponseEntity.ok().body(hospitalWithReview); // 리턴은 dto
    }

    //병원 전체 리스트 , count
    @GetMapping("/api/hospitals")
    public Result getList() {
        List<HospitalListDto> hospitalListDtoList = hospitalService.findAll();
        return new Result(hospitalListDtoList.size(),hospitalListDtoList);
        //                    병원 총 개수           ,병원 정보 리스트
    }

    //리뷰가 있는 병원 리스트 조회
    @GetMapping("/api/hospitals/reviews")
    public ResponseEntity<List<HospitalWithReview>> getListExistReview() {
        List<HospitalWithReview> hospitalServiceAllExistReviews = hospitalService.findAllExistReview();
        return ResponseEntity.ok()
                .body(hospitalServiceAllExistReviews);
    }

}
