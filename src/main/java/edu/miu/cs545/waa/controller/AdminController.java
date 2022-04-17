package edu.miu.cs545.waa.controller;

import edu.miu.cs545.waa.dto.FilterDto;
import edu.miu.cs545.waa.dto.SellerDto;
import edu.miu.cs545.waa.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sellers")
public class AdminController {

    private SellerService sellerService;

    @Autowired
    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping
    public List<SellerDto> getSellers(FilterDto filterDto, Principal principal) {
        return sellerService.getSellers(filterDto, principal.getName());
    }

    @PutMapping("{id}")
    public SellerDto updateSeller(@PathVariable Long id, @RequestBody SellerDto sellerDto, Principal principal) {
        return sellerService.updateSeller(id, sellerDto, principal.getName());
    }
}
