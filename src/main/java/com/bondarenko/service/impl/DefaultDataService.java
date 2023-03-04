package com.bondarenko.service.impl;

import com.bondarenko.entity.Data;
import com.bondarenko.repository.DataRepository;
import com.bondarenko.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class DefaultDataService implements DataService {
    private static final int PAGE_SIZE = 100;
    private DataRepository dataRepository;

    @Override
    @Transactional
    public void process() {
        Pageable pageable = PageRequest.of(0, PAGE_SIZE, Sort.by(Sort.Direction.ASC, "id"));
        Page<Data> page = dataRepository.findAll(pageable);
        List<Data> dataFirstPage = page.getContent();
        dataFirstPage.forEach(dataDto -> dataDto.setUpdatedTime(LocalDateTime.now()));
        dataRepository.saveAll(dataFirstPage);

        while (page.hasNext()) {
            page = dataRepository.findAll(page.nextPageable());
            List<Data> dataList = page.getContent();
            dataList.forEach(dataDto -> dataDto.setUpdatedTime(LocalDateTime.now()));
            dataRepository.saveAll(dataList);
        }
    }
}

