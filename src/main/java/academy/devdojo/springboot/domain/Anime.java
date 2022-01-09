package academy.devdojo.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Anime {
    private Long id;
    private String name;

    public Anime(String name) {
        this.name = name;
    }

    public Anime() {

    }


}
