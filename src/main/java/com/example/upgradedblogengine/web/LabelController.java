package com.example.upgradedblogengine.web;


import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.repository.CategoryRepository;
import com.example.upgradedblogengine.repository.LabelRepository;
import com.example.upgradedblogengine.service.LabelService;
import com.example.upgradedblogengine.web.dto.category.CategoryDTO;
import com.example.upgradedblogengine.web.dto.label.LabelDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/label")
public class LabelController {



    private final LabelService labelService;


    public LabelController(LabelService labelService) {
        this.labelService = labelService;
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping({"/{id}"})
    public void deleteLabel(@PathVariable Long id) {
        labelService.deleteLabel(id);
    }
}
