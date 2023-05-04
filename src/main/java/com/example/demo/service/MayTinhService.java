package com.example.demo.service;

import com.example.demo.entity.MayTinhs;
import com.example.demo.request.MayTinhRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

/**
 * @author thangdt
 */

public interface MayTinhService {

    List<MayTinhs> getList();
//    Page<MayTinhs> getList(int page);

    MayTinhs insert(MayTinhRequest request);

    boolean delete(UUID ma);

    MayTinhs update(UUID ma, MayTinhRequest request);

    MayTinhs findById(UUID id);
}
