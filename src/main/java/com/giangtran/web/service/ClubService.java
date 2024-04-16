package com.giangtran.web.service;

import com.giangtran.web.dto.ClubDto;
import com.giangtran.web.models.Club;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club storeClub(Club club);
    ClubDto findClubById(Long clubId);
    void updateClub(ClubDto clubDto);
}
