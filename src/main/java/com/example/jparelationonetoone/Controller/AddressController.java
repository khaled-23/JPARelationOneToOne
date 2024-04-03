package com.example.jparelationonetoone.Controller;

import com.example.jparelationonetoone.Api.ApiResponse;
import com.example.jparelationonetoone.DTO.AddressDTO;
import com.example.jparelationonetoone.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;


    @GetMapping("/addresses")
    public ResponseEntity getAllAddresses(){
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.ok(new ApiResponse("address added"));
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.ok(new ApiResponse("address updated"));
    }

    @DeleteMapping("/remove/{address_id}")
    public ResponseEntity removeAddress(@PathVariable Integer address_id){
        addressService.removeAddress(address_id);
        return ResponseEntity.ok(new ApiResponse("address removed"));
    }

}
