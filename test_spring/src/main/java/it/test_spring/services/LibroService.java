package it.test_spring.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.test_spring.models.dto.LibroDto;
import it.test_spring.models.entities.LibroEntity;
import it.test_spring.models.repository.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	@Autowired
	private AutoreService autoreService;

	public List<LibroEntity> getAllLibri() {
		List<LibroEntity> libri = libroRepository.findAll();

		return libri;
	}

	public LibroEntity getLibro(Long id) {
		return libroRepository.findById(id).get();
	}
	
	public LibroEntity insertLibro(LibroDto libroDto) {
		LibroEntity libro = new LibroEntity();
		
		libro.setTitoloLibro(libroDto.getTitoloLibro());
		libro.setPrezzoLibro(libroDto.getPrezzoLibro());
		libro.setDataPubblicazioneLibro(libroDto.getDataPubblicazioneLibro());
		libro.setCopieVenduteLibro(0);
		libro.setBestSellerBook(false);
		libro.setAutore(autoreService.getAutore(libroDto.getIdAutore()));
		
		return libroRepository.save(libro);
	}
	
	public LibroEntity aggiornaConto(Long id, LibroEntity libroEntity) {
		LibroEntity libro = getLibro(id);
		if(libro != null) {
			libro.setCopieVenduteLibro(libroEntity.getCopieVenduteLibro() + 1);
			return libroRepository.save(libro);
		}
		return null;
	}
	
	public List<LibroEntity> getLibriAutorePrezzo(){
		return libroRepository.getLibriAutorePrezzo();
	}
	
	public LibroEntity updateCopieVendute(Long id, LibroEntity libroEntity) {
		LibroEntity libro = getLibro(id);
		if(libro != null) {
			libro.setCopieVenduteLibro(libroEntity.getCopieVenduteLibro() + 1);
			return libroRepository.save(libro);
		}
		return null;
	}
	
    public LibroEntity scontoLibro(LibroEntity libro) {
        if (libro != null) {
        	libro.setCopieVenduteLibro(libro.getCopieVenduteLibro() + 1);
            if (libro.getCopieVenduteLibro() >= 3) {
            	libro.setBestSellerBook(true);
            }
            if (libro.isBestSellerBook() && libro.getDataPubblicazioneLibro().isBefore(LocalDate.now().minusYears(10))) {
            	libro.setPrezzoLibro(libro.getPrezzoLibro() * 0.8);
            }
            return libroRepository.save(libro);
        }
        return null;
    }
	
	public void deleteLibro(Long id) {
		libroRepository.deleteById(id);
	}
}
