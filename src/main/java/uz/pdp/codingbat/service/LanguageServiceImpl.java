package uz.pdp.codingbat.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.Language;
import uz.pdp.codingbat.payload.AddLanguageDTO;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.LanguageDTO;
import uz.pdp.codingbat.repository.LanguageRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Override
    public ApiResult<?> add(AddLanguageDTO addLanguageDTO) {
        Language language=new Language();
        language.setTitle(addLanguageDTO.getTitle());
        language.setUrl(UUID.randomUUID().toString());
        languageRepository.save(language);

        //todo yoz logicni
        return ApiResult.successResponse("OK okasi");
    }

    @Override
    public List<LanguageDTO> getAll() {
        return languageRepository.findAll()
                .stream()
                .map(this::mapLanguageToLanguageDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LanguageDTO get(Short id) {
        Language language = languageRepository.findById(id).orElseThrow(RuntimeException::new);
        return mapLanguageToLanguageDTO(language);
    }

    @Override
    public ApiResult<?> edit(Short id, LanguageDTO languageDTO) {
        return ApiResult.successResponse();
    }

    @Override
    public ApiResult<?> delete(Short id) {
        return ApiResult.successResponse();
    }

    private LanguageDTO mapLanguageToLanguageDTO(Language language) {
        return new LanguageDTO(
                language.getId(),
                language.getTitle(),
                language.getUrl());
    }
}
