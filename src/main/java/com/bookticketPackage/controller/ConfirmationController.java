package com.bookticketPackage.controller;

import com.bookticketPackage.dto.ConfirmationDto;
import com.bookticketPackage.service.ConfirmationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/confirmation")
public class ConfirmationController {
    private final ConfirmationService confirmationService;

    public ConfirmationController(ConfirmationService confirmationService) {
        this.confirmationService = confirmationService;
    }

    //save confirmation

    @PostMapping
    public ResponseEntity<String> save(@RequestBody ConfirmationDto confirmationDto){

        return  ResponseEntity.ok().body(confirmationService.save(confirmationDto));
    }

    // get all Confirmation
    @GetMapping
    public ResponseEntity<List<ConfirmationDto>> getAllConfirmation(){
        return ResponseEntity.ok().body(confirmationService.getAllConfirmation());
    }
        //get confimation by id
    @GetMapping("/{confirmationId}")
    public ResponseEntity<ConfirmationDto> getConfirmationByConfirmationId(@PathVariable("confirmationId") long confirmationId){
        return ResponseEntity.ok().body(confirmationService.getConfirmationByConfirmationId(confirmationId));
    }

    //compose cconfimation detail on the order

//    @GetMapping("/confirmationdetail/{id}")
//    public ResponseEntity<Object[]> collectConfirmationInfo(@PathVariable("id") long confirmationId){
//        return ResponseEntity.ok().body(confirmationService.collectConfirmationInfo(confirmationId));
//    }

    //delete confimation by id
    @DeleteMapping("/{confirmationid}")
    public ResponseEntity<String> deleteConfirmationById(@PathVariable("confirmationid") long confirmationid){
        return ResponseEntity.ok().body(confirmationService.deleteConfirmationById(confirmationid));
    }

    //update confimation by id
//    @PatchMapping("/{id}")
//    public ResponseEntity<String>  updateConfirmationById(@PathVariable("id") long id, @RequestBody ConfirmationDto confirmationDto){
//        return ResponseEntity.ok().body(confirmationService.updateConfirmationById(id,confirmationDto));
//    }

}
