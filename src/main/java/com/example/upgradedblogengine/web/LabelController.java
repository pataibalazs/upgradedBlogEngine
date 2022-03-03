package com.example.upgradedblogengine.web;


import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.repository.CategoryRepository;
import com.example.upgradedblogengine.repository.LabelRepository;
import com.example.upgradedblogengine.service.LabelService;
import com.example.upgradedblogengine.web.dto.category.CategoryDTO;
import com.example.upgradedblogengine.web.dto.label.LabelDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/label")
public class LabelController {



    private final LabelService labelService;
    private final LabelRepository labelRepository;

    public LabelController(LabelService labelService, LabelRepository labelRepository) {
        this.labelService = labelService;
        this.labelRepository = labelRepository;
    }


    private LabelDTO mapLabelToDTO(Label label) {
        return new LabelDTO(label.getLabelName(),label.getCategories());
    }
    @GetMapping()
    public List<LabelDTO> getLabels(Pageable pageable) {
        return labelService.getLabels(pageable).stream().map(label -> mapLabelToDTO(label)).collect(Collectors.toList());
    }

/*
    @DeleteMapping({"/{id}"})
    public void deleteLabel(@PathVariable Long id) {
        System.out.println("AAAAAAAAAAAAAAA");
        System.out.println(categoryRepository.findCategoryByLabelsContaining(id));
        System.out.println("AAAAAAAAAAAAAAA");
        //labelService.deleteLabel(id);
    }

 */

    @DeleteMapping({"/{id}"})
    public void deleteLabel(@PathVariable Long id) {
        labelService.deleteLabel(id);
    }
}
