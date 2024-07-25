package org.example.springmvcacademy.controller;

import lombok.RequiredArgsConstructor;
import org.example.springmvcacademy.dto.request.PhoneCreateRequestDTO;
import org.example.springmvcacademy.dto.request.PhoneUpdateRequestDTO;
import org.example.springmvcacademy.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneCreateService createService;
    private final PhoneReadInfoService readInfoService;
    private final PhoneReadInfoByIdService readInfoByIdService;
    private final PhoneUpdateService updateService;
    private final PhoneDeleteService deleteService;

    @GetMapping("/")
    public String listPhones(Model model) {
        model.addAttribute("phones", readInfoService.readInfo());
        return "phones";
    }

    @GetMapping("/phones/create")
    public String createForm(Model model) {
        var createRequestDTO = new PhoneCreateRequestDTO();
        model.addAttribute("createRequestDTO", createRequestDTO);
        return "create_phone";
    }

    @PostMapping("/phones")
    public String save(@ModelAttribute PhoneCreateRequestDTO createRequestDTO) {
        createService.createPhone(createRequestDTO);
        return "redirect:/phones";
    }

    @GetMapping("/phones/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        model.addAttribute(
                "phoneReadInfoResponseDTO",
                readInfoByIdService.findById(id)
        );
        return "edit_phone";
    }

    @PostMapping("/phones/{id}")
    public String update(@PathVariable String id,
                         @ModelAttribute PhoneUpdateRequestDTO updateRequestDTO) {

        updateService.update(id, updateRequestDTO);
        return "redirect:/phones";
    }

    @GetMapping("/phones/{id}")
    public String delete(@PathVariable String id) {
        deleteService.deleteById(id);
        return "redirect:/phones";
    }
}
