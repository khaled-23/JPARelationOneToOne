package com.example.jparelationonetoone.Controller;

import com.example.jparelationonetoone.Api.ApiResponse;
import com.example.jparelationonetoone.DTO.AddressDTO;
import com.example.jparelationonetoone.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    Logger logger = LoggerFactory.getLogger(AddressController.class);

    @GetMapping("/addresses")
    public ResponseEntity getAllAddresses(){
        logger.info("addresses requested");
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        logger.info("address added");
        return ResponseEntity.ok(new ApiResponse("address added"));
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        logger.info("address updated");
        return ResponseEntity.ok(new ApiResponse("address updated"));
    }

    @DeleteMapping("/remove/{address_id}")
    public ResponseEntity removeAddress(@PathVariable Integer address_id){
        addressService.removeAddress(address_id);
        logger.info("address removed");
        return ResponseEntity.ok(new ApiResponse("address removed"));
    }

}
