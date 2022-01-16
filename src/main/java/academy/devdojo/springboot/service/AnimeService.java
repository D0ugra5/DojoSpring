package academy.devdojo.springboot.service;

import academy.devdojo.springboot.domain.Anime;
import academy.devdojo.springboot.mapper.AnimeMapper;
import academy.devdojo.springboot.repository.AnimeRepository;
import academy.devdojo.springboot.requests.AnimePostRequestBody;
import academy.devdojo.springboot.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime Id not found"));


    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {

        return animeRepository.save(AnimeMapper.INSTACE.toAnime(animePostRequestBody));

    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
     Anime anime = AnimeMapper.INSTACE.toAnime(animePutRequestBody);
     anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }
}
