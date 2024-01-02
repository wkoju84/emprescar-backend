package br.com.emprescar.service;

import br.com.emprescar.dto.FeatureDto;
import br.com.emprescar.model.Feature;
import br.com.emprescar.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    @Transactional(readOnly = true)
    public List<FeatureDto> searchAll() {
        List<Feature> list = featureRepository.findAll();
        return list.stream().map(x -> new FeatureDto(x)).collect(Collectors.toList());
    }

}