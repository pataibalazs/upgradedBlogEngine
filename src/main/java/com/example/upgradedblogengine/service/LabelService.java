package com.example.upgradedblogengine.service;

import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.web.dto.label.NewLabelDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
@Service
public interface LabelService {

    List<Label> getLabels(Pageable pageable);
    Set<Label> getPersistedLabels(Collection<Label> array);

    Label createLabel(NewLabelDTO newLabel);
    Label createLabelWithCategories(NewLabelDTO newLabel,Set<Category> categoryList);
    void deleteLabel(Long id);
    //List<Category>findCategoryBylabelId(Long labelId);

}
