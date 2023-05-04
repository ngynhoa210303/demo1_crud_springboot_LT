package com.example.demo.controller;

import com.example.demo.entity.MayTinhs;
import com.example.demo.request.MayTinhRequest;
import com.example.demo.service.MayTinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author thangdt
 */
@RestController
@RequestMapping("/may-tinh")
public class MayTinhController {

    @Autowired
    private MayTinhService mayTinhService;

    @GetMapping("/hien-thi")
    public List<MayTinhs> getAll() {
        return mayTinhService.getList();
    }
//    public ResponseEntity<Map<String, Object>> getAll(@RequestParam(defaultValue = "0", name = "page") int page) {
//        Page<MayTinhs> listMayTinh = mayTinhService.getList(page);
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("mayTinhRequest", new MayTinhRequest());
//        response.put("listMayTinh", listMayTinh);
//        return ResponseEntity.ok(response);
//    }


    @GetMapping("/detail/{ma}")
    public MayTinhs detail(@PathVariable("ma") UUID ma, Model model) {
        return mayTinhService.findById(ma);
    }

    @PostMapping("/add")
    public MayTinhs create(@ModelAttribute("mayTinhRequest") MayTinhRequest request) {
        return mayTinhService.insert(request);
    }

    @PutMapping("/update")
    public MayTinhs update(@ModelAttribute("mayTinhRequest") MayTinhRequest request) {
        return mayTinhService.update(request.getMa(), request);
    }

    @DeleteMapping("/delete/{ma}")
    public boolean delete(@PathVariable("ma") UUID ma) {
        return mayTinhService.delete(ma);
    }
}
