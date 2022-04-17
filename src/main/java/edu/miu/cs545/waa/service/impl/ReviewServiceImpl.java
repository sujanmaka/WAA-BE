package edu.miu.cs545.waa.service.impl;

import edu.miu.cs545.waa.domain.Review;
import edu.miu.cs545.waa.dto.FilterDto;
import edu.miu.cs545.waa.dto.ReviewDto;
import edu.miu.cs545.waa.enums.Status;
import edu.miu.cs545.waa.repository.ReviewRepository;
import edu.miu.cs545.waa.service.ReviewService;
import edu.miu.cs545.waa.util.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private MapperUtils<ReviewDto> mapperToReviewDto;
    private MapperUtils<Review> mapperToReview;

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ReviewDto> getReviews(FilterDto filterDto, String userId) {
        List<Review> reviews;
        if (filterDto != null && filterDto.getStatus() != null) {
            reviews = reviewRepository.findByStatus(filterDto.getStatus());
        } else {
            reviews = reviewRepository.findAll();
        }
        return (List<ReviewDto>) mapperToReviewDto.mapList(reviews, new ReviewDto());
    }

    @Override
    public ReviewDto createReview(ReviewDto reviewDto, String userId) {
        Review review = (Review) mapperToReview.getMap(reviewDto, new Review());
        review.setStatus(Status.CREATED);
        return (ReviewDto) mapperToReviewDto.getMap(reviewRepository.save(review), new ReviewDto());
    }
}
