package edu.miu.cs545.waa.service;

import edu.miu.cs545.waa.dto.FilterDto;
import edu.miu.cs545.waa.dto.SellerDto;

import java.util.List;

public interface SellerService {
    List<SellerDto> getSellers(FilterDto filterDto, String userId);

    SellerDto updateSeller(Long id, SellerDto sellerDto, String userId);

    void followSeller(boolean flag, Long sellerId, String userId);
}