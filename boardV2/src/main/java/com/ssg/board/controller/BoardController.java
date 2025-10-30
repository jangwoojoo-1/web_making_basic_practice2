package com.ssg.board.controller;

import com.ssg.board.dto.BoardDTO;
import com.ssg.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @RequestMapping("/list")
    public void list(Model model){
        log.info("board list 화면 출력");
        model.addAttribute("dtoList", boardService.getList());
    }

    @RequestMapping("/register")
    public void register(){
        log.info("GET board register 화면 호출");
    }

    @PostMapping("/register")
    public String registerPOST(@Valid BoardDTO boardDTO,
            BindingResult bindingResult
            ,RedirectAttributes redirectAttributes){
        log.info("POST board register 기능 호출");
        if(bindingResult.hasErrors()){
            log.info("has error");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/board/register";
        }

        log.info(boardDTO);
        boardService.save(boardDTO);

        return "redirect:/board/list";
    }

    @GetMapping({"/read","/modify"})
    public void readGET(Long postId, Model model){
        log.info("Get read, modify 화면 호출");
        BoardDTO boardDTO = boardService.getDetail(postId);
        log.info(boardDTO);
        model.addAttribute("dto", boardDTO);
    }


    @PostMapping("/remove")
    public String removePOST(Long postId, RedirectAttributes redirectAttributes) {
        log.info("POST remove 기능 호출");
        log.info("postId : " + postId);
        boardService.removeOne(postId);

        return "redirect:/board/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid BoardDTO boardDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        log.info("POST modify 기능 호출");
        if(bindingResult.hasErrors()) {
            log.info("has errors.......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );
            redirectAttributes.addAttribute("postId", boardDTO.getPostId() );
            return "redirect:/board/modify";
        }
        log.info(boardDTO);
        boardService.modifyOne(boardDTO);
        return "redirect:/board/list";
    }

}
