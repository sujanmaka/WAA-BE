package edu.miu.cs545.waa.controller;

import edu.miu.cs545.waa.dto.FilterDto;
import edu.miu.cs545.waa.dto.ReviewDto;
import edu.miu.cs545.waa.dto.SellerDto;
import edu.miu.cs545.waa.service.ReviewService;
import edu.miu.cs545.waa.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {

    private SellerService sellerService;
    private ReviewService reviewService;

    @Autowired
    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/sellers")
    public List<SellerDto> getSellers(FilterDto filterDto, Principal principal) {
        return sellerService.getSellers(filterDto, principal.getName());
    }

    @PutMapping("/sellers/{id}")
    public SellerDto updateSeller(@PathVariable Long id, @RequestBody SellerDto sellerDto, Principal principal) {
        return sellerService.updateSeller(id, sellerDto, principal.getName());
    }

    @GetMapping("/reviews")
    public List<ReviewDto> getReviews(FilterDto filterDto, Principal principal) {
        return reviewService.getReviews(filterDto, principal.getName());
    }

    @PutMapping("/reviews/{id}")
    public ReviewDto updateReviews(@PathVariable Long id, @RequestBody ReviewDto reviewDto) {
        return reviewService.updateReview(id, reviewDto);
    }
}
