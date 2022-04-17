package edu.miu.cs545.waa.controller;

import edu.miu.cs545.waa.dto.SellerDto;
import edu.miu.cs545.waa.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/follows")
public class BuyerController {
    private SellerService sellerService;

    @Autowired
    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PutMapping
    public void followSeller(@RequestParam boolean flag, @RequestBody SellerDto sellerDto, Principal principal) {
        sellerService.followSeller(flag, sellerDto.getId(), principal.getName());
    }
}
