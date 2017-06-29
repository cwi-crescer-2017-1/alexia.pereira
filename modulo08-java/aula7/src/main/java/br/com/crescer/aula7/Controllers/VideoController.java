package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Entidades.Video;
import br.com.crescer.aula7.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexia.pereira
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService service;

    @GetMapping
    public Iterable<Video> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Video save(@RequestBody Video video) {
        return service.save(video);
    }

    @PutMapping
    public Video update(@RequestBody Video video) {
        return service.update(video);
    }

    @DeleteMapping
    public void remove(@RequestBody Video video) {
        service.remove(video);
    }

    @GetMapping(value = "/{id}")
    public Video loadById(@PathVariable Long id) {
        return service.loadById(id);
    }

}
