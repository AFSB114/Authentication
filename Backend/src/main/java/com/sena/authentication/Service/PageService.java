package com.sena.authentication.Service;

import com.sena.authentication.DTO.PageDTO;
import com.sena.authentication.DTO.PermissionDTO;
import com.sena.authentication.Model.Page;
import com.sena.authentication.Repository.iPage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PageService {

    private final iPage iPage;

    public PageService(iPage iPage) {
        this.iPage = iPage;
    }

    public List<Page> getPages() {
        return iPage.findAll();
    }

    public String addPage(PageDTO pageDTO) {
        Page page = Page
                .builder()
                .title(pageDTO.getTitle())
                .description(pageDTO.getDescription())
                .build();
        iPage.save(page);
        return "ok";
    }

    public String editPage(PageDTO pageDTO, Integer id) {
        Optional<Page> optionalPage = iPage.findById(id);
        if(optionalPage.isEmpty()) return "error";

        Page page = optionalPage.get();
        page.setTitle(pageDTO.getTitle() == null ? page.getTitle() : pageDTO.getTitle());
        page.setDescription(pageDTO.getDescription() == null ? page.getDescription() : pageDTO.getDescription());
        page.setUpdatedAt(LocalDateTime.now());

        iPage.save(page);
        return "ok";
    }

    public String deletePage(Integer id) {
        Optional<Page> optionalPage = iPage.findById(id);
        if(optionalPage.isEmpty()) return "error";
        Page page = optionalPage.get();
        iPage.delete(page);
        return "ok";
    }
}
