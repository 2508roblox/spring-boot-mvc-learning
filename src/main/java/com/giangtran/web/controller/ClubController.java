package com.giangtran.web.controller;

import com.giangtran.web.dto.ClubDto;
import com.giangtran.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
