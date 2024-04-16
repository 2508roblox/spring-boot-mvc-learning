package com.giangtran.web.controller;

import com.giangtran.web.dto.ClubDto;
import com.giangtran.web.models.Club;
import com.giangtran.web.service.ClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClubController {
    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
//        phải dùng Annotation autowire để tự gọi hàm khởi tạo của impl tương ứng cho ClubService interface
        this.clubService = clubService;
    }
    @GetMapping("/clubs")
    public String listClubs(Model model) {
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }
    @GetMapping("/clubs/new")
    public String createClub(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";

    }
    @PostMapping("clubs/store")
    public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("club", clubDto);
            return "clubs-create";
        };
        clubService.storeClub(clubDto);
        return "redirect:/clubs";
    }
    @GetMapping("clubs/{clubId}/edit")
    public String editClub(@PathVariable("clubId") Long clubId, Model model) {
        ClubDto club = clubService.findClubById(clubId);
        System.out.println(club);
        model.addAttribute("club", club);
        return "clubs-edit";
    }

    @PostMapping("clubs/{clubId}/store")
    public String storeClub(@PathVariable("clubId") Long clubId, @Valid @ModelAttribute("club")  ClubDto clubDto, BindingResult result, Model model) {
        System.out.println("checkkkkk");

        System.out.println(clubDto);

        if(result.hasErrors()) {
            model.addAttribute("club", clubDto);
            return "clubs-edit";
        }

            clubService.updateClub(clubDto);
        return "redirect:/clubs";
    }

}
