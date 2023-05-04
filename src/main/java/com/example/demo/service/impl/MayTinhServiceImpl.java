package com.example.demo.service.impl;

import com.example.demo.entity.MayTinhs;
import com.example.demo.repository.MayTinhRepository;
import com.example.demo.request.MayTinhRequest;
import com.example.demo.service.MayTinhService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author thangdt
 */
@Service
public class MayTinhServiceImpl implements MayTinhService {

    @Autowired
    private MayTinhRepository mayTinhRepository;


//    @Override
//    public Page<MayTinhs> getList(int page) {
//        Pageable pageable = PageRequest.of(page , 5);
//        return mayTinhRepository.findAll(pageable);
//    }
@Override
    public List<MayTinhs> getList() {
        return mayTinhRepository.findAll();
    }

    @Override
    public MayTinhs insert(MayTinhRequest request) {
        MayTinhs mayTinhs = new MayTinhs();
        BeanUtils.copyProperties(request, mayTinhs);
        return mayTinhRepository.save(mayTinhs);
    }

    @Override
    public boolean delete(UUID id) {
        mayTinhRepository.deleteById(id);
        return true;
    }

    @Override
    public MayTinhs update(UUID ma, MayTinhRequest request) {
        Optional<MayTinhs> mayTinhs = mayTinhRepository.findById(ma);
        BeanUtils.copyProperties(request, mayTinhs.get());
        return mayTinhRepository.save(mayTinhs.get());
    }

    @Override
    public MayTinhs findById(UUID ma) {
        return mayTinhRepository.findById(ma).orElse(null);
    }

}
