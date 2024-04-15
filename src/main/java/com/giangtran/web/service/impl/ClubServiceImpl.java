package com.giangtran.web.service.impl;

import com.giangtran.web.dto.ClubDto;
import com.giangtran.web.models.Club;
import com.giangtran.web.repository.ClubRepository;
import com.giangtran.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();

        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    };
    private ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
        return clubDto;
    }

}
