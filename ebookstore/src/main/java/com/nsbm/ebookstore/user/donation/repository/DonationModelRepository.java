package com.nsbm.ebookstore.user.donation.repository;

import com.nsbm.ebookstore.user.donation.model.DonationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationModelRepository extends JpaRepository<DonationModel, Long> {
}
