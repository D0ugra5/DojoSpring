package academy.devdojo.springboot.service;

import academy.devdojo.springboot.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class AnimeService {

    public List<Anime> listAll(){
        return Arrays.asList(new Anime(2L,"a"), new Anime(1L,"Hunter Hunter"));
    }
}
