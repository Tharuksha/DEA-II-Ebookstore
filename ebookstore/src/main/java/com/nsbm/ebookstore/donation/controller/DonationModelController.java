package com.nsbm.ebookstore.donation.controller;
import com.nsbm.ebookstore.donation.model.DonationModel;
import com.nsbm.ebookstore.donation.service.DonationModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donations")
public class DonationModelController {

    @Autowired
    private DonationModelService donationModelService;

    @GetMapping
    public ResponseEntity<List<DonationModel>> getAllDonations() {
        List<DonationModel> donations = donationModelService.getAllDonations();
        return new ResponseEntity<>(donations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonationModel> getDonationById(@PathVariable Long id) {
        Optional<DonationModel> donation = donationModelService.getDonationById(id);
        return donation.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DonationModel> addDonation(@RequestBody DonationModel donation) {
        DonationModel newDonation = donationModelService.addDonation(donation);
        return new ResponseEntity<>(newDonation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonationModel> updateDonation(@PathVariable Long id, @RequestBody DonationModel donation) {
        DonationModel updatedDonation = donationModelService.updateDonation(id, donation);
        return new ResponseEntity<>(updatedDonation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDonation(@PathVariable("id") Long id) {
        donationModelService.deleteDonation(id);
        return new ResponseEntity<>("Donation deleted successfully", HttpStatus.OK);
    }



}
